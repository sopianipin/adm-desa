package id.co.admin.desa.service;

import id.co.admin.desa.dto.PopulationDataDto;
import id.co.admin.desa.util.BaseResponse;

public interface PopulationDataService {
    public BaseResponse getPopulationDataByNik(String nik);
    public BaseResponse addPopulationData(PopulationDataDto request);
}
