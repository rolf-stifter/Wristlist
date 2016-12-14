package be.pxl.elision.integration;

import be.pxl.elision.models.AppUsage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by 11308157 on 9/12/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest
public class AppUsageIntegrationTest {

    private AppUsage appUsage;

    @Before
    public void init(){
        appUsage = new AppUsage(new Timestamp(12345), new Timestamp(12345));
        try {
            postAddAppUsage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void postAddAppUsage() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String urlString = "http://localhost:9999/usage";

        ObjectMapper mapper = new ObjectMapper();
        String jsonEntity = mapper.writeValueAsString(appUsage);
// set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(jsonEntity, headers);
// send request

        restTemplate.exchange(urlString, HttpMethod.POST, entity, String.class);
    }

    @Test
    public void testGet(){
        try {
            boolean added = false;
            List<AppUsage> appUsages = getAppUsages();

            for (AppUsage usage:appUsages) {
                System.out.println(usage.getMeasured() + "banaan");
                if(usage.getMeasured() == appUsage.getMeasured() && usage.getTime_used() == appUsage.getTime_used()){
                    added = true;
                }
            }

            Assert.assertTrue(added);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<AppUsage> getAppUsages() throws Exception {

        List<AppUsage> sCrops;

        URL url = new URL("http://localhost:9999/usage");


        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-length", "0");
        connection.setDoOutput(true);


        InputStream content = connection.getInputStream();
        String jsonReply = convertStreamToString(content);

        ObjectMapper mapper = new ObjectMapper();
        sCrops = mapper.readValue(jsonReply, new TypeReference<List<AppUsage>>() {
        });
        connection.disconnect();
        return sCrops;

    }
    private static String convertStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }



}
