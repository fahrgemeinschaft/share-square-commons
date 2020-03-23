package org.sharesquare.commons.web.security.oauth.client;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.security.oauth2.client.web.server.UnAuthenticatedServerOAuth2AuthorizedClientRepository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.util.concurrent.TimeUnit;

public class OAuthWebclientConfig {

    @Value("${SHARE2_OAUTH_CLIENT_REGISTRATION_ID:share2")
    private String oauthClientRegistrationId;


    @Value("${SHARE2_OAUTH_CLIENT_TCP_CONNECT_TIMEOUT:30000")
    private int connectTimeOut;


    @Value("${SHARE2_OAUTH_CLIENT_TCP_READ_TIMEOUT:30000")
    private long readTimeOut;



    @Bean
    WebClient webClient(ReactiveClientRegistrationRepository clientRegistrations) {

        // create reactor netty HTTP client with timeouts set by values.
        HttpClient httpClient = HttpClient.create()
                .tcpConfiguration(tcpClient -> {
                    tcpClient = tcpClient.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, connectTimeOut);
                    tcpClient = tcpClient.doOnConnected(conn -> conn
                            .addHandlerLast(new ReadTimeoutHandler(readTimeOut, TimeUnit.MILLISECONDS)));
                    return tcpClient;
                });
        // create a client http connector using above http client
        ClientHttpConnector connector = new ReactorClientHttpConnector(httpClient);


        ServerOAuth2AuthorizedClientExchangeFilterFunction oauth =
                new ServerOAuth2AuthorizedClientExchangeFilterFunction(
                        clientRegistrations,
                        new UnAuthenticatedServerOAuth2AuthorizedClientRepository()
                );
        oauth.setDefaultClientRegistrationId(oauthClientRegistrationId);
        return WebClient.builder()
                .clientConnector(connector)
                .filter(oauth)
                .build();
    }

}
