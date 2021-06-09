package evhen_project.makeup.services;

import evhen_project.makeup.entity.Advertisement;
import evhen_project.makeup.repository.AdvertisementRepository;
import evhen_project.makeup.service.advertisement.impls.AdvertisementService;
import evhen_project.makeup.stubs.AdvertisementStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static evhen_project.makeup.stubs.AdvertisementStub.getRandomAdvertisement;
import static evhen_project.makeup.stubs.CategoryStub.ID;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
public class AdvertisementServiceTest {
    private AdvertisementService service;
    @Mock
    private AdvertisementRepository advertisementRepository;

    @BeforeEach
    void setup(){
        service = new AdvertisementService(advertisementRepository);
    }

    @Test
    void getSuccessful() {
        List<Advertisement> list = new ArrayList<Advertisement>();
        var advertisement = getRandomAdvertisement();
        list.add(advertisement);
        list.add(advertisement);
        list.add(advertisement);

        when(advertisementRepository.findAll()).thenReturn(list);
        var getAll = service.getAll();
        assertEquals(list.size(), getAll.size());
    }

    @Test
    void testSuccessfulGetById(){
        var advertisement = getRandomAdvertisement();
        when(advertisementRepository.findById(any())).thenReturn(Optional.of(advertisement));
        var result = service.getById(AdvertisementStub.ID);

        assertAll(
                () -> assertEquals(result.getId(), advertisement.getId()),
                () -> assertEquals(result.getName(), advertisement.getName()));

    }

    @Test
    void getFailedById() {
        when(advertisementRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        assertThrows(NoSuchElementException.class, () -> service.getById(AdvertisementStub.ID));
    }

    @Test
    void createSuccessful() {
        var captor = ArgumentCaptor.forClass(Advertisement.class);
        var advertisement = getRandomAdvertisement();
        //when(categoryMapper.fromRequest(any())).thenReturn(category);
        when(advertisementRepository.save(any())).thenReturn(getRandomAdvertisement());
        var result = service.create(getRandomAdvertisement());
        Mockito.verify(advertisementRepository, atLeast(1)).save(captor.capture());
        assertEquals(advertisement, captor.getValue());
        assertEquals(advertisement.getName(), result.getName());
        assertEquals(advertisement.getId(), result.getId());
    }

    @Test
    void updateSuccessful() {
        var captor = ArgumentCaptor.forClass(Advertisement.class);
        var advertisement = getRandomAdvertisement();
        when(advertisementRepository.save(any())).thenReturn(getRandomAdvertisement());
        var result = service.update(AdvertisementStub.ID, getRandomAdvertisement());
        Mockito.verify(advertisementRepository, atLeast(1)).save(captor.capture());
        assertEquals(advertisement, captor.getValue());
        assertEquals(advertisement.getName(), result.getName());
        assertEquals(advertisement.getId(), result.getId());
    }

    @Test
    void testSuccessfulDelete(){
        service.delete(ID);
        var captor = ArgumentCaptor.forClass(Long.class);
        Mockito.verify(advertisementRepository, atLeast(1)).deleteById(captor.capture());
        assertEquals(ID,captor.getValue());
    }
}
