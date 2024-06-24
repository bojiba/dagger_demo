package com.example.daggerdemo;

import android.util.Log;
import android.widget.Toast;

import javax.inject.Inject;

public class RegistrationManager {
    private User user;

    @Inject
    public RegistrationManager(User user) {
        this.user = user;
    }
    public User registerUser(String username, String password) {
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }
}
