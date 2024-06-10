package com.aulabd2.aulabd2.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.aulabd2.aulabd2.model.Cliente;
import com.aulabd2.aulabd2.model.ClienteService;

@Controller
public class IndexController {
    
    @Autowired private ApplicationContext context;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/cadastrar")
    public String cadastrar(Model model){
        model.addAttribute("cliente", new Cliente());
        return "cadastro";
    }

    @PostMapping("/cadastrar")
    public String cadastrar(Model model, @ModelAttribute Cliente cli){
        ClienteService cs = context.getBean(ClienteService.class);
		cs.inserirCliente(cli);
        return "home";
    }

    @GetMapping("/listar")
    public String listar(Model model){
        ClienteService cs = context.getBean(ClienteService.class);
        List<Map<String,Object>> lista = cs.listarClientes();
        model.addAttribute("lista", lista);
        return "lista";
    }

    @GetMapping("/editar/{id}")
    public String editar(Model model, @PathVariable Integer id){
        ClienteService cs = context.getBean(ClienteService.class);
        List<Map<String,Object>> cli = cs.obterCliente(id);
        model.addAttribute("cliente", new Cliente(cli.get(0)));
        return "editar";
    }

    @PostMapping("/editar/{id}")
    public String editar(Model model, @ModelAttribute Cliente cli, @PathVariable Integer id){
        ClienteService cs = context.getBean(ClienteService.class);
		cs.atualizarCliente(id, cli);
        return "redirect:/listar";
    }

    @PostMapping("/deletar/{id}")
    public String deletar(Model model, @PathVariable Integer id){
        ClienteService cs = context.getBean(ClienteService.class);
		cs.apagarCliente(id);
        return "redirect:/listar";
    }

}
