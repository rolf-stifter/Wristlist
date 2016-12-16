package be.pxl.elision.scenario;
import be.pxl.elision.models.Location;
import be.pxl.elision.models.Notification;
import be.pxl.elision.services.LocationService;
import be.pxl.elision.services.NotificationService;
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
public class NotificationScenarioTest {
    @Autowired
    private NotificationService service;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MockMvc mockMvc;

    private static ObjectMapper objectMapper;
    private static Notification notification;
    private static String replyNotifications;
    private static List<Notification> notifications;

    @Before
    public void init(){
        objectMapper = new ObjectMapper();
        notification  = new Notification("TEST", new Timestamp(12345), "12345");
        service.addNew(notification);
    }
    @Test
    public void routingTest() throws Exception{
        MvcResult mockMvcResult1 = mockMvc.perform(get("/notification")
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())/*.andDo(print())*/.andReturn();
        replyNotifications = mockMvcResult1.getResponse().getContentAsString();
        notifications = objectMapper.readValue(replyNotifications, new TypeReference<List<Notification>>() {
        });
        Assert.assertFalse(mockMvcResult1.getResponse().getContentAsString().isEmpty());
        Assert.assertFalse(notifications.isEmpty());
    }
    @After
    public void finalize(){
        service.deleteAll();
    }
}
