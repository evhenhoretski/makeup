package evhen_project.makeup.controller;

import evhen_project.makeup.dto.AdvertismentResponse;
import evhen_project.makeup.entity.Advertisement;
import evhen_project.makeup.service.advertisement.impls.AdvertisementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping( "/v1/advertisement")
public class AdvertisementController {
    public final AdvertisementService advertisementService;

    @GetMapping()
    public List<AdvertismentResponse> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                                             @RequestParam(required = false, defaultValue = "1") Integer page){
        return advertisementService.getAll();
    }

    @GetMapping("/{id}")
    public AdvertismentResponse getById(@PathVariable Long id){
        return advertisementService.getById(id);
    }

    @PostMapping
    public AdvertismentResponse create(@RequestBody Advertisement advertisement){
        return advertisementService.create(advertisement);
    }

    @PutMapping("/{id}")
    public AdvertismentResponse update(@PathVariable Long id, @RequestBody Advertisement advertisement){
        return advertisementService.update(id, advertisement);
    }

    @DeleteMapping("/{id}")
    public void delete(Long id){
        advertisementService.delete(id);
    }
}
