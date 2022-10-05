
package org.example.springej2;

import org.springframework.stereotype.Component;

@Component
public class NotificationService {
    
    public NotificationService(){
        System.out.println("Ejecutando constructor NotificationService");
    }
    
    public String imprimirSaludo(){
        return "Hola Mundo desde NotificationService";
    }
}
