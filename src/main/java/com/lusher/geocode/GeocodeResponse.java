package com.lusher.geocode;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;

public class GeocodeResponse {
    public static final GeocodeResponse EMPTY = new GeocodeResponse(-1, "", "", "", -1, -1, -1);

    private int streetNumber = -1;
    private String street = "";
    private String city = "";
    private String state = "";
    private int postalCode = -1;
    private double latitude = -1;
    private double longitude = -1;

    public GeocodeResponse(String jsonString) {
        transformJSON(jsonString);
    }

    public GeocodeResponse(int streetNumber, String street, String city, String state, int postalCode, double latitude, double longitude) {
        this.streetNumber = streetNumber;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    private void transformJSON(String jsonString) {
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray results = jsonObject.getJSONArray("results");
            JSONObject firstResult = results.getJSONObject(0);

            JSONArray address = firstResult.getJSONArray("address_components");
            streetNumber = address.getJSONObject(0).getInt("long_name");
            street = address.getJSONObject(1).getString("long_name");
            city = address.getJSONObject(3).getString("long_name");
            state = address.getJSONObject(5).getString("long_name");
            postalCode = address.getJSONObject(7).getInt("long_name");

            JSONObject location = firstResult.getJSONObject("geometry").getJSONObject("location");
            latitude = location.getDouble("lat");
            longitude = location.getDouble("lng");


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "GeocodeResponse{" +
                "streetNumber=" + streetNumber +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode=" + postalCode +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    @Override
    public boolean equals(Object that) {
        return reflectionEquals(this, that);
    }

    @Override
    public int hashCode() {
        return reflectionHashCode(this);
    }
}
