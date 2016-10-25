package main;

import org.springframework.data.rest.core.annotation.*;

import main.security.user.model.User;


@RepositoryEventHandler(User.class)
public class AppEventHandler {

    @HandleBeforeCreate
    public void handleBeforeCreate(User user) {
        System.out.println("Inside handleBeforeCreate ....");
    }

    @HandleBeforeSave
    public void handleBeforeSave(User user) {
        System.out.println("Inside handleBeforeSave ....");
    }

    @HandleAfterSave
    public void handleAfterSave(User user) {
        System.out.println("Inside handleAfterSave ....");
    }

}