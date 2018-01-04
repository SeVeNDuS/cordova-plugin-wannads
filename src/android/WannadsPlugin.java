package com.wannads.sdk;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.apache.cordova.*;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;

import com.wannads.sdk.*;


public class WannadsPlugin extends CordovaPlugin {
    private Context ctx;

    private static final String LOGTAG = "WannadsPlugin";

    private Handler attribution_handler;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        // your init code here
        if (ctx == null) {
            ctx = cordova.getActivity().getApplicationContext();
        }

        Log.i(LOGTAG, "Plugin Initialization");
    }


    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        Log.i(LOGTAG, "action is: " + action + " and there are " + args.length() + " args");

        if (action.equals("showOffers")) {
            String category = "";
            try {
                category = args.getString(0);
            } catch (Exception e) {
                Log.i(LOGTAG, "(showOffers call) without category");
            }

            if (TextUtils.isEmpty(category) || category.toLowerCase().equalsIgnoreCase("null")) {
                Log.i(LOGTAG, "(showOffers call) category - all");
                WannadsSdk.getInstance().showOffers();
            } else {
                Log.i(LOGTAG, "(showOffers call) category - " + category);
                WannadsSdk.getInstance().showOffers(category);
            }

            return true;
        }

        if (action.equals("configure")) {

            JSONObject inputJSONObject;

            try {
                inputJSONObject = (JSONObject) args.get(0);
            } catch (JSONException e) {
                Log.i(LOGTAG, "Error parsing datamap: " + e.toString());
                return false;
            }


            String apiKey = inputJSONObject.optString("apikey");
            if (apiKey != null && !apiKey.isEmpty()) {
                Log.i(LOGTAG, "(configure call) Wannads library apikey available");
            } else {
                Log.e(LOGTAG, "(configure call) Wannads library requires apikey param");
                return false;
            }

            String subid = inputJSONObject.optString("subid");
            if (subid != null && !subid.isEmpty()) {
                Log.i(LOGTAG, "(configure call) Wannads library subid available");
            } else {
                Log.e(LOGTAG, "(configure call) Wannads library requires subid param");
                return false;
            }

            WannadsSdk.getInstance().init(ctx, apiKey, subid);

            // Optional parameters
            String subid2 = inputJSONObject.optString("subid2");
            if (subid2 != null && !subid2.isEmpty()) {
                Log.i(LOGTAG, "(configure call) Wannads library subid2 available");
                WannadsSdk.getInstance().setSubId2(subid2);
            }

            String age = inputJSONObject.optString("age");
            if (age != null && !age.isEmpty()) {
                Log.i(LOGTAG, "(configure call) Wannads library age available");
                try {
                    WannadsSdk.getInstance().setAge(Integer.parseInt(age));
                } catch(Exception e) {
                    Log.e(LOGTAG, "(configure call) 'age' parameter must be a valid number. Error: " + e.toString());
                    return false;
                }
            }

            String gender = inputJSONObject.optString("gender");
            if (gender != null && !gender.isEmpty()) {
                Log.i(LOGTAG, "(configure call) Wannads library gender available");
                WanGender wanGender = null;
                if (gender.equals("male")) {
                    wanGender = WanGender.MALE;
                } else if (gender.equals("female")) {
                    wanGender = WanGender.FEMALE;
                } else {
                    Log.e(LOGTAG, "(configure call) 'gender' parameter must with invalid value");
                    return false;
                }
                WannadsSdk.getInstance().setGender(wanGender);
            }

            return true;
        }

        Log.i(LOGTAG, "Invalid action");
        return false;
    }

}
