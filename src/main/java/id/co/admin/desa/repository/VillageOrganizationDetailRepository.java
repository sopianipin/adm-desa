package id.co.admin.desa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import id.co.admin.desa.model.VillageOrganizationDetail;

public interface VillageOrganizationDetailRepository extends JpaRepository<VillageOrganizationDetail, Long> {

    List<VillageOrganizationDetail> findByOrganizationId(Long organizationId);
    // tambahkan method tambahan jika diperlukan
}