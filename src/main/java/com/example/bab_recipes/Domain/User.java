package com.example.bab_recipes.Domain;

import jakarta.persistence.*;

@Table(name = "User")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long userId;

    @Column(name = "userEmail", nullable = false, length = 100)
    private String userEmail;

    @Column(name = "userName", nullable = false, length = 100)
    private String userName;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public Long getUserId() {
        return userId;
    }
}
