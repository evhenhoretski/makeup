package evhen_project.makeup.service.male.impls;

import evhen_project.makeup.entity.Category;
import evhen_project.makeup.entity.Male;
import evhen_project.makeup.repository.CategoryRepository;
import evhen_project.makeup.repository.MaleRepository;
import evhen_project.makeup.service.male.interfaces.IMaleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MaleService implements IMaleService {
    @Autowired
    private MaleRepository maleRepository;
    @Override
    public List<Male> getAll() {
        return maleRepository.findAll();
    }


    @Override
    public Male getById(Long id) {
        Optional<Male> result = maleRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }

    @Override
    public Male create(Male male) {
        return maleRepository.save(male);
    }

    @Override
    public Male update(Long id, Male male) {
        return maleRepository.save(male);
    }

    @Override
    public void delete(Long id) {
        maleRepository.deleteById(id);
    }
}
