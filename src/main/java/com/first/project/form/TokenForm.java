package com.first.project.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenForm {

    private String token;
    private String tipo;

    public TokenForm(String token, String tipo) {
        this.token = token;
        this.tipo = tipo;
    }

}
