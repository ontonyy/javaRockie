package com.justony.register.model.request;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String email;
    private String password;
    private String birthday;
    private String profession;
    private String note;
    private boolean married;
}
