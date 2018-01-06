package model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Phone {
    @Id
    @SequenceGenerator(name = "my_seq", sequenceName = "seq1", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq")
    private Long id;
    private String type;
    private String value;
}
