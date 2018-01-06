package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Customer {

        @Id
        @SequenceGenerator(name = "my_seq", sequenceName = "seq1", allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq")
        private Long id;

        @Column(name = "firstName")
        @NotNull
        @Size(min = 2, max = 15)
        private String firstName;

        @Column(name = "lastName")
        @NotNull
        @Size(min = 2, max = 15)
        private String lastName;

        @NotNull
        @Size(min = 2, max = 15)
        @Pattern(regexp = "[0-9a-zA-Z_]+")
        private String code;

        private String type;

        @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        @JoinColumn(nullable = false, name = "customerId")
        private List<Phone> phones;

}
