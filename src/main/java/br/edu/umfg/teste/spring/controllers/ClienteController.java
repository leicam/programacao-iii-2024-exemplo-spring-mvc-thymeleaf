package br.edu.umfg.teste.spring.controllers;


import br.edu.umfg.teste.spring.entities.Cliente;
import br.edu.umfg.teste.spring.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClienteController {
    private ClienteRepository clienteRepository;

    @Autowired
    public ClienteController( ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Página inicial
    @GetMapping("/")
    public String mostrarIndex() {
        return "index"; // Retorna a página index.html
    }

    // Página para cadastro de cliente
    @GetMapping("/cadastroCliente")
    public String mostrarCadastro(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cadastroCliente"; // Retorna a página cadastroCliente.html
    }

    // Página para listar clientes
    @GetMapping("/listaCliente")
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteRepository.findAll());
        return "listaCliente"; // Retorna a página listaCliente.html
    }

    // Método para salvar o cliente após o cadastro
    @PostMapping("/clientes")
    public String cadastrarCliente(@ModelAttribute Cliente cliente) {
        clienteRepository.save(cliente);
        return "redirect:/listaCliente";  // Redireciona para a página de listagem de clientes
    }
}