package ro.itschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.itschool.entity.Handyman;

import java.util.List;

public interface HandymanRepository extends JpaRepository  <  Handyman, Long>{


        Handyman findByUsernameIgnoreCase(String username);

        Handyman findByEmail(String username);



        @Query(
                value = "SELECT * FROM handyman h WHERE h.username LIKE %:keyword% OR h.full_name LIKE %:keyword% OR h.email LIKE %:keyword% " +
                        "OR h.user_id LIKE %:keyword%",
                nativeQuery = true)
        List<Handyman> searchHandyman (@Param("keyword") String keyword);

    }

