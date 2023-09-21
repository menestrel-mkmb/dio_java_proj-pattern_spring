package edu.project.spring.patterns.service;

import edu.project.spring.patterns.model.User;

/*
*
* Utilizando padrão de projeto de comportamento "strategy"
* é possível trazer múltiplas abordagens para uma interface
* a depender da necessidade de diferentes fornecedores ou
* consumidores. Por exemplo, nesse projeto, poderia ser
* utilizado para diferenciar tipos de usuários e serviços.
*
* Identificação de Usuários:
*   Natural brasileiro (possui CPF)
*   Estrangeiro (passaporte)
* Tipo de fonte de dados do usuário:
*   API ViaCep
*   API Correios
*
* Independente da forma que o dado chega, ou da forma que
* ele é discriminado, existem diversas ações em comuns
* que devem ser mantidas iguais, para essas usamos interface.
*
* */
public interface UserServiceInterface {
    Iterable<User> findAllUsers();
    User findUserById(Long id);

    //CRUD OPERATIONS LAMBDA
    void createUser(User user);
    default User readUser(Long id) {
        return findUserById(id);
    }
    void updateUser(Long id, User user);
    void deleteUser(Long id);
}
