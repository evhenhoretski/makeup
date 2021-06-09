package evhen_project.makeup.service.advertisement.impls;

import evhen_project.makeup.dto.AdvertismentResponse;
import evhen_project.makeup.entity.Advertisement;
import evhen_project.makeup.repository.AdvertisementRepository;
import evhen_project.makeup.service.advertisement.interfaces.IAdvertisementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdvertisementService implements IAdvertisementService {
    private final AdvertisementRepository advertisementRepository;
    //private final AdvertisementMapper advertisementMapper;
    @Override
    public List<AdvertismentResponse> getAll() {
        var advertisements = advertisementRepository.findAll();
        return advertisements.stream().map(AdvertismentResponse::mapToAdvertismentResponse)
                .collect(Collectors.toList());
    }


    @Override
    public AdvertismentResponse getById(Long id) {
        Advertisement result = advertisementRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);

        return AdvertismentResponse.mapToAdvertismentResponse(result);
    }

    @Override
    public AdvertismentResponse create(Advertisement advertisement) {
        //var newAdvertisement  =  advertisementMapper.fromRequest(advertisement);
        return AdvertismentResponse.mapToAdvertismentResponse(advertisementRepository
                .save(advertisement));
    }

    @Override
    public AdvertismentResponse update(Long id, Advertisement advertisement) {
        return AdvertismentResponse.mapToAdvertismentResponse(advertisementRepository
                .save(advertisement));
    }

    @Override
    public void delete(Long id) {
        advertisementRepository.deleteById(id);
    }
}
