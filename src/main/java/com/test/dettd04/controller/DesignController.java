package com.test.dettd04.controller;

import com.test.dettd04.entity.Estado;
import com.test.dettd04.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class DesignController {

    @Autowired
    private EstadoService estadoService;
    @GetMapping("/")
    public String getFormulario(Model model) {
        List<Estado> estados = estadoService.findAll();
        model.addAttribute("estados", estados);
        return "index";
    }
}
