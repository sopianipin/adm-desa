package id.co.admin.desa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProgramDetailsResponseDTO {
    private String nik;
    private String detail;
    private String programName;

}
