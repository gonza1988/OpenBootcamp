
package org.example.springej2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {


    public static void main(String[] args) {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        
        // CONCEPTO 2: cargar un bean dentro de otro bean
        UserService usuario = (UserService) context.getBean("userService");
        System.out.println(usuario.notificacion.imprimirSaludo());
    }
    
}
