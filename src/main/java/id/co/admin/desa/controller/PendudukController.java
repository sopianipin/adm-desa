package id.co.admin.desa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import id.co.admin.desa.dto.PopulationDataDto;
import id.co.admin.desa.model.Penduduk;
import id.co.admin.desa.service.PendudukService;
import id.co.admin.desa.util.BaseResponse;

@RestController
@RequestMapping(value = "/penduduk")
public class PendudukController {

    private PendudukService pendudukService;

    public PendudukController(PendudukService service) {
        this.pendudukService = service;
    }

    @RequestMapping(value = "population/get-population-by-nik", method = RequestMethod.POST, produces = "application/json")
    public BaseResponse getPopulationDataById(@RequestBody PopulationDataDto request) {
        return pendudukService.getPopulationDataByNik(request.getNik());
    }

    @RequestMapping(value = "population/add-population-data", method = RequestMethod.POST, produces = "application/json")
    public BaseResponse addPopulationData(@RequestBody PopulationDataDto request) {
        return pendudukService.addPopulationData(request);
    }

    @GetMapping
    public List<Penduduk> findAllPenduduk() {
        return pendudukService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Penduduk> findPendudukById(@PathVariable("id") Integer id) {
        Optional<Penduduk> penduduk = pendudukService.findById(id);
        return penduduk.isPresent() ? ResponseEntity.ok(penduduk.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Penduduk createPenduduk(@RequestBody Penduduk penduduk) {
        return pendudukService.save(penduduk);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Penduduk> updatePenduduk(@PathVariable("id") Integer id, @RequestBody Penduduk penduduk) {
        Optional<Penduduk> currentPenduduk = pendudukService.findById(id);
        if (currentPenduduk.isPresent()) {
            penduduk.setId(id);
            return ResponseEntity.ok(pendudukService.save(penduduk));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePenduduk(@PathVariable("id") Integer id) {
        Optional<Penduduk> penduduk = pendudukService.findById(id);
        if (penduduk.isPresent()) {
            pendudukService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
