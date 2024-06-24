package com.example.daggerdemo;

import dagger.Component;

@Component(modules = {Module.class})
public interface RegistrationComponent {
    void inject(MainActivity mainActivity);
}