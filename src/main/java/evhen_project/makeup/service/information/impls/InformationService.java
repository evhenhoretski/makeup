package evhen_project.makeup.service.information.impls;

import evhen_project.makeup.entity.Category;
import evhen_project.makeup.entity.Information;
import evhen_project.makeup.repository.CategoryRepository;
import evhen_project.makeup.repository.InformationRepository;
import evhen_project.makeup.service.information.interfaces.IInformationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class InformationService implements IInformationService {
    @Autowired
    private InformationRepository informationRepository;
    @Override
    public List<Information> getAll() {
        return informationRepository.findAll();
    }


    @Override
    public Information getById(Long id) {
        Optional<Information> result = informationRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }

    @Override
    public Information create(Information information) {
        return informationRepository.save(information);
    }

    @Override
    public Information update(Long id, Information information) {
        return informationRepository.save(information);
    }

    @Override
    public void delete(Long id) {
        informationRepository.deleteById(id);
    }
}
