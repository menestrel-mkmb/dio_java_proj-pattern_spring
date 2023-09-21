package edu.project.spring.patterns.controller;

import edu.project.spring.patterns.model.User;
import edu.project.spring.patterns.service.AddressService;
import edu.project.spring.patterns.service.UserService;
import edu.project.spring.patterns.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
*
* Utilizando o padrão de projeto de estrutural "facade"
* é possível fazer simplificações de objetos e abstrações
* para facilitar e enxutar o desenvolvimento e entendimento
* do projeto e da regra de negócio. Por exemplo, nesse
* projeto não é necessário pedir explicitamente o endereço
* ao usuário pois ao preencher automaticamente a partir
* do CEP, criamos uma fachada simplificada sobre o usuário
* e também evita-se digitalção inccoreta dis dados e traz
* facilidade à verificação do dado real e armazenamento.
*
* Usar o ViaCep para preencher o endereço
*
* Utilizando o padrão de projeto de criação "singleton"
* é possível utilizar instâncias estáticas e economizar
* recursos computacionais, bem como garantir o uso do mesmo
* objeto e evitar algumas falhas de segurança por abuso
* de stack overflow.
*
* Toda entidade que contiver o Autowired é singleton
*
* */
@RestController
@RequestMapping("users")
public class UserRestController {
    @Autowired
    private UserServiceInterface userService;

    @GetMapping
    public ResponseEntity<Iterable<User>> findAllUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> findUserbyId(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        userService.createUser(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        userService.updateUser(id, user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

}
