package io.samisnotinsane.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by sameen on 20/07/2017.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("springConfig.xml");
        Restaurant restaurant = (Restaurant) appContext.getBean("restaurantBean");
        restaurant.greetCustomer();

    }
}
