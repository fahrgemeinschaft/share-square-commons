package org.sharesquare.commons.web.security.oauth.client;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.security.oauth2.client.*;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.AuthenticatedPrincipalOAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.HttpSessionOAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.security.oauth2.client.web.server.ServerOAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.client.web.server.UnAuthenticatedServerOAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.client.web.server.WebSessionServerOAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.util.concurrent.TimeUnit;

/**
 *
 * this will only work (if ever) if you have an httpServletRequest
 */
@Configuration
@Import(OAuthEnvConfig.class)
public class OAuthWebclientConfig {

    @Autowired
    OAuthEnvConfig oAuthEnvConfig;

/*
    @Bean
    ReactiveClientRegistrationRepository foo(){
        return new ReactiveClientRegistrationRepository();
    }
*/
  /*
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

*/

    ClientHttpConnector configureHttpClientConnector() {
      // create reactor netty HTTP client with timeouts set by values.
      HttpClient httpClient = HttpClient.create()
              .tcpConfiguration(tcpClient -> {
                  tcpClient = tcpClient.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, oAuthEnvConfig.getConnectTimeOut());
                  tcpClient = tcpClient.doOnConnected(conn -> conn
                          .addHandlerLast(new ReadTimeoutHandler(oAuthEnvConfig.getReadTimeOut(), TimeUnit.MILLISECONDS)));
                  return tcpClient;
              });
      // create a client http connector using above http client
      ClientHttpConnector connector = new ReactorClientHttpConnector(httpClient);
      return connector;
    }



    @Bean
    ClientRegistrationRepository clientRegistrationRepository(){
        ClientRegistration registration =  ClientRegistration
                .withRegistrationId(oAuthEnvConfig.getOauthClientRegistrationId())
                .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
                .clientId(oAuthEnvConfig.getShare2OAuthClientId())
                .clientSecret(oAuthEnvConfig.getShare2OAuthClientSecret())
                .tokenUri(oAuthEnvConfig.getShare2OAuthTokenEndpoint())
                .build();

        return new InMemoryClientRegistrationRepository(registration);
    }
/*
    @Bean
    OAuth2AuthorizedClientRepository authorizedClientRepository (ClientRegistrationRepository clientRegistrationRepository) {
        return new AuthenticatedPrincipalOAuth2AuthorizedClientRepository(new InMemoryOAuth2AuthorizedClientService(clientRegistrationRepository));
    }
*/
    @Bean
    OAuth2AuthorizedClientManager authorizedClientManager(ClientRegistrationRepository clientRegistrationRepository) {

        OAuth2AuthorizedClientProvider authorizedClientProvider = OAuth2AuthorizedClientProviderBuilder.builder()
                .authorizationCode()
                .refreshToken()
                .clientCredentials()
                .password()
                .build();
        AuthorizedClientServiceOAuth2AuthorizedClientManager authorizedClientManager = new AuthorizedClientServiceOAuth2AuthorizedClientManager(
        //AuthorizedClientServiceOAuth2AuthorizedClientManager authorizedClientManager = new DefaultOAuth2AuthorizedClientManager(
                clientRegistrationRepository,
                new InMemoryOAuth2AuthorizedClientService(clientRegistrationRepository)
        );


        authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider);

        return authorizedClientManager;
    }

    @Bean
    WebClient webClient(OAuth2AuthorizedClientManager authorizedClientManager) {
        ServletOAuth2AuthorizedClientExchangeFilterFunction oauth2 = new ServletOAuth2AuthorizedClientExchangeFilterFunction(authorizedClientManager);
        oauth2.setDefaultOAuth2AuthorizedClient(true);
        return WebClient.builder()
                .clientConnector(configureHttpClientConnector())
               // .baseUrl(this.resourceUri)
                .apply(oauth2.oauth2Configuration())
                .build();
    }







}
