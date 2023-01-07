package id.co.admin.desa.service;

import id.co.admin.desa.dto.PopulationDataDto;
import id.co.admin.desa.model.PopulationDataEntity;
import id.co.admin.desa.repository.PopulationDataRepository;
import id.co.admin.desa.util.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Service
@Transactional
public class PopulationDataServiceImpl implements PopulationDataService{

    private PopulationDataRepository populationRepo;

    public PopulationDataServiceImpl(PopulationDataRepository populationRepo){
        this.populationRepo =  populationRepo;
    }

    private static final Integer FAILED_STATUS_CODE = 500;
    private static final Integer SUCCESS_STATUS_CODE = 200;
    private static final String SUCCESS_STATUS_MESSAGE = "success";
    private static final String DATA_NOT_FOUND = "Data Not Found";

    @Override
    public BaseResponse getPopulationDataByNik(String nik) {
        BaseResponse response;

        Optional<PopulationDataEntity> data = populationRepo.getPopulationDataEntityByNik(nik);

        if (data.isPresent()){
            PopulationDataEntity population = data.get();

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
        }else {
            response = BaseResponse.builder()
                    .content(DATA_NOT_FOUND)
                    .statusCode(SUCCESS_STATUS_CODE)
                    .message(SUCCESS_STATUS_MESSAGE)
                    .timestamp(new Date())
                    .build();
        }

        return response;
    }

    @Override
    public BaseResponse addPopulationData(PopulationDataDto request) {
        BaseResponse response;
        PopulationDataEntity data = PopulationDataEntity.builder()
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
            populationRepo.save(data);
        }catch (Exception e){
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


}
