package edu.project.spring.patterns.service;

import edu.project.spring.patterns.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "viacep.com.br/ws")
public interface AddressService {
    @GetMapping("{cep}/json/")
    public Address getAddress(@PathVariable("cep") String cep);
}
