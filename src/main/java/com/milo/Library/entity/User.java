package com.milo.Library.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {

    private int userId;
    private String username;
    private String password;

}
