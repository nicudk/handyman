package ro.itschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.itschool.entity.Handyman;
import ro.itschool.entity.MyUser;
import ro.itschool.entity.Order;
import ro.itschool.service.HandymanService;
import ro.itschool.service.UserService;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private HandymanService handymanService;

    @RequestMapping(value = {"/index"})
    public String index(Model model) {
        List<Handyman> handymen = handymanService.findAll();
        model.addAttribute("handymen", handymen);
        return "index";
    }


}
