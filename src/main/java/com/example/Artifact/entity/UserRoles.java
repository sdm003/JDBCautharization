package com.example.Artifact.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String RoleName;
    @ManyToOne
    @JoinColumn(name="users_id")
    Users user;

    public UserRoles(String roleName, Users user) {
        RoleName = roleName;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String roleName) {
        RoleName = roleName;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
