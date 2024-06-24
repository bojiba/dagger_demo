package com.example.daggerdemo;

import dagger.Provides;
@dagger.Module
public class Module {

    private String username;
    private String password;

    public Module(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Provides
    User provideUser() {
        return new User(username, password);
    }

}
