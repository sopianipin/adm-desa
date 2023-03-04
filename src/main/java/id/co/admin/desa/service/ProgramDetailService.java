package id.co.admin.desa.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.admin.desa.model.ProgramDetail;
import id.co.admin.desa.repository.ProgramDetailRepository;

@Service
public class ProgramDetailService {
    @Autowired
    private ProgramDetailRepository programDetailRepository;

    public ProgramDetail saveOrUpdate(ProgramDetail programDetail) {
        if (programDetail.getId() != null) {
            ProgramDetail existingProgramDetail = programDetailRepository.findById(programDetail.getId()).orElse(null);
            if (existingProgramDetail == null) {
                throw new NoSuchElementException("ProgramDetail with id " + programDetail.getId() + " doesn't exist");
            }
            existingProgramDetail.setNik(programDetail.getNik());
            existingProgramDetail.setDetail(programDetail.getDetail());
            return programDetailRepository.save(existingProgramDetail);
        } else {
            return programDetailRepository.save(programDetail);
        }
    }

    public void deleteById(Long id) {
        programDetailRepository.deleteById(id);
    }

    public ProgramDetail findById(Long id) {
        return programDetailRepository.findById(id).orElse(null);
    }

    public List<ProgramDetail> findAll() {
        return programDetailRepository.findAll();
    }

    public List<ProgramDetail> findByProgramId(Long programId) {
        return programDetailRepository.findByProgramId(programId);
    }
}