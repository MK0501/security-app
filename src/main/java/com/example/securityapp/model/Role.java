package com.example.securityapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "roledetails")
public class Role {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "rolename")
    private String roleName;
}
