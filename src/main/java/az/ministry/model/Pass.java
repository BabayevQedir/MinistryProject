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

    LocalDateTime entryTime;
    LocalDateTime exitTime;

    @ManyToOne
    @JoinColumn(name = "host_id",nullable = false)
    Officer officer;

    boolean accepted;

}
