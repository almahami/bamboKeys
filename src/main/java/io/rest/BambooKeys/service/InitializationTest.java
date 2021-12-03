package io.rest.BambooKeys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.rest.BambooKeys.entity.Adress;
import io.rest.BambooKeys.entity.User;
import io.rest.BambooKeys.enum_.salutation;

@Service
public class InitializationTest {
    
    
    
    private User  user = new User();

    private Adress maxAdress = new Adress();
   
    @Autowired
    private UserService userService;
    
   
    public void initUserDB(){
        
        user.setLastname("Mueller");
        user.setFirstname("max");
        user.setE_mail("max_mueller@gmail.com");
        user.setSalutation(salutation.Mister);
        maxAdress.setCity("Reutlingrn");
        maxAdress.setCity("Reutlinger str");
        maxAdress.setPostCode(764312);
        
        
       user.setAdress(maxAdress);

        //* save user and the Adress
        userService.addUSer(user);
        userService.deletUSer(1L);
       

    }
}
