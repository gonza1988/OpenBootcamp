
package org.example.springej2;

import org.springframework.stereotype.Component;

@Component
public class UserService {
    
    // 1. atributos
     NotificationService notificacion;

    //2. constructores

    public UserService(NotificationService notificacion){
        System.out.println("Ejecutando constructor UserService");
        this.notificacion = notificacion;
    }

}
