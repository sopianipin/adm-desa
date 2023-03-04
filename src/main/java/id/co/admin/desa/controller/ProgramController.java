package id.co.admin.desa.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import id.co.admin.desa.model.Program;
import id.co.admin.desa.service.ProgramService;

@RestController
@RequestMapping("/programs")
public class ProgramController {
    @Autowired
    private ProgramService programService;

    @GetMapping
    public List<Program> getAllPrograms() {
        return programService.getAllPrograms();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Program> getProgramById(@PathVariable Long id) {
        Program program = programService.getProgramById(id);
        return new ResponseEntity<>(program, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Program> createProgram(@RequestBody Program program) {
        Program newProgram = programService.createProgram(program);
        return new ResponseEntity<>(newProgram, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Program> updateProgram(@PathVariable Long id, @RequestBody Program program) {
        Program updatedProgram = programService.updateProgram(id, program);
        return new ResponseEntity<>(updatedProgram, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProgram(@PathVariable Long id) {
        programService.deleteProgram(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}