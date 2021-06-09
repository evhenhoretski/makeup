package evhen_project.makeup.controller;

import evhen_project.makeup.entity.Product;
import evhen_project.makeup.repository.ProductRepository;
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
public class ProductControllerTest {
    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private MockMvc mvc;

    @Test
    void name() throws Exception {
        var product = Product.builder().name("name").kind("desc").sale("10").id(1L).build();
        var list = new ArrayList<Product>();
        var add = list.add(product);
        when(productRepository.findAll()).thenReturn(list);

        mvc.perform(get("/product")
                .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$").isArray())
                .andExpect(content().string(containsString(product.getKind())))
                .andExpect(content().string(containsString(product.getName())))
                .andExpect(content().string(containsString(product.getSale())));
    }
}
