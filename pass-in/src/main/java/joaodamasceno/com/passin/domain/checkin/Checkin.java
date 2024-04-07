package joaodamasceno.com.passin.domain.checkin;

import jakarta.persistence.*;
import joaodamasceno.com.passin.domain.attendee.Attendee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "check_ins")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Checkin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToOne
    @JoinColumn(name = "attendee_id", nullable = false)
    private Attendee attendee;

}
