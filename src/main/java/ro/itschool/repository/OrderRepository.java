package ro.itschool.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.itschool.entity.Order;
import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long > {

    @Transactional
    void deleteById(Long id);

//    void create(Order order);



    @Query(
            value = "SELECT * FROM order WHERE user_id = ?",
            nativeQuery = true)
    List<Order> findByUserId(Long userId);
}
