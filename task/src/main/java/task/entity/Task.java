package task.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Task implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "state")
    private String state;

    @Column(name = "message")
    private String message;
}
