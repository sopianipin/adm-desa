package id.co.admin.desa.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.admin.desa.model.VillageOrganizationalStructure;
import id.co.admin.desa.repository.VillageOrganizationStructureRepository;

@Service
public class VillageOrganizationalStructureService {

    @Autowired
    private VillageOrganizationStructureRepository repository;

    public List<VillageOrganizationalStructure> getAllOrganizations() {
        return repository.findAll();
    }

    public VillageOrganizationalStructure getOrganizationById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public VillageOrganizationalStructure addOrganization(VillageOrganizationalStructure organization) {
        return repository.save(organization);
    }

    public VillageOrganizationalStructure updateOrganization(VillageOrganizationalStructure organization) {
        VillageOrganizationalStructure existingOrganization = repository.findById(organization.getId()).orElse(null);
        if (existingOrganization == null) {
            throw new NoSuchElementException(
                    "Village Organizational Structure with id " + organization.getId() + " doesn't exist");
        }
        existingOrganization.setFullName(organization.getFullName());
        existingOrganization.setPosition(organization.getPosition());
        return repository.save(existingOrganization);
    }

    public void deleteOrganizationById(Long id) {
        repository.deleteById(id);
    }

}