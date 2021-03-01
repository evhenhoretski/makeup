package evhen_project.makeup.controller;

import evhen_project.makeup.entity.Advertisement;
import evhen_project.makeup.entity.Category;
import evhen_project.makeup.service.advertisement.impls.AdvertisementService;
import evhen_project.makeup.service.category.impls.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/advertisement")
public class AdvertisementController {
    AdvertisementService advertisementService;

    @GetMapping()
    public List<Advertisement> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                                      @RequestParam(required = false, defaultValue = "1") Integer page){
        return advertisementService.getAll();
    }

    @GetMapping("/{id}")
    public Advertisement getById(@PathVariable Long id){
        return advertisementService.getById(id);
    }

    @PostMapping
    public Advertisement create(@RequestBody Advertisement advertisement){
        return advertisementService.create(advertisement);
    }

    @PutMapping("/{id}")
    public Advertisement update(@PathVariable Long id, @RequestBody Advertisement advertisement){
        return advertisementService.update(id, advertisement);
    }

    @DeleteMapping("/{id}")
    public void delete(Long id){
        advertisementService.delete(id);
    }
}
