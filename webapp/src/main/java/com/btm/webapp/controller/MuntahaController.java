package com.btm.webapp.controller;



import com.btm.webapp.repositories.MuntahaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.plaf.PanelUI;

@Controller
@RequestMapping("/muntaha")
public class MuntahaController
{
    @Autowired
    private MuntahaRepository clientRepository;

    @GetMapping({"","/"})
    public String getMuntaha(Model model)
    {
        var muntaha     =    clientRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
        model.addAttribute("muntaha", muntaha);
        return "clients/muntaha";
    }
}
