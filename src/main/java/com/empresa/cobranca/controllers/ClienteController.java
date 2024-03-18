package com.empresa.cobranca.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.empresa.cobranca.model.Cliente;
import com.empresa.cobranca.model.StatusCliente;
import com.empresa.cobranca.repository.ClienteRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteRepository clienteRepository;

    @RequestMapping("/novo")
    public ModelAndView cliente(){
        ModelAndView mav = new ModelAndView("cadastroCliente");
        mav.addObject(new Cliente());
        return mav;
    }

    @PostMapping(value = "/salvar")
    public String salvar(@Valid Cliente cliente, Errors erros, RedirectAttributes redirectAttributes){
        if(erros.hasErrors()){
            return "cadastroCliente";
        }
        
        clienteRepository.save(cliente);
        redirectAttributes.addFlashAttribute("mensagem","Cliente salvo com sucesso!!!");
        return "redirect:/clientes/novo";
    }

    @GetMapping(value = "/listarClientes")
    public ModelAndView pesquisarCliente(){
        List<Cliente> listarClientes = clienteRepository.findAll();
        ModelAndView mav = new ModelAndView("pesquisaCliente");
        mav.addObject("clientes", listarClientes);
        return mav;
    }

    @ModelAttribute("status")
    public List<StatusCliente> todosStatus(){
        return Arrays.asList(StatusCliente.values());
    }

    @GetMapping(value = "/editar/{codigo}")
    public ModelAndView editar(@PathVariable(name = "codigo") Long codigo){
        Cliente clienteAtual = clienteRepository.findById(codigo).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado no banco de dados"));
        ModelAndView modelAndView = new ModelAndView("cadastroCliente");
        modelAndView.addObject("cliente", clienteAtual);
        return modelAndView;
    }

    @DeleteMapping()
    public String deletar(@PathVariable(name = "codigo") Long codigo){
        Cliente clienteAtual = clienteRepository.findById(codigo).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado no banco de dados"));
        clienteRepository.delete(clienteAtual);
        return "redirect:/cadastroCleinte";
    }


}
