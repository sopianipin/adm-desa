package id.co.admin.desa.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import id.co.admin.desa.dto.PopulationDataDto;
import id.co.admin.desa.model.Penduduk;
import id.co.admin.desa.repository.PendudukRepository;
import id.co.admin.desa.util.BaseResponse;

@Service
@Transactional
public class PendudukService {

    private PendudukRepository pendudukRepository;

    public PendudukService(PendudukRepository pendudukRepository) {
        this.pendudukRepository = pendudukRepository;
    }

    private static final Integer FAILED_STATUS_CODE = 500;
    private static final Integer SUCCESS_STATUS_CODE = 200;
    private static final String SUCCESS_STATUS_MESSAGE = "success";
    private static final String DATA_NOT_FOUND = "Data Not Found";

    public BaseResponse getPopulationDataByNik(String nik) {
        BaseResponse response;

        Optional<Penduduk> data = pendudukRepository.getPopulationDataEntityByNik(nik);

        if (data.isPresent()) {
            Penduduk population = data.get();

            PopulationDataDto result = PopulationDataDto.builder()
                    .id(population.getId())
                    .nik(population.getNik())
                    .fullName(population.getFullName())
                    .gender(population.getGender())
                    .placeOfBirth(population.getPlaceOfBirth())
                    .dateOfBirth(population.getDateOfBirth())
                    .kkNumber(population.getKkNumber())
                    .address(population.getAddress())
                    .maritalStatus(population.getMaritalStatus())
                    .nationality(population.getNationality())
                    .education(population.getEducation())
                    .profession(population.getProfession())
                    .motherName(population.getMotherName())
                    .fatherName(population.getFatherName())
                    .rt(population.getRt())
                    .rw(population.getRw())
                    .postalCode(population.getPostalCode())
                    .village(population.getVillage())
                    .subDistrict(population.getSubDistrict())
                    .city(population.getCity())
                    .province(population.getProvince())
                    .status(population.getStatus())
                    .build();

            response = BaseResponse.builder()
                    .content(result)
                    .statusCode(SUCCESS_STATUS_CODE)
                    .message(SUCCESS_STATUS_MESSAGE)
                    .timestamp(new Date())
                    .build();
        } else {
            response = BaseResponse.builder()
                    .content(DATA_NOT_FOUND)
                    .statusCode(SUCCESS_STATUS_CODE)
                    .message(SUCCESS_STATUS_MESSAGE)
                    .timestamp(new Date())
                    .build();
        }

        return response;
    }

    public BaseResponse addPopulationData(PopulationDataDto request) {
        BaseResponse response;
        Penduduk data = Penduduk.builder()
                .nik(request.getNik())
                .fullName(request.getFullName())
                .gender(request.getGender())
                .placeOfBirth(request.getPlaceOfBirth())
                .dateOfBirth(request.getDateOfBirth())
                .kkNumber(request.getKkNumber())
                .address(request.getAddress())
                .maritalStatus(request.getMaritalStatus())
                .nationality(request.getNationality())
                .education(request.getEducation())
                .profession(request.getProfession())
                .motherName(request.getMotherName())
                .fatherName(request.getFatherName())
                .rt(request.getRt())
                .rw(request.getRw())
                .postalCode(request.getPostalCode())
                .village(request.getVillage())
                .subDistrict(request.getSubDistrict())
                .city(request.getCity())
                .province(request.getProvince())
                .status(request.getStatus())
                .build();
        try {
            pendudukRepository.save(data);
        } catch (Exception e) {
            response = BaseResponse.builder()
                    .statusCode(FAILED_STATUS_CODE)
                    .error(e.getMessage())
                    .timestamp(new Date())
                    .build();
        }

        response = BaseResponse.builder()
                .statusCode(SUCCESS_STATUS_CODE)
                .message(SUCCESS_STATUS_MESSAGE)
                .timestamp(new Date())
                .build();

        return response;
    }

    public Penduduk save(Penduduk penduduk) {
        return pendudukRepository.save(penduduk);
    }

    public List<Penduduk> findAll() {
        return pendudukRepository.findAll();
    }

    public Optional<Penduduk> findById(Integer id) {
        return pendudukRepository.findById(id);
    }

    public void deleteById(Integer id) {
        pendudukRepository.deleteById(id);
    }
}
