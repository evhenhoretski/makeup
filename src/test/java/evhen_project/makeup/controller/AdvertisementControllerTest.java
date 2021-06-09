package evhen_project.makeup.controller;

import evhen_project.makeup.entity.Advertisement;
import evhen_project.makeup.repository.AdvertisementRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AdvertisementControllerTest {
    @MockBean
    private AdvertisementRepository advertisementRepository;

    @Autowired
    private MockMvc mvc;

    @Test
    void name() throws Exception {
        var advertisement = Advertisement.builder().name("name").id(1L).build();
        var list = new ArrayList<Advertisement>();
        var add = list.add(advertisement);
        when(advertisementRepository.findAll()).thenReturn(list);

        mvc.perform(get("/advertisement")
                .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$").isArray());
    }
}
