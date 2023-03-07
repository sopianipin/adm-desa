package id.co.admin.desa.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VillageOrganizationResponseDTO {
    private String organizationName;
    private Integer totalMembers;
}
