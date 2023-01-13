package pl.ppyrczak.cateringbackend.role;

import lombok.ToString;

@ToString
public enum EUserRole {
    ROLE_GUEST,
    ROLE_CLIENT,
    ROLE_MODERATOR,
    ROLE_ADMIN
}
