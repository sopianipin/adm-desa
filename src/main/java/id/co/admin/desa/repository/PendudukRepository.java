package id.co.admin.desa.repository;

import id.co.admin.desa.model.Penduduk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PendudukRepository extends JpaRepository<Penduduk,Integer> {

    @Query("from Penduduk where nik = :nik")
    Optional<Penduduk> getPopulationDataEntityByNik(@Param("nik") String nik);
}
