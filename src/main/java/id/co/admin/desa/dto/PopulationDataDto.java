package id.co.admin.desa.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class PopulationDataDto {
    private Integer id;
    
    private String nik;
    
    private String fullName;
    
    private String gender;

    private String placeOfBirth;
    
    private Date dateOfBirth;
    
    private String kkNumber;

    private String address;
    
    private String maritalStatus;

    private String nationality;
    
    private String education;

    private String profession;
    
    private String motherName;

    private String fatherName;
    
    private String rt;
    
    private String rw;

    private String postalCode;

    private String village;

    private String subDistrict;

    private String city;
    
    private String province;

    private String status;
}
