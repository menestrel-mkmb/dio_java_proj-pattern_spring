package edu.project.spring.patterns.service;

import edu.project.spring.patterns.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
@FeignClient(name = "viacep", url = "viacep.com.br/ws")
public interface AddressService {
    @GetMapping("/{cep}/json/")
    public Address getAddress(@PathVariable("cep") String cep);
}
