package evhen_project.makeup.service.information.impls;

import evhen_project.makeup.dto.InformationResponse;
import evhen_project.makeup.entity.Information;
import evhen_project.makeup.repository.InformationRepository;
import evhen_project.makeup.service.information.interfaces.IInformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InformationService implements IInformationService {
    private final InformationRepository informationRepository;
    //private final InformationMapper informationMapper;
    @Override
    public List<InformationResponse> getAll() {
        var informations = informationRepository.findAll();
        return informations.stream().map(InformationResponse::mapToInformationResponse).collect(Collectors.toList());
    }


    @Override
    public InformationResponse getById(Long id) {
        Information result = informationRepository.findById(id).orElseThrow(NoSuchElementException::new);

        return InformationResponse.mapToInformationResponse(result);
    }

    @Override
    public InformationResponse create(Information information) {
        //var newInformation  =  informationMapper.fromRequest(information);
        return InformationResponse.mapToInformationResponse(informationRepository.save(information));
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
