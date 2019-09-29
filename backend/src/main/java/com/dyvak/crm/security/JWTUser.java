package com.dyvak.crm.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class JWTUser {

    private long id;
    private String email;
    private UserRole role;
}
