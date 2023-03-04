package id.co.admin.desa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.co.admin.desa.model.VillageOrganization;
import id.co.admin.desa.service.VillageOrganizationService;

@RestController
@RequestMapping("/village-organizations")
public class VillageOrganizationController {

    @Autowired
    private VillageOrganizationService villageOrganizationService;

    @GetMapping("")
    public List<VillageOrganization> getAllVillageOrganizations() {
        return villageOrganizationService.getAllVillageOrganizations();
    }

    @GetMapping("/{id}")
    public VillageOrganization getVillageOrganizationById(@PathVariable Long id) {
        return villageOrganizationService.getVillageOrganizationById(id);
    }

    @PostMapping("")
    public void addVillageOrganization(@RequestBody VillageOrganization villageOrganization) {
        villageOrganizationService.saveOrUpdateVillageOrganization(villageOrganization);
    }

    @PutMapping("/{id}")
    public VillageOrganization updateVillageOrganization(@PathVariable Long id, @RequestBody VillageOrganization updatedVillageOrganization) {
        return villageOrganizationService.updateVillageOrganization(id, updatedVillageOrganization);
    }

    @DeleteMapping("/{id}")
    public void deleteVillageOrganizationById(@PathVariable Long id) {
        villageOrganizationService.deleteVillageOrganizationById(id);
    }

}
