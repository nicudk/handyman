package ro.itschool.service.impl;

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


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public void deleteById(Long id) throws CustomException {
        Order order = orderRepository.findById(id);
        if (order != null && order.getHandyman().contains(new Handyman()))
            throw new CustomException("Please asure that you take a handyman");
        orderRepository.deleteById(id);

    }

    @Override
    public void save(Order order) { orderRepository.save(order);

    }

    @Override
    public List<Order> getAllOrders() {return orderRepository.findAll();}

    @Override
    public Order findById(Long id) {return orderRepository.findById(id);}

    @Override
    public Order create(Order order) {order.setDateCreated(LocalDateTime.now())
        return this.orderRepository.save(order);
    }

    @Override
    public void update(Order order) {

    }

    @Override
    public List<Order> getAllOrdersByUserId(Long userId) {return orderRepository.findByUserId(userId);}
}

