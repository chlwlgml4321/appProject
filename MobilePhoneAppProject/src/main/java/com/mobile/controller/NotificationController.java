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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.mobile.domain.Office;
import com.mobile.service.AndroidPushNotificationService;
import com.mobile.service.AndroidPushPeriodicNotifications;







@RestController
public class NotificationController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    //@ResponseBody ResponseEntity<String>
    @Autowired
    AndroidPushNotificationService androidPushNotificationsService;

    
    //type - 0 : 회원 푸쉬알림 
    //type - 1 : 신청서 관리자 알림
    @RequestMapping(value = "/common/send")
    public int send(String titleMessage, String bodyMessage, Integer type, Long officeId) throws JSONException, InterruptedException  {
    	
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String notifications = "";
        if(type ==0) {
        	Office office = (Office) authentication.getPrincipal();
            notifications = AndroidPushPeriodicNotifications.PeriodicNotificationJson(bodyMessage, titleMessage, office.getOfficeId(), type);
        } else if(type ==1 ) {
        	notifications = AndroidPushPeriodicNotifications.PeriodicNotificationJson(bodyMessage, titleMessage, officeId, type);
        }
		
        

        

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application","json",Charset.forName("UTF-8"))); 
        
        HttpEntity<String> request = new HttpEntity<>(notifications,headers);

       
        CompletableFuture<String> pushNotification = androidPushNotificationsService.send(request);
        CompletableFuture.allOf(pushNotification).join();

        try{
            String firebaseResponse = pushNotification.get();
            //return new ResponseEntity<>(firebaseResponse, HttpStatus.OK);
            return 1;
        }
        catch (InterruptedException e){
            logger.debug("got interrupted!");
            throw new InterruptedException();
        }
        catch (ExecutionException e){
            logger.debug("execution error!");
        }

        //return new ResponseEntity<>("Push Notification ERROR!", HttpStatus.BAD_REQUEST);
        
        return 0;
    }
}