//Pun created 
package main;

import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

class Start12 {

    public static void main(String[] data) {

        //set up application
        ApplicationContext context;
        context = SpringApplication.run(Setup.class);

        while (true) {                      //condition is always true
            //input product name 
            System.out.println("Please enter your fav menu: ");
            Scanner sc = new Scanner(System.in);
            String productName = sc.next(); //input cake  

            //get bean from productname and show bean information
            try {
                Menu p = (Menu) context.getBean(productName);
                System.out.println(p.getName());
                System.out.println(p.getPrice());
            } catch (Exception e) {
                System.out.println("Your product name " + productName + " is not found. Please try again");
            }
        }

    }
}

@SpringBootApplication
class Setup {

    @Bean("cake")
    Menu createMenuCake() {
        Menu m = new Menu();
        m.setName("Vegan Cacao Cake");
        m.setPrice(80.0);
        return m;
    }

    @Bean("cookies")
    Menu createMenuCookies() {
        main.Menu m = new main.Menu();
        m.setName("chocchip cookies");
        m.setPrice(35.0);
        return m;
    }

}

class Menu {

    String name;

    void setName(String m) {
        name = m;
    }

    String getName() {
        return name;
    }

    double price;

    void setPrice(double p) {
        this.price = p;   //no need to put prefix "this", because of different parameter
    }

    double getPrice() {
        return price;
    }

}
