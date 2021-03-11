package com.mobile.service;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

// firebase_server_key = firebase project > cloud messaging > server key

@Service
public class AndroidPushNotificationService {
    private static final String firebase_server_key="AAAAhQh2ISM:APA91bEmltQxF6mg6mzLxGGYSECKKKnwXohTlnbHJfiH2ls7tAqaQXpcVyrj4MI5JbV0h5rvBylwnyMindSR1XZLk3qz5OUWJZp_OfFw3wVRz3MNYr_RkuhjyLG4tzFHvyo5If6-2Cw7";
    private static final String firebase_api_url="https://fcm.googleapis.com/fcm/send";

    @Async
    public CompletableFuture<String> send(HttpEntity<String> entity) {

        RestTemplate restTemplate = new RestTemplate();

        ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();

        interceptors.add(new HeaderRequestInterceptor("Authorization",  "key=" + firebase_server_key));
        interceptors.add(new HeaderRequestInterceptor("Content-Type", "application/json; UTF-8 "));
        restTemplate.setInterceptors(interceptors);

        String firebaseResponse = restTemplate.postForObject(firebase_api_url, entity, String.class);

        return CompletableFuture.completedFuture(firebaseResponse);
    }
}

//cz_G5xUYQYu6GgHGm61mI5:APA91bFPn3surm2Kv5HqPf17KqHNQWzGy1FSmNslDtqU6pu95ru4CyxFihQxH91z1bsdCzPCWtykTafH_kSO0jg8dFhLv8bPty5URCSFaMgrNKDm4RyHwgBfuBIdntT7gVf8NBAwX-tX