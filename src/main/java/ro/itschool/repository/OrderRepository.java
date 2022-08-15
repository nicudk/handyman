package ro.itschool.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ro.itschool.entity.Order;
import java.util.List;
import java.util.Optional;


public interface OrderRepository extends JpaRepository<OrderRepository, Long > {

    @Transactional
    void deleteById(Long id);
    void save(Order order);
    void  findById(Long id);

    Optional<OrderRepository> findById(Long id);

    @Query(
            value = "SELECT * FROM order WHERE user_id = ?",
            nativeQuery = true)
    List<Order> findByUserId(Long userId);
}
