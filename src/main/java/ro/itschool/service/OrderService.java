package ro.itschool.service;

import org.springframework.stereotype.Service;
import ro.itschool.entity.Order;
import ro.itschool.exception.CustomException;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderService {

    void deleteById(Long id) throws CustomException;

    void save(Order order);

    List<Order> getAllOrders();

   Optional<Order> findById (Long id);

    void createOrder(Order order);

    void update (Order order);

    List<Order> getAllOrdersByUserId(Long userId);

//    void transferMoney(TransferMoneyRequest transferMoneyRequest) throws NotEnoughMoneyInAccount;
//
//    void payABill (TransferMoneyRequest transferMoneyRequest) throws NotEnoughMoneyInAccount;
}
