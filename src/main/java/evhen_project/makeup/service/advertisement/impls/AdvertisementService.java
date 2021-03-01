package evhen_project.makeup.service.advertisement.impls;

import evhen_project.makeup.entity.Advertisement;
import evhen_project.makeup.entity.Category;
import evhen_project.makeup.repository.AdvertisementRepository;
import evhen_project.makeup.repository.CategoryRepository;
import evhen_project.makeup.service.advertisement.interfaces.IAdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AdvertisementService implements IAdvertisementService {
    @Autowired
    private AdvertisementRepository advertisementRepository;
    @Override
    public List<Advertisement> getAll() {
        return advertisementRepository.findAll();
    }


    @Override
    public Advertisement getById(Long id) {
        Optional<Advertisement> result = advertisementRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }

    @Override
    public Advertisement create(Advertisement advertisement) {
        return advertisementRepository.save(advertisement);
    }

    @Override
    public Advertisement update(Long id, Advertisement advertisement) {
        return advertisementRepository.save(advertisement);
    }

    @Override
    public void delete(Long id) {
        advertisementRepository.deleteById(id);
    }
}
