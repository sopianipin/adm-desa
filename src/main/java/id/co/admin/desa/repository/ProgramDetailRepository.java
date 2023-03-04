package id.co.admin.desa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.co.admin.desa.model.ProgramDetail;

@Repository
public interface ProgramDetailRepository extends JpaRepository<ProgramDetail, Long> {

    List<ProgramDetail> findByProgramId(Long programId);
}