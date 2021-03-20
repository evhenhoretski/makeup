package evhen_project.makeup.dto;

import evhen_project.makeup.entity.Advertisement;
import lombok.Data;

@Data
public class AdvertismentResponse {
    private Long id;
    private String name;

    public static AdvertismentResponse mapToAdvertismentResponse(Advertisement advertisement) {
        AdvertismentResponse advertismentResponse = new AdvertismentResponse();

        advertismentResponse.setId(advertisement.getId());
        advertismentResponse.setName(advertisement.getName());

        return advertismentResponse;
    }
}
