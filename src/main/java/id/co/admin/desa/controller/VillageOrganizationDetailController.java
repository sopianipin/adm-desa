package id.co.admin.desa.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.co.admin.desa.model.VillageOrganizationDetail;
import id.co.admin.desa.service.VillageOrganizationDetailService;

@RestController
@RequestMapping("/village-organization-details")
public class VillageOrganizationDetailController {

    @Autowired
    private VillageOrganizationDetailService villageOrganizationDetailService;

    @PostMapping("")
    public VillageOrganizationDetail createVillageOrganizationDetail(
            @RequestBody VillageOrganizationDetail villageOrganizationDetail) {
        return villageOrganizationDetailService.saveOrUpdate(villageOrganizationDetail);
    }

    @PutMapping("/{id}")
    public VillageOrganizationDetail updateVillageOrganizationDetail(
            @RequestBody VillageOrganizationDetail villageOrganizationDetail, @PathVariable Long id) {
        if (!villageOrganizationDetailService.existsById(id)) {
            throw new NoSuchElementException("Village organization detail with ID " + id + " does not exist");
        }
        villageOrganizationDetail.setId(id);
        return villageOrganizationDetailService.saveOrUpdate(villageOrganizationDetail);
    }

    @GetMapping("/{id}")
    public VillageOrganizationDetail getVillageOrganizationDetail(@PathVariable Long id) {
        return villageOrganizationDetailService.findById(id);
    }

    @GetMapping("")
    public List<VillageOrganizationDetail> getAllVillageOrganizationDetails() {
        return villageOrganizationDetailService.findAll();
    }

    @GetMapping("/organization/{organizationId}")
    public List<VillageOrganizationDetail> getAllVillageOrganizationDetailsByOrganizationId(
            @PathVariable Long organizationId) {
        return villageOrganizationDetailService.findByOrganizationId(organizationId);
    }

    @DeleteMapping("/{id}")
    public void deleteVillageOrganizationDetail(@PathVariable Long id) {
        if (!villageOrganizationDetailService.existsById(id)) {
            throw new NoSuchElementException("Village organization detail with ID " + id + " does not exist");
        }
        villageOrganizationDetailService.deleteById(id);
    }
}
