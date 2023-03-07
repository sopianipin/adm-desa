package id.co.admin.desa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.co.admin.desa.dto.ProgramDetailsResponseDTO;
import id.co.admin.desa.dto.VillageOrganizationDetailResponseDTO;
import id.co.admin.desa.dto.VillageOrganizationResponseDTO;
import id.co.admin.desa.model.Program;
import id.co.admin.desa.service.ReportService;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService pendudukService;

    // Laporan jumlah penduduk
    @GetMapping("/penduduk")
    public ResponseEntity<Long> getJumlahPenduduk() {
        Long countPenduduk = pendudukService.countPenduduk();
        return ResponseEntity.ok(countPenduduk);
    }

    // Laporan data program
    @GetMapping("/program")
    public ResponseEntity getAllPrograms() {
        List<Program> findAllPrograms = pendudukService.findAllPrograms();
        return ResponseEntity.ok(findAllPrograms);
    }

    // Laporan penerima program
    @GetMapping("/program/details")
    public ResponseEntity getProgramDetails() {
        List<ProgramDetailsResponseDTO> findProgramDetails = pendudukService.findProgramDetails();
        return ResponseEntity.ok(findProgramDetails);
    }

    // Laporan organisasi desa
    @GetMapping("/village-organization")
    public ResponseEntity countVillageOrganization() {
        List<VillageOrganizationResponseDTO> countVillageOrganization = pendudukService.countVillageOrganization();
        return ResponseEntity.ok(countVillageOrganization);
    }

    // Laporan anggota organisasi
    @GetMapping("/village-organization/detail")
    public ResponseEntity countVillageOrganizationDetailByPosition() {
        List<VillageOrganizationDetailResponseDTO> countVillageOrganizationDetailByPosition = pendudukService
                .countVillageOrganizationDetailByPosition();
        return ResponseEntity.ok(countVillageOrganizationDetailByPosition);
    }
}