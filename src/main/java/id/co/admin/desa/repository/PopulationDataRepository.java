package id.co.admin.desa.repository;

import id.co.admin.desa.model.PopulationDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PopulationDataRepository extends JpaRepository<PopulationDataEntity,Integer> {

    @Query("from PopulationDataEntity where nik = :nik")
    Optional<PopulationDataEntity> getPopulationDataEntityByNik(@Param("nik") String nik);
}
