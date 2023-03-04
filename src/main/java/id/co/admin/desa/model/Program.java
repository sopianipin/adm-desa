package id.co.admin.desa.model;

import java.util.Date;
import javax.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "program")
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "program_name")
    private String programName;
    
    @Column(name = "details", columnDefinition = "TEXT")
    private String details;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "active_date")
    private Date activeDate;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date endDate;
}
