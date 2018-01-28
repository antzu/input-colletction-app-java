package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Formfield {

    @Id
    @SequenceGenerator(name = "my_seq", sequenceName = "formfieldseq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq")
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "type")
    @NotNull
    private String type;
}