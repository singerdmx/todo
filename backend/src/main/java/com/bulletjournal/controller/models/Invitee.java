package com.bulletjournal.controller.models;

import javax.validation.constraints.NotNull;

public class Invitee {
    private String firstName;
    private String lastName;

    @NotNull
    private String email;

    private String phone;
}
