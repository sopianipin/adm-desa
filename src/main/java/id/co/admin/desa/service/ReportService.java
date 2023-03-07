package id.co.admin.desa.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.admin.desa.dto.ProgramDetailsResponseDTO;
import id.co.admin.desa.dto.VillageOrganizationDetailResponseDTO;
import id.co.admin.desa.dto.VillageOrganizationResponseDTO;
import id.co.admin.desa.model.Program;
import id.co.admin.desa.repository.ProgramRepository;

@Service
public class ReportService {
    @Autowired
    private ProgramRepository programRepository;

    public Long countPenduduk() {
        return programRepository.countPenduduk();
    }

    public List<Program> findAllPrograms() {
        return programRepository.findAllPrograms();
    }

    public List<ProgramDetailsResponseDTO> findProgramDetails() {
        List<Object[]> results = programRepository.findprogram_details();
        List<ProgramDetailsResponseDTO> responseDTOs = new ArrayList<>();

        for (Object[] result : results) {
            ProgramDetailsResponseDTO responseDTO = new ProgramDetailsResponseDTO();
            responseDTO.setNik((String) result[0]);
            responseDTO.setDetail((String) result[1]);
            responseDTO.setProgramName((String) result[2]);
            responseDTOs.add(responseDTO);
        }

        return responseDTOs;
    }

    public List<VillageOrganizationResponseDTO> countVillageOrganization() {
        List<Object[]> results = programRepository.countvillage_organization();
        List<VillageOrganizationResponseDTO> responseDTOs = new ArrayList<>();

        for (Object[] result : results) {
            VillageOrganizationResponseDTO responseDTO = new VillageOrganizationResponseDTO();
            responseDTO.setOrganizationName((String) result[0]);
            responseDTO.setTotalMembers(((BigInteger) result[1]).intValue());
            responseDTOs.add(responseDTO);
        }

        return responseDTOs;
    }

    public List<VillageOrganizationDetailResponseDTO> countVillageOrganizationDetailByPosition() {
        List<Object[]> results = programRepository.countvillage_organization_detailByPosition();
        List<VillageOrganizationDetailResponseDTO> responseDTOs = new ArrayList<>();

        for (Object[] result : results) {
            VillageOrganizationDetailResponseDTO responseDTO = new VillageOrganizationDetailResponseDTO();
            responseDTO.setPosition((String) result[0]);
            responseDTO.setTotalMembers(((BigInteger) result[1]).intValue());
            responseDTOs.add(responseDTO);
        }

        return responseDTOs;
    }

}
