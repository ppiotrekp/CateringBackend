package pl.ppyrczak.cateringbackend.role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@NoArgsConstructor
@Document
public class UserRole {
    @Id
    private String id;

    private EUserRole name;

    public UserRole(EUserRole name) {
        this.name = name;
    }

}
