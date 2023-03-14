package br.com.ada.yourmoviesAPI.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "db_tables")
public class RoleEntity {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;

    public RoleEntity(UUID id) {
        this.id = id;
    }
}
