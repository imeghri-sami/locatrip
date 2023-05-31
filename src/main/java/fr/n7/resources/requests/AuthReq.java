package fr.n7.resources.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthReq {
    private String email;
    private String password;
}
