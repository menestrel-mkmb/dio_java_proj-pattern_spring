package edu.project.spring.patterns.model;

import javax.persistence.*;

@Entity
@Table(name = "tab_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne
    private Address address;


}
