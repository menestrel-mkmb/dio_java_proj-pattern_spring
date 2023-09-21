package edu.project.spring.patterns.model;

import javax.persistence.*;

@Entity
@Table(name = "tab_user")
public class User {
    @Id
    private Long id;
    @ManyToOne
    private String endereco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
