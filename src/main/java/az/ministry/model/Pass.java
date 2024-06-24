package az.ministry.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
@Table(name = "passes")
public class Pass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "visitor_id", nullable = false)
    Visitor visitor;

    @ManyToOne
    @JoinColumn(name = "officer_id", nullable = false)
    Officer officer;

    LocalDateTime entryTime;
    LocalDateTime exitTime;

    Boolean accepted;
}
