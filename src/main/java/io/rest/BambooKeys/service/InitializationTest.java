package io.rest.BambooKeys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.rest.BambooKeys.entity.Adress;
import io.rest.BambooKeys.entity.OrderedItem;
import io.rest.BambooKeys.entity.Product;
import io.rest.BambooKeys.entity.Questions;
import io.rest.BambooKeys.entity.User;
import io.rest.BambooKeys.enum_.Category;
import io.rest.BambooKeys.enum_.salutation;
import io.rest.BambooKeys.repository.CartRepository;

@Service
public class InitializationTest {
    
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CartService cartService;
    @Autowired 
    private  CartRepository cartRepository;
    @Autowired 
    private OrderedService orderedService;
    @Autowired
    private QuestionsService questionsService;


    public void initUserDB(){
        User  user = new User();
        user.setLastname("Mueller");
        user.setFirstname("max");
        user.setE_mail("max_mueller@gmail.com");
        user.setSalutation(salutation.Mister);
        
        Adress maxAdress = new Adress();
        
        maxAdress.setCity("Reutlingrn");
        maxAdress.setStreet("Reutlinger str");
        maxAdress.setPostCode(764312);
        
        
       user.setAdress(maxAdress);

        //* save user and the Adress
        userService.addUser(user);
        userService.getUsers();
        userService.getUser(1L);
       // userService.deletUSer(1L);
        //userService.deleteALLUser();
        
    }

    public void initProductDB(){

        Product product = new Product();

        product.setName("name");
        product.setMarke("marke");
        product.setAmount(10);
        product.setDescrpetion("descrpetion");
        product.setPrice(100);

        productService.addProduct(product);

        Product product2 = new Product();

        product2.setName("maus");
        product2.setMarke("logitech");
        product2.setDescrpetion("descrption");
        product2.setAmount(10);
        product2.setPrice(50);

        //productService.replaceProduct(product2, 2L);
        productService.addProduct(product2); 

        productService.getProducts();
        productService.getProduct(2L);
        //productService.deleteProduct(2L);
        //productService.deleteALLProduct();

       cartService.addItemToCart(2, 1L,2L);
        //Cascade sorgt dafür auch, dass item abgespeichert werden
        OrderedItem orderedItem  =new OrderedItem();
       // orderedItem.setOrederedItems(cartService.getMyCart(userService.getUser(1L));
       // cartService.checkout( cartRepository.findById(4L).get(), 1L);
       cartService.checkout(1L);
    }

    public void initRequest(){
        User  user = new User();
        user.setLastname("lastname");
        user.setFirstname("firstname");
        user.setE_mail("lastname@gmail.com");
        user.setSalutation(salutation.Mister);
        
        Adress maxAdress = new Adress();
        
        maxAdress.setCity("Reutlingen");
        maxAdress.setStreet("Reutlinger str");
        maxAdress.setPostCode(764312);
        
        
       user.setAdress(maxAdress);

        //* save user and the Adress
        userService.addUser(user);
        
      

        Questions questions = new Questions();
        questions.setCategory(Category.RETOURE);
        questions.setDescrpetion("descrpetion");
        questions.setSubject("Defect");
        questions.questionsWitUser(user);
        Questions question1 = new Questions();
        question1.setCategory(Category.RETOURE);
        question1.setDescrpetion("descrpetion");
        question1.setSubject("Defect");
        question1.questionsWitUser(user);
        questionsService.AddRequest(1L, questions);
        questionsService.updateReuest(question1, 8L);
        questionsService.existingRequest(8L);
        questionsService.getAllRequestFromUser(1L);
        questionsService.getRequestfromUser(1L, 8L);
       // questionsService.deleteARequestFromUSer(8L, 1L);
        //questionsService.deleteAllUserRequest(1L);
    }
}
