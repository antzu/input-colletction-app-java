package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Project {

    @Id
    @SequenceGenerator(name = "my_seq", sequenceName = "projectseq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq")
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "createdBy")
    @NotNull
    private String createdBy;

    @Column(name = "createdOn")
    @NotNull
    private Date createdOn;
}
