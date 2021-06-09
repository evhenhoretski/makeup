package evhen_project.makeup.controller;

import evhen_project.makeup.entity.Information;
import evhen_project.makeup.repository.InformationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class InformationControllerTest {
    @MockBean
    private InformationRepository informationRepository;

    @Autowired
    private MockMvc mvc;

    @Test
    void name() throws Exception {
        var information = Information.builder().name("name").id(1L).build();
        var list = new ArrayList<Information>();
        var add = list.add(information);
        when(informationRepository.findAll()).thenReturn(list);

        mvc.perform(get("/information")
                .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$").isArray())
                .andExpect(content().string(containsString(information.getName())));
    }
}
