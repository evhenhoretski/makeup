package evhen_project.makeup.controller;

import evhen_project.makeup.dto.InformationResponse;
import evhen_project.makeup.entity.Information;
import evhen_project.makeup.service.information.impls.InformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/information", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class InformationController {

    public final InformationService informationService;

    @GetMapping()
    @PreAuthorize("hasAnyRole('ADMIN, USER')")
    public ResponseEntity<List<InformationResponse>> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                                            @RequestParam(required = false, defaultValue = "1") Integer page) {
        return ResponseEntity.ok(informationService.getAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN, USER')")
    public ResponseEntity<InformationResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(informationService.getById(id));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<InformationResponse> create(@RequestBody Information information) {
        return ResponseEntity.ok(informationService.create(information));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<InformationResponse> update(@PathVariable Long id, @RequestBody Information information) {
        return ResponseEntity.ok(informationService.update(id, information));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> delete(Long id) {
        informationService.delete(id);
        return ResponseEntity.ok("Successfully deleted");
    }

//    @GetMapping("/{categoryId}/products")
//    public List<Product> getProductByCategory(@PathVariable Long categoryId){
//        return null;
//    }
}
