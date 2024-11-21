package com.example.gs2.controller;

import com.example.gs2.domain.Conteudo;
import com.example.gs2.domain.Modulo;
import com.example.gs2.repository.ConteudoRepository;
import com.example.gs2.repository.ModuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ClassController {

    @Autowired
    private ModuloRepository moduloRepository;

    @Autowired
    private ConteudoRepository conteudoRepository;

    @GetMapping("/class")
    public String exibirSalaDeAula(Model model) {
        // Buscar todos os módulos no banco
        List<Modulo> modulos = moduloRepository.findAll();
        model.addAttribute("modulos", modulos);
        return "class";
    }

    @GetMapping("/class/{id}")
    public String exibirConteudoModulo(@PathVariable int id, Model model) {
        // Buscar o módulo com o ID fornecido
        Modulo modulo = moduloRepository.findById(id).orElse(null);
        if (modulo == null) {
            return "404"; // Página de erro caso o módulo não seja encontrado
        }

        // Associando manualmente os conteúdos aos módulos
        List<Conteudo> conteudos = new ArrayList<>();
        if (id == 1) {
            // Módulo 1 tem Conteúdos com ID 1 e 2
            conteudos.add(conteudoRepository.findById(1).orElse(null));
            conteudos.add(conteudoRepository.findById(2).orElse(null));
        } else if (id == 2) {
            // Módulo 2 tem Conteúdos com ID 3 e 4
            conteudos.add(conteudoRepository.findById(3).orElse(null));
            conteudos.add(conteudoRepository.findById(4).orElse(null));
        }

        // Remover conteúdos nulos (caso algum conteúdo não seja encontrado)
        conteudos.removeIf(conteudo -> conteudo == null);

        // Passando os dados para a view
        model.addAttribute("modulo", modulo);
        model.addAttribute("conteudos", conteudos);
        return "modulo-detalhe";
    }
}
