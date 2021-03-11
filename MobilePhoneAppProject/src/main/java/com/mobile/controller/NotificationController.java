package com.mobile.controller;
import java.nio.charset.Charset;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import com.mobile.service.AndroidPushNotificationService;
import com.mobile.service.AndroidPushPeriodicNotifications;







@RestController
public class NotificationController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AndroidPushNotificationService androidPushNotificationsService;

    @GetMapping(value = "/send")
    public @ResponseBody ResponseEntity<String> send(String titleMessage, String bodyMessage) throws JSONException, InterruptedException  {
        String notifications = AndroidPushPeriodicNotifications.PeriodicNotificationJson(bodyMessage, titleMessage);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application","json",Charset.forName("UTF-8"))); 
        
        HttpEntity<String> request = new HttpEntity<>(notifications,headers);

       
        CompletableFuture<String> pushNotification = androidPushNotificationsService.send(request);
        CompletableFuture.allOf(pushNotification).join();

        try{
            String firebaseResponse = pushNotification.get();
            return new ResponseEntity<>(firebaseResponse, HttpStatus.OK);
        }
        catch (InterruptedException e){
            logger.debug("got interrupted!");
            throw new InterruptedException();
        }
        catch (ExecutionException e){
            logger.debug("execution error!");
        }

        return new ResponseEntity<>("Push Notification ERROR!", HttpStatus.BAD_REQUEST);
    }
}