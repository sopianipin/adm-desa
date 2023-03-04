package id.co.admin.desa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.co.admin.desa.model.ProgramDetail;
import id.co.admin.desa.service.ProgramDetailService;

@RestController
@RequestMapping("/program-details")
public class ProgramDetailController {
    @Autowired
    private ProgramDetailService programDetailService;

    @GetMapping("/{id}")
    public ResponseEntity<ProgramDetail> findById(@PathVariable("id") Long id) {
        ProgramDetail programDetail = programDetailService.findById(id);
        if (programDetail == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(programDetail, HttpStatus.OK);
    }

    @GetMapping("/program/{programId}")
    public ResponseEntity<List<ProgramDetail>> findByProgramId(@PathVariable("programId") Long programId) {
        List<ProgramDetail> programDetails = programDetailService.findByProgramId(programId);
        if (programDetails.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(programDetails, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<ProgramDetail>> findAll() {
        List<ProgramDetail> programDetails = programDetailService.findAll();
        if (programDetails.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(programDetails, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ProgramDetail> saveOrUpdate(@RequestBody ProgramDetail programDetail) {
        ProgramDetail savedProgramDetail = programDetailService.saveOrUpdate(programDetail);
        return new ResponseEntity<>(savedProgramDetail, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        programDetailService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
