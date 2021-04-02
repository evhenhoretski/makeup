package evhen_project.makeup.service.advertisement.interfaces;

import evhen_project.makeup.dto.AdvertismentResponse;
import evhen_project.makeup.entity.Advertisement;

import java.util.List;

public interface IAdvertisementService {
    List<AdvertismentResponse> getAll();
    AdvertismentResponse getById(Long id);
    //AdvertismentResponse create(AdvertismentRequest advertisement);
    AdvertismentResponse create(Advertisement advertisement);
    AdvertismentResponse update(Long id, Advertisement advertisement);
    void delete(Long id);

}
