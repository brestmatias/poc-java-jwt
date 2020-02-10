package com.example.ssadminbackend.authorization;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.ssadminbackend.authorization.SecurityConstants.SECRET;
import static com.example.ssadminbackend.authorization.SecurityConstants.PREFIX;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class AuthorizationController {

    private final AuthorizationService service;

    @Autowired
    public AuthorizationController(AuthorizationService authorizationService) {
        this.service = authorizationService;
    }

    @PostMapping("auth/create")
    public UserDTO create() {
        User user = new User();
        user.setName("admin");
        user.setPassword("1234");
        return UserDTO.valueOf(service.create(user));
    }

    @PostMapping("auth")
    public ResponseEntity login(@RequestBody final UserDTO request) {

        User logedUser = service.getByNameAndPassword(request.getName(), request.getPassword());

        if (logedUser == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        String token = getJWTToken(logedUser.getName());
        UserDTO userDTO = UserDTO.valueOf(logedUser);
        userDTO.setName(request.getName());
        userDTO.setToken(token);
        return ResponseEntity.ok( userDTO);
    }

    private String getJWTToken(String username) {
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("tokenJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        SECRET.getBytes()).compact();

        return PREFIX + token;
    }
}
