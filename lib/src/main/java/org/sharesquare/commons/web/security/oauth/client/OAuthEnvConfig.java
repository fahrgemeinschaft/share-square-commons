package org.sharesquare.commons.web.security.oauth.client;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class OAuthEnvConfig {

    @Value("${SHARE2_OAUTH_CLIENT_REGISTRATION_ID:share2}")
    private String oauthClientRegistrationId;


    @Value("${SHARE2_OAUTH_CLIENT_TCP_CONNECT_TIMEOUT:30000}")
    private int connectTimeOut;


    @Value("${SHARE2_OAUTH_CLIENT_TCP_READ_TIMEOUT:30000}")
    private long readTimeOut;


    @Value("${SHARE2_OAUTH_CLIENT_ID}")
    private String share2OAuthClientId;

    @Value("${SHARE2_OAUTH_CLIENT_SECRET}")
    private String share2OAuthClientSecret;

    @Value("${SHARE2_OAUTH_TOKEN_ENDPOINT:https://sso-r2g-api-dev.apps.prod.rd2g.de/auth/realms/master/protocol/openid-connect/token}")
    private String share2OAuthTokenEndpoint;

}
