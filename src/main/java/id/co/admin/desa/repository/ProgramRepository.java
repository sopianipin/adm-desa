package id.co.admin.desa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import id.co.admin.desa.model.Program;

public interface ProgramRepository extends JpaRepository<Program, Long> {
}