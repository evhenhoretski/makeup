package evhen_project.makeup.services;

import evhen_project.makeup.entity.Information;
import evhen_project.makeup.repository.InformationRepository;
import evhen_project.makeup.service.information.impls.InformationService;
import evhen_project.makeup.stubs.InformationStub;
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

import static evhen_project.makeup.stubs.CategoryStub.ID;
import static evhen_project.makeup.stubs.InformationStub.getRandomInformation;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
public class InformationServiceTest {
    private InformationService service;
    @Mock
    private InformationRepository informationRepository;

    @BeforeEach
    void setup(){
        service = new InformationService(informationRepository);
    }

    @Test
    void getSuccessful() {
        List<Information> list = new ArrayList<Information>();
        var information = getRandomInformation();
        list.add(information);
        list.add(information);
        list.add(information);

        when(informationRepository.findAll()).thenReturn(list);
        var getAll = service.getAll();
        assertEquals(list.size(), getAll.size());
    }

    @Test
    void testSuccessfulGetById(){
        var information = InformationStub.getRandomInformation();
        when(informationRepository.findById(any())).thenReturn(Optional.of(information));
        var result = service.getById(InformationStub.ID);

        assertAll(
                () -> assertEquals(result.getId(), information.getId()),
                () -> assertEquals(result.getName(), information.getName()));

    }

    @Test
    void getFailedById() {
        when(informationRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        assertThrows(NoSuchElementException.class, () -> service.getById(InformationStub.ID));
    }

    @Test
    void createSuccessful() {
        var captor = ArgumentCaptor.forClass(Information.class);
        var information = InformationStub.getRandomInformation();
        //when(categoryMapper.fromRequest(any())).thenReturn(category);
        when(informationRepository.save(any())).thenReturn(InformationStub.getRandomInformation());
        var result = service.create(InformationStub.getRandomInformation());
        Mockito.verify(informationRepository, atLeast(1)).save(captor.capture());
        assertEquals(information, captor.getValue());
        assertEquals(information.getName(), result.getName());
        assertEquals(information.getId(), result.getId());
    }

    @Test
    void updateSuccessful() {
        var captor = ArgumentCaptor.forClass(Information.class);
        var information = InformationStub.getRandomInformation();
        when(informationRepository.save(any())).thenReturn(InformationStub.getRandomInformation());
        var result = service.update(InformationStub.ID, InformationStub.getRandomInformation());
        Mockito.verify(informationRepository, atLeast(1)).save(captor.capture());
        assertEquals(information, captor.getValue());
        assertEquals(information.getName(), result.getName());
        assertEquals(information.getId(), result.getId());
    }

    @Test
    void testSuccessfulDelete(){
        service.delete(ID);
        var captor = ArgumentCaptor.forClass(Long.class);
        Mockito.verify(informationRepository, atLeast(1)).deleteById(captor.capture());
        assertEquals(ID,captor.getValue());
    }
}
