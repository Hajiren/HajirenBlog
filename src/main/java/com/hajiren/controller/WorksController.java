package com.hajiren.controller;

import com.hajiren.service.WorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WorksController {

    @Autowired
    private WorksService worksService;

    @GetMapping("/showVideo/{id}")
    public String showVideo(Model model, @PathVariable int id){
        String url=worksService.getUrlById((long) id);
        model.addAttribute("url",url);
        return ("showVideo");
    }
}
