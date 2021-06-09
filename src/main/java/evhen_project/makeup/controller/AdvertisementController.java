package evhen_project.makeup.controller;

import evhen_project.makeup.dto.AdvertismentResponse;
import evhen_project.makeup.entity.Advertisement;
import evhen_project.makeup.service.advertisement.impls.AdvertisementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value =  "/advertisement", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class AdvertisementController {
    public final AdvertisementService advertisementService;

    @GetMapping()
    @PreAuthorize("hasAnyRole('ADMIN, USER')")
    public ResponseEntity<List<AdvertismentResponse>> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                                                             @RequestParam(required = false, defaultValue = "1") Integer page){
        return ResponseEntity.ok(advertisementService.getAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN, USER')")
    public ResponseEntity<AdvertismentResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(advertisementService.getById(id));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AdvertismentResponse> create(@RequestBody Advertisement advertisement){
        return ResponseEntity.ok(advertisementService.create(advertisement));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AdvertismentResponse> update(@PathVariable Long id, @RequestBody Advertisement advertisement){
        return ResponseEntity.ok(advertisementService.update(id, advertisement));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> delete(Long id){
        advertisementService.delete(id);
        return ResponseEntity.ok("Successfully deleted");
    }
}
