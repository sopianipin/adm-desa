package id.co.admin.desa.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.co.admin.desa.model.VillageOrganizationalStructure;
import id.co.admin.desa.service.VillageOrganizationalStructureService;

@RestController
@RequestMapping("/village-organizational-structure")
public class VillageOrganizationalStructureController {
    @Autowired
    private VillageOrganizationalStructureService villageOrganizationalStructureService;

    @GetMapping
    public ResponseEntity<List<VillageOrganizationalStructure>> getAllVillageOrganizationalStructure() {
        List<VillageOrganizationalStructure> villageOrganizationalStructures = villageOrganizationalStructureService
                .getAllOrganizations();
        return ResponseEntity.ok(villageOrganizationalStructures);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VillageOrganizationalStructure> getVillageOrganizationalStructureById(@PathVariable Long id) {
        VillageOrganizationalStructure villageOrganizationalStructure = villageOrganizationalStructureService
                .getOrganizationById(id);
        if (villageOrganizationalStructure == null) {
            throw new NoSuchElementException("VillageOrganizationalStructure with id " + id + " doesn't exist");
        }
        return ResponseEntity.ok(villageOrganizationalStructure);
    }

    @PostMapping
    public ResponseEntity<VillageOrganizationalStructure> createVillageOrganizationalStructure(
            @RequestBody VillageOrganizationalStructure villageOrganizationalStructure) {
        VillageOrganizationalStructure savedVillageOrganizationalStructure = villageOrganizationalStructureService
                .addOrganization(villageOrganizationalStructure);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVillageOrganizationalStructure);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VillageOrganizationalStructure> updateVillageOrganizationalStructure(@PathVariable Long id,
            @RequestBody VillageOrganizationalStructure villageOrganizationalStructure) {
        if (villageOrganizationalStructure.getId() == null) {
            throw new NoSuchElementException("VillageOrganizationalStructure with id " + id + " doesn't exist");
        }
        if (!id.equals(villageOrganizationalStructure.getId())) {
            throw new IllegalArgumentException("ID in path must be the same with ID in request body");
        }
        VillageOrganizationalStructure updatedVillageOrganizationalStructure = villageOrganizationalStructureService
                .updateOrganization(villageOrganizationalStructure);
        return ResponseEntity.ok(updatedVillageOrganizationalStructure);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVillageOrganizationalStructureById(@PathVariable Long id) {
        villageOrganizationalStructureService.deleteOrganizationById(id);
        return ResponseEntity.noContent().build();
    }
}