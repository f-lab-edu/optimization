package flab.optimization.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class BigClassificationName {
    @Id
    private Long id;

    private String name;
}
