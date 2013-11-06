package com.lusher.geocode;

import com.lusher.map.domain.Address;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import java.io.IOException;

public class Geocoder {
    public static final String PLUS = "+";
    public static final String RESPONSE = "json";
    public static final String GOOGLE_GEOCODE_URL = "http://maps.googleapis.com/maps/api/geocode/";

    public static GeocodeResponse executeRequest(Address address) {
        GeocodeResponse response = GeocodeResponse.EMPTY;

        try {
            HttpClient client = new HttpClient();
            GetMethod getMethod = new GetMethod(buildApiCall(address));
            client.executeMethod(getMethod);

            response = new GeocodeResponse(getMethod.getResponseBodyAsString());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    static String buildApiCall(Address address) {
        String geocodeAPICall = GOOGLE_GEOCODE_URL + RESPONSE + "?address=";

        return geocodeAPICall
                + replaceSpaces(address.getStreetAddress()) + PLUS
                + replaceSpaces(address.getCity()) + "," + PLUS
                + address.getState() + PLUS
                + address.getZipCode()
                + "&sensor=false";
    }

    static String replaceSpaces(String input) {
        return input.replace(" ", PLUS);
    }
}