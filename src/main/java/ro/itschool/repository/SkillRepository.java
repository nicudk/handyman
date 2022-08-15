package ro.itschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.itschool.entity.Handyman;
import ro.itschool.entity.MyUser;
import ro.itschool.entity.Role;
import ro.itschool.entity.Skill;

import java.util.Set;
@Repository
public interface SkillRepository extends  JpaRepository<Skill, Long> {
    Skill findByName(String name);
    Set<Skill> findByHandyman(Handyman handyman);
}



