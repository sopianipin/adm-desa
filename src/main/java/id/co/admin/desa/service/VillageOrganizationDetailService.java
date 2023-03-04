package id.co.admin.desa.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.admin.desa.model.VillageOrganizationDetail;
import id.co.admin.desa.repository.VillageOrganizationDetailRepository;

@Service
public class VillageOrganizationDetailService {

    @Autowired
    private VillageOrganizationDetailRepository villageOrganizationDetailRepository;

    public VillageOrganizationDetail saveOrUpdate(VillageOrganizationDetail villageOrganizationDetail) {
        if (villageOrganizationDetail.getId() != null) {
            VillageOrganizationDetail existingVillageOrganizationDetail = villageOrganizationDetailRepository
                    .findById(villageOrganizationDetail.getId())
                    .orElse(null);
            if (existingVillageOrganizationDetail == null) {
                throw new NoSuchElementException(
                        "VillageOrganizationDetail with id " + villageOrganizationDetail.getId() + " doesn't exist");
            }
            existingVillageOrganizationDetail.setNik(villageOrganizationDetail.getNik());
            existingVillageOrganizationDetail.setPosition(villageOrganizationDetail.getPosition());
            existingVillageOrganizationDetail.setStatus(villageOrganizationDetail.getStatus());
            return villageOrganizationDetailRepository.save(existingVillageOrganizationDetail);
        } else {
            return villageOrganizationDetailRepository.save(villageOrganizationDetail);
        }
    }

    public void deleteById(Long id) {
        villageOrganizationDetailRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return villageOrganizationDetailRepository.existsById(id);
    }

    public VillageOrganizationDetail findById(Long id) {
        return villageOrganizationDetailRepository.findById(id).orElse(null);
    }

    public List<VillageOrganizationDetail> findAll() {
        return villageOrganizationDetailRepository.findAll();
    }

    public List<VillageOrganizationDetail> findByOrganizationId(Long organizationId) {
        return villageOrganizationDetailRepository.findByOrganizationId(organizationId);
    }
}