package id.co.admin.desa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.admin.desa.model.VillageOrganization;
import id.co.admin.desa.repository.VillageOrganizationRepository;

@Service
public class VillageOrganizationService {

    @Autowired
    private VillageOrganizationRepository villageOrganizationRepository;

    public List<VillageOrganization> getAllVillageOrganizations() {
        return villageOrganizationRepository.findAll();
    }

    public VillageOrganization getVillageOrganizationById(Long id) {
        return villageOrganizationRepository.findById(id).orElse(null);
    }

    public void saveOrUpdateVillageOrganization(VillageOrganization villageOrganization) {
        villageOrganizationRepository.save(villageOrganization);
    }

    public void deleteVillageOrganizationById(Long id) {
        villageOrganizationRepository.deleteById(id);
    }

    public VillageOrganization updateVillageOrganization(Long id, VillageOrganization updatedVillageOrganization) {
        VillageOrganization villageOrganization = villageOrganizationRepository.findById(id).orElse(null);

        if (villageOrganization != null) {
            villageOrganization.setOrganizationName(updatedVillageOrganization.getOrganizationName());
            villageOrganizationRepository.save(villageOrganization);
        }

        return villageOrganization;
    }

}
