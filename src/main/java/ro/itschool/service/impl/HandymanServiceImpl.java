package ro.itschool.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.itschool.email.EmailBodyService;
import ro.itschool.email.EmailSender;
import ro.itschool.entity.Handyman;
import ro.itschool.entity.Skill;
import ro.itschool.repository.HandymanRepository;
import ro.itschool.repository.SkillRepository;
import ro.itschool.service.HandymanService;

import java.util.*;



    @Service
    public  class HandymanServiceImpl implements HandymanService {

        private final HandymanRepository handymanRepository;
        private final SkillRepository skillRepository;

        @Autowired
        EmailBodyService emailBodyService;

        @Autowired
        EmailSender emailSender;

        @Autowired
        public HandymanServiceImpl(HandymanRepository handymanRepository, SkillRepository skillRepository) {
            this.handymanRepository = handymanRepository;
            this.skillRepository = skillRepository;
        }

        @Override
        public Handyman findHandymanByEmail(String email) {
            return handymanRepository.findByEmail(email);
        }

        @Override
        public Handyman findUserByUserName(String username) {
            return handymanRepository.findByUsernameIgnoreCase(username);
        }

        @Override
        public List<Handyman> findAll() {
            return handymanRepository.findAll();
        }

        @Override
        public void deleteById(long id) {
            handymanRepository.deleteById(id);
        }

        @Override
        public Handyman saveHandyman(Handyman h) {
            Handyman handyman = new Handyman(h);
            h.getSkills().forEach (skill -> {
                final Skill skillByName=skillRepository.findByName(skill.getName());
                if(skillByName==null)
                    handyman.getSkills().add(skillRepository.save(skill));
                else{
                    skill.setId(skillByName.getId());
                }
            });
            return handymanRepository.save(handyman);

        }

        @Override
        public void saveAll(List<Handyman> handymenList) {
            handymanRepository.saveAll(handymenList);
        }

        @Override
        public Optional<Handyman> findHandymanById(Long id) {
            return handymanRepository.findById(id);
        }

        @Override
        @Transactional
        public void addOrderedHandyman(Handyman handyman) {
            handymanRepository.save(handyman);
        }

        @Override
        public void updateHandyman(Handyman handyman) {

        }

        @Override
        public List<Handyman> searchHandyman(String keyword) {
            return null;
        }
    }