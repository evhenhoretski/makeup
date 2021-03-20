package evhen_project.makeup.service.information.interfaces;

import evhen_project.makeup.dto.InformationRequest;
import evhen_project.makeup.dto.InformationResponse;
import evhen_project.makeup.entity.Information;

import java.util.List;

public interface IInformationService {
    List<InformationResponse> getAll();
    InformationResponse getById(Long id);
    InformationResponse create(InformationRequest information);
    InformationResponse update(Long id, Information information);
    void delete(Long id);

}
