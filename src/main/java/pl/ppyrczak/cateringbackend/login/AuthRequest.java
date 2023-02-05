package pl.ppyrczak.cateringbackend.login;

import lombok.Getter;

@Getter
public class AuthRequest {
    private String email;
    private String password;
}
