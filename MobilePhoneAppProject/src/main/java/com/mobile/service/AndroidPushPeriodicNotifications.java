package com.mobile.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AndroidPushPeriodicNotifications {

    public static String PeriodicNotificationJson(String bodyMessage, String titleMessage, Long officeId, Integer type) throws JSONException {
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
        
        String topic = "";
        
        if(type == 0 && officeId == 9) {
        	topic = "p_topic";
        } else if (type == 0 && officeId != 9) {
        	topic = officeId + "_topic";
        } else if (type ==1) {
           topic =  "office_admin_" + officeId;
        }
        
        body.put("to", "/topics/"+ topic);
        
        
        
        JSONObject notification = new JSONObject();
        notification.put("title",titleMessage);
        notification.put("body",bodyMessage);
        notification.put("click_action",".MainPageActivity");
        
        data.put("topic", topic);
        body.put("data", data);
        body.put("notification", notification);
        
        

        System.out.println(body.toString());

        return body.toString();
    }
}