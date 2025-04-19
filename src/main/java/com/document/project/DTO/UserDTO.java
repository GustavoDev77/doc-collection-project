package com.document.project.DTO;

import com.document.project.domain.User;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private String id;
    private String nome;
    private String email;

    public UserDTO(){
    }

    public UserDTO(User obj){
        id = obj.getId();
        nome = obj.getNome();
        email = obj.getEmail();
    }
    
    public void setId() {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
