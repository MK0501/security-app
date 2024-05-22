package com.example.securityapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "roledetails")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "roleid")
    private Long roleId;

    @Column(name = "rolename")
    private String roleName;
}
