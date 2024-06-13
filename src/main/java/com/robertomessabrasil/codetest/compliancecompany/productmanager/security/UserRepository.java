package com.robertomessabrasil.codetest.compliancecompany.productmanager.security;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    public User findUserByEmail(String email) {
        return new User(email, "aaaaa", "Roberto", "Messa");
    }

}
