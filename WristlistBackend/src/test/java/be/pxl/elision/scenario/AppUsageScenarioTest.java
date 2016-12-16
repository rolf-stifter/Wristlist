package be.pxl.elision.scenario;

import be.pxl.elision.models.AppUsage;
import be.pxl.elision.services.AppUsageService;
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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.Filter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Timestamp;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by 11308157 on 9/12/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AppUsageScenarioTest {

    @Autowired
    private AppUsageService service;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MockMvc mockMvc;

    private static ObjectMapper objectMapper;
    private static AppUsage appUsage;
    private static String replyUsages;
    private static List<AppUsage> usages;

    @Before
    public void init(){
        objectMapper = new ObjectMapper();
        appUsage  = new AppUsage(new Timestamp(12345), new Timestamp(12345), "12345");
        service.addNew(appUsage);
    }
    @Test
    public void routingTest() throws Exception{
        MvcResult mockMvcResult1 = mockMvc.perform(get("/usage")
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())/*.andDo(print())*/.andReturn();
        replyUsages = mockMvcResult1.getResponse().getContentAsString();
        usages = objectMapper.readValue(replyUsages, new TypeReference<List<AppUsage>>() {
        });
        Assert.assertFalse(mockMvcResult1.getResponse().getContentAsString().isEmpty());
        Assert.assertFalse(usages.isEmpty());
    }

    @After
    public void finalize(){
        service.deleteAll();
    }

}
