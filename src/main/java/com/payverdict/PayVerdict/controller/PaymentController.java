package com.payverdict.PayVerdict.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final WebClient webClient;

    @Value("${payaza.api.key}")
    private String apiKey;

    @PostMapping("/generate_link")
    public ResponseEntity<?> genereateLink(){
        // Base URL
        String baseUrl = "https://router-live.78financials.com/api/request/secure/payloadhandler";

        // Request body
        String requestBody = "{\n" +
                "    \"service_type\": \"Transaction\",\n" +
                "    \"service_payload\": {\n" +
                "        \"request_application\": \"Payaza\",\n" +
                "        \"application_module\": \"USER_MODULE\",\n" +
                "        \"application_version\": \"1.0.0\",\n" +
                "        \"request_class\": \"CreateOrUpdatePaymentLinkDetailRequest\",\n" +
                "        \"payment_link_name\": \"Test\",\n" +
                "        \"payment_description\": \"This is solely for testing\",\n" +
                "        \"payment_link_id\": \"\",\n" +
                "        \"has_fixed_amount\": true,\n" +
                "        \"payment_amount\": 200.57,\n" +
                "        \"currency_id\": 1,\n" +
                "        \"payment_methods\": [\n" +
                "            {\n" +
                "                \"payment_method_id\": 1\n" +
                "            }\n" +
                "        ],\n" +
                "        \"fee_bearer_type\": \"Business\"\n" +
                "    }\n" +
                "}";

        // Authorization token
        String authToken = "Payaza " + apiKey;

        // Create WebClient
        WebClient client = WebClient.create(baseUrl);

        // Make the request
        String response = client.post()
                .uri(UriBuilder::build)
                .header(HttpHeaders.AUTHORIZATION, authToken)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(requestBody))
                .retrieve()
                .bodyToMono(String.class)
                .block(); // block() is used here for simplicity; in a real application, you'd handle the response asynchronously.

        // Handle the response
        return ResponseEntity.ok(response);
    }
}
