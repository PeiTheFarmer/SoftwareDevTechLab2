package staff.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Staff implements Serializable {

    @Column(name = "name")
    private String name;

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "department")
    private String department;
}