package az.ministry.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
@Table(name = "visitors")
public class Visitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String finCode;
    String name;
    String surname;
    String contactDetails;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "customer")
    @PrimaryKeyJoinColumn
    Officer officer;

}
