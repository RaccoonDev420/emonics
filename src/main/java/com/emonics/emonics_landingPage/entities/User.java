package com.emonics.emonics_landingPage.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "prospectos")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre_completo")
    private String fullName;
    @Column(name = "telefono")
    private String phone;
    @Column(name = "correo")
    private String email;
    @Column(name = "skill_primaria")
    private String primarySkill;
    @Column(name = "skill_secundaria")
    private String secondarySkill;

    public User() {
    }

    public User(Integer id, String fullName, String phone, String email, String primarySkill, String secondarySkill) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.primarySkill = primarySkill;
        this.secondarySkill = secondarySkill;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrimarySkill() {
        return primarySkill;
    }

    public void setPrimarySkill(String primarySkill) {
        this.primarySkill = primarySkill;
    }

    public String getSecondarySkill() {
        return secondarySkill;
    }

    public void setSecondarySkill(String secondarySkill) {
        this.secondarySkill = secondarySkill;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", primarySkill='" + primarySkill + '\'' +
                ", secondarySkill='" + secondarySkill + '\'' +
                '}';
    }
}
