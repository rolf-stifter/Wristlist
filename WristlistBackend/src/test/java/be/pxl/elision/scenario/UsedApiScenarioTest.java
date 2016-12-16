package be.pxl.elision.scenario;

import be.pxl.elision.models.Notification;
import be.pxl.elision.models.UsedApi;
import be.pxl.elision.services.NotificationService;
import be.pxl.elision.services.UsedApiService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import java.sql.Timestamp;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by 11308157 on 15/12/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UsedApiScenarioTest {
    @Autowired
    private UsedApiService service;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MockMvc mockMvc;

    private static ObjectMapper objectMapper;
    private static UsedApi usedApi;
    private static String replyUsedApis;
    private static List<UsedApi> usedApis ;

    @Before
    public void init(){
        objectMapper = new ObjectMapper();
        usedApi  = new UsedApi("TEST", new Timestamp(12345), "12345");
        service.addNew(usedApi);
    }

    @Test
    public void routingTest() throws Exception{
        MvcResult mockMvcResult1 = mockMvc.perform(get("/usedapi")
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())/*.andDo(print())*/.andReturn();
        replyUsedApis = mockMvcResult1.getResponse().getContentAsString();
        usedApis = objectMapper.readValue(replyUsedApis, new TypeReference<List<UsedApi>>() {
        });
        Assert.assertFalse(mockMvcResult1.getResponse().getContentAsString().isEmpty());
        Assert.assertFalse(usedApis.isEmpty());
    }

    @After
    public void finalize(){
        service.deleteAll();
    }
}
