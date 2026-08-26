package com.ecom.user.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String username;
    private String email;
    private String password;
    private String mobileNo;
    private List<Role> role;
    @JsonIgnore
    @OneToMany(
            mappedBy = "user",
            cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Address> address;
}
