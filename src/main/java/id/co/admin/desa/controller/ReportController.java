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
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Info;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService pendudukService;

    // Laporan jumlah penduduk
    @ApiOperation(value = "Laporan jumlah penduduk")
    @GetMapping("/penduduk")
    public ResponseEntity getJumlahPenduduk() {
        return ResponseEntity.ok(pendudukService.countPenduduk());
    }

    // Laporan data program
    @ApiOperation(value = "Laporan data program")
    @GetMapping("/program")
    public ResponseEntity getAllPrograms() {
        List<Program> findAllPrograms = pendudukService.findAllPrograms();
        return ResponseEntity.ok(findAllPrograms);
    }

    // Laporan penerima program
    @ApiOperation(value = "Laporan penerima program")
    @GetMapping("/program/details")
    public ResponseEntity getProgramDetails() {
        List<ProgramDetailsResponseDTO> findProgramDetails = pendudukService.findProgramDetails();
        return ResponseEntity.ok(findProgramDetails);
    }

    // Laporan organisasi desa
    @ApiOperation(value = "Laporan organisasi desa")
    @GetMapping("/village-organization")
    public ResponseEntity countVillageOrganization() {
        List<VillageOrganizationResponseDTO> countVillageOrganization = pendudukService.countVillageOrganization();
        return ResponseEntity.ok(countVillageOrganization);
    }

    // Laporan anggota organisasi
    @ApiOperation(value = "Laporan anggota organisasi")
    @GetMapping("/village-organization/detail")
    public ResponseEntity countVillageOrganizationDetailByPosition() {
        List<VillageOrganizationDetailResponseDTO> countVillageOrganizationDetailByPosition = pendudukService
                .countVillageOrganizationDetailByPosition();
        return ResponseEntity.ok(countVillageOrganizationDetailByPosition);
    }
}