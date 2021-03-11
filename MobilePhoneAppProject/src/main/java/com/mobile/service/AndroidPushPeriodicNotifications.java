package com.mobile.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AndroidPushPeriodicNotifications {

    public static String PeriodicNotificationJson(String bodyMessage, String titleMessage) throws JSONException {
        LocalDate localDate = LocalDate.now();


        JSONObject body = new JSONObject();

        List<String> tokenlist = new ArrayList<String>();

        JSONArray array = new JSONArray();

        for(int i=0; i<tokenlist.size(); i++) {
            array.put(tokenlist.get(i));
        }

        JSONObject data = new JSONObject();
        
        //data.put("body", bodyMessage);
        //data.put("title",titleMessage);
        
        //System.out.println("body : " + bodyMessage + "title : " + titleMessage );
        
        body.put("to", "/topics/p_topic");
        
        JSONObject notification = new JSONObject();
        notification.put("title",titleMessage);
        notification.put("body",bodyMessage);

        body.put("notification", notification);

        System.out.println(body.toString());

        return body.toString();
    }
}