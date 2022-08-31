package ro.itschool.startup;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import ro.itschool.CSV.HandymanCSVDto;
import ro.itschool.entity.Handyman;
import ro.itschool.entity.MyUser;
import ro.itschool.entity.Role;

import ro.itschool.service.HandymanService;
import ro.itschool.service.OrderService;
import ro.itschool.service.UserService;
import ro.itschool.util.Constants;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class RunAtStartup {
    private static final String Path = "src\\main\\resources\\handyman.csv";
    @Autowired
    private UserService userService;
    @Autowired
    HandymanService handymanService;
    @Autowired
    OrderService orderService;

    @EventListener(ContextRefreshedEvent.class)
    public void contextRefreshedEvent() {

        MyUser myUser = new MyUser();
        myUser.setUsername("user0");
        myUser.setPassword("user0");
        myUser.setRandomToken("randomToken");
        final Role roleUser = new Role(Constants.ROLE_USER);
        final Set<Role> roles = new HashSet<>();
        roles.add(roleUser);
        myUser.setRoles(roles);
        myUser.setEnabled(true);
        myUser.setAccountNonExpired(true);
        myUser.setAccountNonLocked(true);
        myUser.setCredentialsNonExpired(true);
        myUser.setEmail("user@gmail.com");
        myUser.setFullName("Userescu Userila");
        myUser.setPasswordConfirm("user0");
        myUser.setRandomTokenEmail("randomToken");

        userService.saveUser(myUser);
//        Handyman handyman = new Handyman();
        List<HandymanCSVDto> handymanCSVList = readDataFromCSVFile();
        List<Handyman> handymanList = new ArrayList<>();

        // Map HandymanCSVDto to Handyman
        for (HandymanCSVDto handymanCSVDto : handymanCSVList) {
            Handyman handyman = new Handyman(); // create new Handyman
            // assign every value
            handyman.setId(handymanCSVDto.getId());
            handyman.setName(handymanCSVDto.getName());
            handyman.setSurname(handymanCSVDto.getSurname());
            handyman.setUsername(handymanCSVDto.getUsername());
            handyman.setSkill(handymanCSVDto.getSkill());
            handyman.setExperience(handymanCSVDto.getExperience());
            handyman.setRating(handymanCSVDto.getRating());
            handyman.setEmail(handymanCSVDto.getEmail());
            handyman.setPhoneNumber(handymanCSVDto.getPhoneNumber());
            handyman.setServicePrice(handymanCSVDto.getServicePrice());

            handymanList.add(handyman);
        }



        handymanService.saveAll(handymanList);


    }

    public static List<HandymanCSVDto> readDataFromCSVFile() {
        try {
            return new CsvToBeanBuilder<HandymanCSVDto>(new FileReader(Path))
                    .withType(HandymanCSVDto.class)
                    .withSkipLines(1)
                    .build()
                    .parse();

        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();

    }

    private void saveAdminUser() {

        MyUser myUser = new MyUser();
        myUser.setUsername("admin");
        myUser.setPassword("admin");
        myUser.setRandomToken("randomToken");
        final Set<Role> roles = new HashSet<>();
        roles.add(new Role(Constants.ROLE_USER));
        roles.add(new Role(Constants.ROLE_ADMIN));
        myUser.setRoles(roles);
        myUser.setEnabled(true);
        myUser.setAccountNonExpired(true);
        myUser.setAccountNonLocked(true);
        myUser.setCredentialsNonExpired(true);
        myUser.setEmail("user2@gmail.com");
        myUser.setFullName("Userescu2 Userila2");
        myUser.setPasswordConfirm("admin");
        myUser.setRandomTokenEmail("randomToken");


        userService.saveUser(myUser);
    }

}

