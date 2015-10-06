package com.jaicorp.jai.sunshine;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * Created by jai on 10/3/2015.
 */
public class WeatherDataParser {

    public static double getMaxTempratureForDay(String weatherJsonStr,int dayIndex)throws JSONException{

        JSONObject weather = new JSONObject(weatherJsonStr);
        JSONArray days =weather.getJSONArray("list");
        JSONObject dayInfo =days.getJSONObject(dayIndex);
        JSONObject temperatureInfo =dayInfo.getJSONObject("temp");

        return temperatureInfo.getDouble("max");
    }
}
