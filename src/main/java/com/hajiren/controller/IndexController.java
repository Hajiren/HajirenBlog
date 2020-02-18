package com.hajiren.controller;

import com.hajiren.service.MessageService;
import com.hajiren.service.WorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
public class IndexController {

    @Autowired
    private WorksService worksService;

    @Autowired
    private MessageService messageService;


    @GetMapping({"/index","/"})
    public String index(Model model,HttpSession session) throws IOException {
        model.addAttribute("works",worksService.getAllWorks());

        Object sent=session.getAttribute("sent");
        if(sent!=null && sent.equals(true)){
            model.addAttribute("sent",1);
            session.setAttribute("sent",false);
        }
        return "index";
    }

    @PostMapping("/")
    public String sentMessage(Model model, HttpSession session,
                              @RequestParam("c_name") String name,
                              @RequestParam("c_email") String email,
                              @RequestParam("c_message") String message) throws Exception{
        messageService.insertMessage(name,email,message);
        session.setAttribute("sent",true);
        return "redirect:/#contact";
    }
}
