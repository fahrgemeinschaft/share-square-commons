package org.sharesquare.commons.web.security.oauth.client;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sharesquare.commons.configuration.Share2CommonsAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Share2CommonsAutoConfiguration.class)
@WebAppConfiguration
public class OAuthRestTemplateTest {

    private final MockWebServer mockWebServer = new MockWebServer();

    @Autowired
    OAuth2RestOperations restOperations;

    @After
    public void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

    @Before
    public void init() throws IOException {
        mockWebServer.start(8099);
    }

    @Test
    public void initOk(){
        assertNotNull(restOperations);
    }

    @Test
    public void canGetAccessToken(){
        final OAuth2AccessToken token = restOperations.getAccessToken();
        assertNotNull(token);
        assertFalse(token.isExpired());
    }

    @Test
    public void shouldReturnPost() throws MalformedURLException {
        mockWebServer.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .setBody("{\"userId\": 1,\"id\": 1, \"title\": \"sunt aut facere repellat provident occaecati "
                                + "excepturi optio reprehenderit\", \"body\": \"quia et suscipit\"}"));

        ResponseEntity responseEntity = restOperations.postForEntity(URI.create("http://localhost:8099"), null, null);
        assertNotNull(responseEntity);
        assertTrue(responseEntity.getStatusCode().is2xxSuccessful());

    }


}