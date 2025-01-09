package com.CRUD2.StoreProject1.controller;

import com.CRUD2.StoreProject1.models.Client;
import com.CRUD2.StoreProject1.models.ClientDto;
import com.CRUD2.StoreProject1.repository.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        return "clients/index";
    }

    @GetMapping("/create")
    public String showCreatePage(Model model) {
        ClientDto clientDto = new ClientDto();
        model.addAttribute("clientDto", clientDto);
        return "clients/create";
    }

    @PostMapping("/create")
    public String createClient(
            @Valid @ModelAttribute ClientDto clientDto,
            BindingResult result) {
        if (repo.getClient(clientDto.getEmail()) != null) {
            result.addError(
                    new FieldError("clientDto", "email", clientDto.getEmail()
                            , false, null, null, "Email address is already used")
            );

        }

        if(result.hasErrors()){
            return "clients/create";
        }
        Client client = new Client();
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setEmail(clientDto.getEmail());
        client.setPhone(clientDto.getPhone());
        client.setAddress(clientDto.getAddress());
        client.setCreatedAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        repo.createClient(client);

        return "redirect:/clients";
    }

    @GetMapping("/edit")
    public String showEditpage(
            Model model,
            @RequestParam int id){
        Client client = repo.getClient(id);
        if(client==null){
            return "redirect:/clients";
        }
        model.addAttribute("client", client);
        ClientDto clientDto = new ClientDto();
        client.setFirstName(client.getFirstName());
        client.setLastName(client.getLastName());
        client.setEmail(client.getEmail());
        client.setPhone(client.getPhone());
        client.setAddress(client.getAddress());
        model.addAttribute("clientDto", clientDto);


        return "clients/edit";
    }
    @PostMapping("/edit")
    public String updateClient(
            Model model,
            @RequestParam int id,
            @Valid @ModelAttribute ClientDto clientDto,
            BindingResult result
    ){

        Client client = repo.getClient(id);
        if(client==null){
            return "redirect:/clients";
        }
        model.addAttribute("client",client);
        if(result.hasErrors()){
            return "clients/edit";
        }
        //update client details
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setEmail(clientDto.getEmail());
        client.setPhone(clientDto.getPhone());
        client.setAddress(clientDto.getAddress());
        repo.updateClient(client);
        return "redirect:/clients";

    }


}


