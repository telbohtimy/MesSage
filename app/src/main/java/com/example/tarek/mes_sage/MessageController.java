package com.example.tarek.mes_sage;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static android.content.ContentValues.TAG;


public class MessageController {


    private static ArrayList<Message> messageList = new ArrayList<Message>();
    private static Gson gson = new Gson();
    private static String filename = "messageList";

    public static boolean validInput(String name, String phoneNumber, String messageText, int year, int day, int month, int hour, int minute){
        //Need to add null and empty checks here
        return true;
    }
    public static void createMessage(Context context, String name, String phoneNumber, String messageText, String frequency, int year, int day, int month, int hour, int minute){
        Message message = new Message(name, phoneNumber, messageText, frequency, year, day, month, hour, minute);
        messageList.add(message);
        saveMessageList(context);
    }

    public static void saveMessageList(Context context){
        String save = gson.toJson(messageList);
        FileOutputStream outputStream;
        try {
            outputStream = context.openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(save.getBytes());
            outputStream.close();
            Log.d(TAG, "SAVED");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadMessageList(Context context){
        try {
            FileInputStream fis = context.openFileInput(filename);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            String load = sb.toString();
            messageList = gson.fromJson(load, new TypeToken<ArrayList<Message>>(){}.getType());
            Log.d(TAG, "LOADED");
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    public static ArrayList<Message> getMessageList() {
        return messageList;
    }
}
