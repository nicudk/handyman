package ro.itschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.itschool.CSV.SetupCSV;

@Repository
public interface SetupCSVRepository extends JpaRepository < SetupCSV,Integer> {

}
