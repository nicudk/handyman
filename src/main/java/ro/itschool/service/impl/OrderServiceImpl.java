package ro.itschool.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.itschool.entity.Handyman;
import ro.itschool.entity.Order;
import ro.itschool.exception.CustomException;
import ro.itschool.repository.OrderRepository;
import ro.itschool.repository.UserRepository;
import ro.itschool.service.OrderService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

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
    public void save(Order order) { orderRepository.save(order);

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
}

