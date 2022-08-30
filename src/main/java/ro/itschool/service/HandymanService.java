package ro.itschool.service;

import ro.itschool.entity.Handyman;


import java.util.List;
import java.util.Optional;

public interface HandymanService {

    Handyman findHandymanByEmail(String email);

    Handyman findUserByUserName(String username);


    List<Handyman> findAll();

    void deleteById(long id);

    Handyman saveHandyman(Handyman handyman);

    void saveAll(List<Handyman> handymenList);

    Optional<Handyman> findHandymanById(Long id);

    public void addOrderedHandyman(Handyman handyman);

    void updateHandyman(Handyman handyman);

    List<Handyman> searchHandyman(String keyword);

}

