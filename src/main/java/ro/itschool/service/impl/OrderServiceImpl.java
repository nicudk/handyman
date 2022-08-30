package ro.itschool.service.impl;

import org.apache.commons.collections4.set.ListOrderedSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.itschool.entity.Handyman;
import ro.itschool.entity.MyUser;
import ro.itschool.entity.Order;
import ro.itschool.exception.CustomException;
import ro.itschool.repository.OrderRepository;
import ro.itschool.repository.UserRepository;
import ro.itschool.service.HandymanService;
import ro.itschool.service.OrderService;
import ro.itschool.service.UserService;

import java.time.LocalDateTime;
import java.util.*;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HandymanService handymanService;


    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
//
//    public void deleteById(Long id) throws CustomException {
//       Order order = orderRepository.deleteById(id);
//        if (order != null && order.getHandyman().contains(new Handyman()))
//            throw new CustomException("Please assure  that you delete the handyman");
//        orderRepository.deleteById(id);
//
//    }

    @Override
    @Transactional
    public void placeOrder(MyUser myUser, Long handymanId) {
        Handyman handyman = handymanService.findHandymanById(handymanId).get();

        Order orderToSave = new Order();
        orderToSave.setAmount(handyman.getServicePrice());
        orderToSave.setMyUser(myUser);
        orderToSave.setHandymanSet(new HashSet<>(Arrays.asList(handyman)));

        orderRepository.save(orderToSave);

        handyman.setOrder(orderToSave);
        handymanService.saveHandyman(handyman);
    }

    @Override
    public List<Order> getAllOrders() {
       return orderRepository.findAll() ;
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }


    @Override
    public void createOrder(Order order) {order.setCreatedAt(LocalDateTime.now());
        orderRepository.save(order);
    }

    @Override
    public void update(Order order) {

    }

    @Override
    public List<Order> getAllOrdersByUserId(Long userId) {return orderRepository.findByUserId(userId);}

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> findByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}

