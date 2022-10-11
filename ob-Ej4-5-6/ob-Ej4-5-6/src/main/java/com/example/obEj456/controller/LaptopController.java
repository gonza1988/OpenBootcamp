
package com.example.obEj456.controller;

import com.example.obEj456.entities.Laptop;
import com.example.obEj456.repository.LaptopRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LaptopController {
    
    //atributos
    private LaptopRepository laptopRepository;
    
    //constructores
    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }
    
    
    /**
     * http://localhost:8081/api/laptops
     * @return
     */
    @GetMapping("/api/laptops")
    public List<Laptop> findAll(){
        // recuperar y devolver los libros de base de datos
        return laptopRepository.findAll();
    }
    
    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id){

        Optional<Laptop> laptopOpt = laptopRepository.findById(id);
       
        return laptopOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    // crear una nueva laptop en base de datos
    @PostMapping("/api/laptops")
    public Laptop create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers){ 
        System.out.println(headers.get("User-Agent"));         
        // guardar laptop recibida por parámetro en la base de datos
        return laptopRepository.save(laptop);
    }
    
}
