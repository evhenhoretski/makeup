package evhen_project.makeup.service.price.impls;

import evhen_project.makeup.entity.Category;
import evhen_project.makeup.entity.Price;
import evhen_project.makeup.repository.CategoryRepository;
import evhen_project.makeup.repository.PriceRepository;
import evhen_project.makeup.service.price.interfaces.IPriceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PriceService implements IPriceService {
    @Autowired
    private PriceRepository priceRepository;
    @Override
    public List<Price> getAll() {
        return priceRepository.findAll();
    }


    @Override
    public Price getById(Long id) {
        Optional<Price> result = priceRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }

    @Override
    public Price create(Price price) {
        return priceRepository.save(price);
    }

    @Override
    public Price update(Long id, Price price) {
        return priceRepository.save(price);
    }

    @Override
    public void delete(Long id) {
        priceRepository.deleteById(id);
    }
}
