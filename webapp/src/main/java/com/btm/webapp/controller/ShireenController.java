package com.btm.webapp.controller;


import com.btm.webapp.repositories.ShireenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shireen")
public class ShireenController {
  @Autowired
  private ShireenRepository shireenRepository;
  @GetMapping({"","/"})

  public String getShireen(Model model)
  {

      var shireen = shireenRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
       model.addAttribute("shireen", shireen);
      return "clients/shireen";
  }

}
