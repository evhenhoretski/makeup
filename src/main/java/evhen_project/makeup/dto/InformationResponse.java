package evhen_project.makeup.dto;

import evhen_project.makeup.entity.Information;
import lombok.Data;

@Data
public class InformationResponse {
    private Long id;
    private String name;

    public static InformationResponse mapToInformationResponse(Information information) {
        InformationResponse informationResponse = new InformationResponse();

        informationResponse.setId(information.getId());
        informationResponse.setName(information.getName());

        return informationResponse;
    }
}
