package org.sharesquare.commons.web.security.oauth.client;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sharesquare.Share2CommonsTests;
import org.sharesquare.commons.configuration.Share2CommonsAutoConfiguration;
import org.sharesquare.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;


import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@Ignore
@ContextConfiguration(classes = Share2CommonsAutoConfiguration.class)
public class OAuthWebClientTest {

    private final MockWebServer mockWebServer = new MockWebServer();

    @Autowired
    WebClient webClient;

    @After
    public void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

    @Before
    public void init() throws IOException {
        mockWebServer.start(8099);
    }

    @Test
    public void shouldReturnPost() throws MalformedURLException {
        mockWebServer.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .setBody("{\"userId\": 1,\"id\": 1, \"title\": \"sunt aut facere repellat provident occaecati "
                                + "excepturi optio reprehenderit\", \"body\": \"quia et suscipit\"}"));

        assertNotNull(webClient);
        webClient.get().uri(URI.create("http://localhost:8099"))
                .exchange()
                .subscribe(clientResponse -> assertEquals(HttpStatus.OK,clientResponse.statusCode()));

    }


}