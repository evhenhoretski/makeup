package evhen_project.makeup.service.female.impls;

import evhen_project.makeup.entity.Female;
import evhen_project.makeup.repository.FemaleRepository;
import evhen_project.makeup.service.female.interfaces.IFemaleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class FemaleService implements IFemaleService {
    @Autowired
    private FemaleRepository femaleRepository;
    @Override
    public List<Female> getAll() {
        return femaleRepository.findAll();
    }


    @Override
    public Female getById(Long id) {
        Optional<Female> result = femaleRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }

    @Override
    public Female create(Female female) {
        return femaleRepository.save(female);
    }

    @Override
    public Female update(Long id, Female female) {
        return femaleRepository.save(female);
    }

    @Override
    public void delete(Long id) {
        femaleRepository.deleteById(id);
    }
}
