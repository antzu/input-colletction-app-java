package test.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
        private String firstName;
        @Column(name = "lastName")
        private String lastName;
        private String code;
        private String type;

        @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        @JoinColumn(nullable = false, name = "customerId")
        private List<Phone> phones;

}
