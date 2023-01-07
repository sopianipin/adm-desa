package id.co.admin.desa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "penduduk")
@Builder
public class PopulationDataEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column
    private String nik;

    @Column
    private String fullName;

    @Column
    private String gender;

    @Column
    private String placeOfBirth;

    @Column
    private Date dateOfBirth;

    @Column
    private String kkNumber;

    @Column
    private String address;

    @Column
    private String maritalStatus;

    @Column
    private String nationality;

    @Column
    private String education;

    @Column
    private String profession;

    @Column
    private String motherName;

    @Column
    private String fatherName;

    @Column
    private String rt;

    @Column
    private String rw;

    @Column
    private String postalCode;

    @Column
    private String village;

    @Column
    private String subDistrict;

    @Column
    private String city;

    @Column
    private String province;

    @Column
    private String status;
}
