package com.cybersoft.uniclub.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name="user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="full_name")
    private String fullName;

    @ManyToOne
    @JoinColumn(name="id_role")
    private RoleEntity role;

    /*
    - 1 role có nhiều user thì phải ánh xạ ngược lại
    ánh xạ ở bảng user với anotation @ManyToOne
    - ánh xạ ở bảng role
    @OneToMany(mappedBy = "role")
    private List<UserEntity> users;
     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

}
