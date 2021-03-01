package evhen_project.makeup.service.sales.impls;

import evhen_project.makeup.entity.Category;
import evhen_project.makeup.entity.Sales;
import evhen_project.makeup.repository.CategoryRepository;
import evhen_project.makeup.repository.SalesRepository;
import evhen_project.makeup.service.sales.interfaces.ISalesService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class SalesService implements ISalesService {
    @Autowired
    private SalesRepository salesRepository;
    @Override
    public List<Sales> getAll() {
        return salesRepository.findAll();
    }


    @Override
    public Sales getById(Long id) {
        Optional<Sales> result = salesRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }

    @Override
    public Sales create(Sales sales) {
        return salesRepository.save(sales);
    }

    @Override
    public Sales update(Long id, Sales sales) {
        return salesRepository.save(sales);
    }

    @Override
    public void delete(Long id) {
        salesRepository.deleteById(id);
    }
}
