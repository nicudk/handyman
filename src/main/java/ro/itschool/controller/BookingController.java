package ro.itschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.itschool.entity.MyUser;
import ro.itschool.entity.Order;
import ro.itschool.service.OrderService;
import ro.itschool.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public String listOrders(Model model) {
        MyUser myUser = userService.getCurrentUser();
        List<Order> orderList = orderService.findByUserId(myUser.getId());
        model.addAttribute("orders", orderList);
        return "booking";
    }

}
