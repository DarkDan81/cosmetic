package com.costetics.backend.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "User")
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "role_id",
            nullable = false,
            columnDefinition = "BIGINT"
    )
    private Long roleId;

    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;

    @Column(
            name = "time_creation",
            nullable = false,
            columnDefinition = "TIMESTAMP"
    )
    private Timestamp timeCreation;

    @Column(
            name = "birthday",
            nullable = false,
            columnDefinition = "TIMESTAMP"
    )
    private Timestamp birthday;

    @Column(
            name = "city",
            columnDefinition = "TEXT"
    )
    private String city;

    @Column(
            name = "mail",
            nullable = false,
            columnDefinition = "TEXT",
            unique = true
    )
    private String mail;

    @Column(
            name = "password",
            nullable = false,
            columnDefinition = "LONGTEXT"
    )
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    public User() {
    }

    public User(Long id, Long roleId, String firstName, String lastName, Timestamp timeCreation, String city, Timestamp birthday, String mail, String password) {
        this.id = id;
        this.roleId = roleId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.timeCreation = timeCreation;
        this.birthday = birthday;
        this.mail = mail;
        this.password = password;
        this.city = city;
    }

    public User(Long roleId, String firstName, String lastName, Timestamp timeCreation, Timestamp birthday, String city, String mail, String password) {
        this.roleId = roleId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.timeCreation = timeCreation;
        this.birthday = birthday;
        this.mail = mail;
        this.password = password;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Timestamp getTimeCreation() {
        return timeCreation;
    }

    public void setTimeCreation(Timestamp timeCreation) {
        this.timeCreation = timeCreation;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", timeCreation=" + timeCreation +
                ", birthday=" + birthday +
                ", city='" + city + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
