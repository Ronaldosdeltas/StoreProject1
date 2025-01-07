package com.CRUD2.StoreProject1.controller;

import com.CRUD2.StoreProject1.models.Client;
import com.CRUD2.StoreProject1.models.ClientDto;
import com.CRUD2.StoreProject1.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientRepository repo;

    @GetMapping
    public String getClient(Model model) {
        List<Client> clients = repo.getClients();
        model.addAttribute("clients", clients);
        return  "clients/index";
    }
    @GetMapping
    public  String showCreatePage(Model model){
        ClientDto clientDto = new ClientDto();
        model.addAttribute("clientDto",clientDto);
        return "clients/create";
    }

}
