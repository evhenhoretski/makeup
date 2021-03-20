package evhen_project.makeup.service.information.impls;

import evhen_project.makeup.dto.InformationRequest;
import evhen_project.makeup.dto.InformationResponse;
import evhen_project.makeup.entity.Information;
import evhen_project.makeup.repository.InformationRepository;
import evhen_project.makeup.service.information.interfaces.IInformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InformationService implements IInformationService {
    @Autowired
    private InformationRepository informationRepository;
    @Override
    public List<InformationResponse> getAll() {
        var informations = informationRepository.findAll();
        return informations.stream().map(InformationResponse::mapToInformationResponse).collect(Collectors.toList());
    }


    @Override
    public InformationResponse getById(Long id) {
        Optional<Information> result = informationRepository.findById(id);
        if (result.isPresent()) {
            return InformationResponse.mapToInformationResponse(result.get());
        } else {
            return null;
        }
    }

    @Override
    public InformationResponse create(InformationRequest information) {
        var newInformation  =  Information.builder()
                .id(new Random().nextLong())
                .name(information.getName());
        return null;
                //InformationResponse.mapToInformationResponse(informationRepository.save(newInformation));
    }

    @Override
    public InformationResponse update(Long id, Information information) {
        return InformationResponse.mapToInformationResponse(informationRepository.save(information));
    }

    @Override
    public void delete(Long id) {
        informationRepository.deleteById(id);
    }
}
