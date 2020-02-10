package com.example.ssadminbackend.authorization;

public class UserDTO {
    private String id;
    private String name;
    private String password;
    private String token;

    public UserDTO(){

    }
    public UserDTO(String id, String name, String password) {
        this.id=id;
        this.name = name;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public String getToken() {
        return token;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static UserDTO valueOf(User entity) {
        return new UserDTO(
                entity.getId(),
                entity.getName(),
                entity.getPassword()
        );

    }
}
