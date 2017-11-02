package com.marblemethodsoftware.nostroapp.Utils;


import android.util.Log;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Random;

public class WordUtil {


    private static final String TAG = "TAG";
    public String string;
    static final String API_KEY = "iOm7MUcmFumshglav9Yjer3JXnPbp1n50TKjsnIA9MhmQlxNcm";


    public String getRandomNoun(){

        string = "FAILURE";

        String wordEndpoint = "https://wordsapiv1.p.mashape.com/words/?partOfSpeech=noun&typeOf=weapon&random=true";

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(wordEndpoint)
                .addHeader("X-Mashape-Key", API_KEY)
                .addHeader("Accept", "application/json")
                .build();

        Call call = client.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                Log.d(TAG, "FAILURE!");

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String jsonData = response.body().string();

                if (response.isSuccessful()) {

                    string = "SUCCESS";
                    Log.d(TAG, jsonData);



                }
            }

        });

        return string;
    }

    public String getRandomVerb(){
        String string = null;
        return string;
    }

    public String getRandomRhyme(String word){
        String string = null;
        return string;
    }


    public String getRandomWeapon(){

        String wordEndpoint = "https://wordsapiv1.p.mashape.com/words/weapon/hasTypes";

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(wordEndpoint)
                .addHeader("X-Mashape-Key", API_KEY)
                .addHeader("Accept", "application/json")
                .build();

        Call call = client.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                Log.d(TAG, "FAILURE!");

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String jsonData = response.body().string();

                if (response.isSuccessful()) {

                    try {

                        JSONObject object = new JSONObject(jsonData);
                       JSONArray words = object.getJSONArray("hasTypes");
                        string = getRandomWordFromJSON(words);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    Log.d(TAG, jsonData);
                }
            }
        });

        return string;
    }

    public String getString(){
        return string;
    }

    private String getRandomWordFromJSON(JSONArray array) throws JSONException {
        Random rand = new Random();
        String word = "error";
        int n = rand.nextInt(array.length())+1;

        try {
            word = array.getString(n);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return word;
    }
}
