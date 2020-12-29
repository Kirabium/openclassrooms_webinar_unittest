package com.unittest.gegemail;

import android.content.Context;
import android.content.SharedPreferences;

import com.unittest.gegemail.model.Mail;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class Utils {

    public static String NOTIFICATION = "isNotificationEnabled";
    public static String NOTIFICATION_PREFERENCES = "notifications";

    public static Mail[] removeItemAtIndex(Mail[] array, int index){
        Mail[] result = new Mail[array.length - 1];
        for(int i=0; i<array.length; i++){
            if(i < index)
                result[i] = array[i];
            else if(i > index)
                result[i] = array[i];
        }
        return result;
    }

    public static boolean getNotification(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(NOTIFICATION_PREFERENCES, MODE_PRIVATE);
        return prefs.getBoolean(NOTIFICATION, false);
    }


}
