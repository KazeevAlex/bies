//package com.bies.idea.component;
//
//import feign.RequestInterceptor;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.oauth2.client.*;
//import org.springframework.security.oauth2.client.registration.ClientRegistration;
//import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//public class OAuthFeignConfig {
//
//    public static final String CLIENT_REGISTRATION_ID = "service-sebi-app-client";
//
//    private final OAuth2AuthorizedClientService oAuth2AuthorizedClientService;
//    private final ClientRegistrationRepository clientRegistrationRepository;
//
//    @Bean
//    public RequestInterceptor requestInterceptor() {
//        ClientRegistration clientRegistration = clientRegistrationRepository.findByRegistrationId(CLIENT_REGISTRATION_ID);
//        OAuthClientCredentialsFeignManager clientCredentialsFeignManager =
//                new OAuthClientCredentialsFeignManager(authorizedClientManager(), clientRegistration);
//        return requestTemplate -> {
//            requestTemplate.header("Authorization", "Bearer " + clientCredentialsFeignManager.getAccessToken());
//        };
//    }
//
//    @Bean
//    OAuth2AuthorizedClientManager authorizedClientManager() {
//        OAuth2AuthorizedClientProvider authorizedClientProvider = OAuth2AuthorizedClientProviderBuilder.builder()
//                .clientCredentials()
//                .build();
//
//        AuthorizedClientServiceOAuth2AuthorizedClientManager authorizedClientManager =
//                new AuthorizedClientServiceOAuth2AuthorizedClientManager(clientRegistrationRepository, oAuth2AuthorizedClientService);
//        authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider);
//        return authorizedClientManager;
//    }
//}
