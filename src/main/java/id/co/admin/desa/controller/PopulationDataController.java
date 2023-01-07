package id.co.admin.desa.controller;

import id.co.admin.desa.dto.PopulationDataDto;
import id.co.admin.desa.service.PopulationDataService;
import id.co.admin.desa.util.BaseResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/")
public class PopulationDataController {

    private PopulationDataService service;
    public PopulationDataController(PopulationDataService service){
        this.service = service;
    }

    @RequestMapping(value = "population/get-population-by-nik",method = RequestMethod.POST,produces = "application/json")
    public BaseResponse getPopulationDataById(@RequestBody PopulationDataDto request){
        return service.getPopulationDataByNik(request.getNik());
    }

    @RequestMapping(value = "population/add-population-data",method = RequestMethod.POST,produces = "application/json")
    public BaseResponse addPopulationData(@RequestBody PopulationDataDto request){
        return service.addPopulationData(request);
    }
}
