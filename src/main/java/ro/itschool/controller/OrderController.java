package ro.itschool.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ro.itschool.entity.Handyman;
import ro.itschool.entity.MyUser;
import ro.itschool.entity.Order;
import ro.itschool.exception.CustomException;
import ro.itschool.service.HandymanService;
import ro.itschool.service.OrderService;
import ro.itschool.service.UserService;
import ro.itschool.util.Constants;

import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @GetMapping("/save/{handymanId}")
    public String saveNewOrder(@PathVariable("handymanId") Long handymanId, RedirectAttributes redirectAttributes) {
        MyUser myUser = userService.getCurrentUser();
        orderService.placeOrder(myUser, handymanId);
        redirectAttributes.addFlashAttribute("message", "The order was placed successfully.");
        return "redirect:/index";
    }

}




