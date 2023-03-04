package id.co.admin.desa.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.admin.desa.model.Program;
import id.co.admin.desa.repository.ProgramRepository;

@Service
public class ProgramService {
    @Autowired
    private ProgramRepository programRepository;

    public List<Program> getAllPrograms() {
        return programRepository.findAll();
    }

    public Program getProgramById(Long id) {
        return programRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Program not found"));
    }

    public Program createProgram(Program program) {
        return programRepository.save(program);
    }

    public Program updateProgram(Long id, Program program) {
        Program existingProgram = programRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Program not found"));

        existingProgram.setProgramName(program.getProgramName());
        existingProgram.setDetails(program.getDetails());
        existingProgram.setActiveDate(program.getActiveDate());
        existingProgram.setEndDate(program.getEndDate());

        return programRepository.save(existingProgram);
    }

    public void deleteProgram(Long id) {
        programRepository.deleteById(id);
    }
}