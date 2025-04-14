package com.btm.webapp.controller;

import com.btm.webapp.models.Client;
import com.btm.webapp.models.ClientDto;
import com.btm.webapp.repositories.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/clients")
public class ClientController
{
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping({"","/"})
    public String getClients(Model model)
    {
        var clients     =  clientRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        model.addAttribute("clients", clients);
        return "clients/index";
    }


    @GetMapping({"","/create"})
    public String CreateClients(Model model)
    {
        ClientDto clientDto = new ClientDto();
        model.addAttribute("clientDto", clientDto);
        return "clients/create";
    }

    @PostMapping({"","/create"})
    public String CreateClients(@Valid @ModelAttribute ClientDto clientDto, BindingResult result )
    {
        if(clientRepository.findByEmail(clientDto.getEmail()) != null){
            result.addError(new FieldError("clientDto","email",clientDto.getEmail(),false,null,null,"Email address is already used"));
        }

        if(result.hasErrors()){
            return "redirect:/clients/create";
        }

        Client client = new Client();
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setAddress(clientDto.getAddress());
        client.setPhone(clientDto.getPhone());
        client.setEmail(clientDto.getEmail());
        client.setState(clientDto.getState());
        client.setCreatedAt(clientDto.getCreatedAt());
        clientRepository.save(client);
        return "redirect:/clients/create";
    }


    @GetMapping({"","/edit"})
    public String EditClients( Model model, @RequestParam int id)
    {
        Client client = clientRepository.findById(id).orElse(null);

        if(client == null){
            return "redirect:/clients/edit";
        }

        ClientDto clientDto = new ClientDto();
        clientDto.setFirstName(client.getFirstName());
        clientDto.setLastName(client.getLastName());
        clientDto.setAddress(client.getAddress());
        clientDto.setPhone(client.getPhone());
        clientDto.setEmail(client.getEmail());
        clientDto.setState(client.getState());
        clientDto.setCreatedAt(client.getCreatedAt());

        model.addAttribute("client", client);
        model.addAttribute("clientDto", clientDto);

        clientRepository.save(client);

        return "clients/edit";
    }


    @PostMapping({"","/edit"})
    public String UpdateClients( Model model,
                               @RequestParam String id,
                               @ModelAttribute ClientDto clientDto,
                               BindingResult result
                               ) {

        String regex = "[^0-9\\s]";
        String i = id.replaceAll(regex, "");

        int number = Integer.parseInt(i);
        Client client = clientRepository.findById(number).orElse(null);

        if(client == null){
            return "redirect:/clients";
        }

        model.addAttribute("client", client);

        if(result.hasErrors()){
            return "redirect:/clients/edit";
        }

        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setAddress(clientDto.getAddress());
        client.setPhone(clientDto.getPhone());
        client.setEmail(clientDto.getEmail());
        client.setState(clientDto.getState());

        try {

            clientRepository.save(client);
        }
        catch(Exception e){

            result.addError(new FieldError("clientDto","email",clientDto.getEmail(),false,null,null,"Email address is already used"));
            return "clients/edit";
        }

        return "redirect:/clients/";
    }



}
