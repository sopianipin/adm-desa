package id.co.admin.desa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import id.co.admin.desa.model.Program;

public interface ProgramRepository extends JpaRepository<Program, Long> {
    // Laporan jumlah penduduk
    @Query(value = "SELECT COUNT(id) AS total_penduduk, " +
            "COUNT(CASE WHEN gender = 'MALE' THEN 1 END) AS jumlah_laki_laki, " +
            "COUNT(CASE WHEN gender = 'FEMALE' THEN 1 END) AS jumlah_perempuan, " +
            "COUNT(CASE WHEN marital_status = 'Married' THEN 1 END) AS jumlah_kawin, " +
            "COUNT(CASE WHEN marital_status = 'Single' THEN 1 END) AS jumlah_belum_kawin " +
            "FROM penduduk", nativeQuery = true)
    List<Object[]> getPendudukStatistik();

    // Laporan data program
    @Query("SELECT p FROM Program p")
    List<Program> findAllPrograms();

    // Laporan penerima program
    @Query(nativeQuery = true, value = "SELECT pd.nik, pd.detail, p.program_name FROM program_details pd JOIN Program p ON pd.program_id = p.id")
    List<Object[]> findprogram_details();

    // Laporan organisasi desa
    @Query(nativeQuery = true, value = "SELECT vo.organization_name, COUNT(vod.id) FROM village_organization vo JOIN village_organization_detail vod ON vo.id = vod.organization_id GROUP BY vo.organization_name")
    List<Object[]> countvillage_organization();

    // Laporan anggota organisasi
    @Query(nativeQuery = true, value = "SELECT vod.position, COUNT(vod.id) FROM village_organization_detail vod GROUP BY vod.position")
    List<Object[]> countvillage_organization_detailByPosition();
}