package id.co.admin.desa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "program_details")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProgramDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "program_id")
    private Long programId;

    @Column(name = "nik")
    private String nik;

    @Column(name = "detail")
    private String detail;
}