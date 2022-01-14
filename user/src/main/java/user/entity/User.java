package user.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class User {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "password")
    private String password;
}
