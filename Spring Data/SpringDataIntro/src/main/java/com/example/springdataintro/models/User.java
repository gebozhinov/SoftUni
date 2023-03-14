package com.example.springdataintro.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String username;
    @Column
    private int age;
    @OneToMany( cascade = CascadeType.ALL)
    private final List<Account> accounts;

    public User() {
        this.accounts = new ArrayList<>();
    }
    public User(String username, int age, Account account) {
        this();
        this.username = username;
        this.age = age;
        this.accounts.add(account);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Account> getAccounts() {
        return Collections.unmodifiableList(accounts);
    }
    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

}
