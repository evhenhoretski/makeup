package evhen_project.makeup.service.advertisement.impls;

import evhen_project.makeup.dto.AdvertismentRequest;
import evhen_project.makeup.dto.AdvertismentResponse;
import evhen_project.makeup.entity.Advertisement;
import evhen_project.makeup.repository.AdvertisementRepository;
import evhen_project.makeup.service.advertisement.interfaces.IAdvertisementService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdvertisementService implements IAdvertisementService {
    @Autowired
    private AdvertisementRepository advertisementRepository;
    @Override
    public List<AdvertismentResponse> getAll() {
        var advertisements = advertisementRepository.findAll();
        return advertisements.stream().map(AdvertismentResponse::mapToAdvertismentResponse).collect(Collectors.toList());
    }


    @Override
    public AdvertismentResponse getById(Long id) {
        Optional<Advertisement> result = advertisementRepository.findById(id);
        if (result.isPresent()) {
            return AdvertismentResponse.mapToAdvertismentResponse(result.get());
        } else {
            return null;
        }
    }

    @Override
    public AdvertismentResponse create(AdvertismentRequest advertisement) {
        var newAdvertisment  =  Advertisement.builder()
                .id(new Random().nextLong())
                .name(advertisement.getName());
        return null;
                //AdvertismentResponse.mapToAdvertismentResponse(advertisementRepository.save(newAdvertisment));;
    }

    @Override
    public AdvertismentResponse update(Long id, Advertisement advertisement) {
        return AdvertismentResponse.mapToAdvertismentResponse(advertisementRepository.save(advertisement));
    }

    @Override
    public void delete(Long id) {
        advertisementRepository.deleteById(id);
    }
}
