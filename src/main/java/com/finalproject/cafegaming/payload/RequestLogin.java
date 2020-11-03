package com.finalproject.cafegaming.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestLogin {
    @NonNull
    private String username;
    @NonNull
    private String password;
}
