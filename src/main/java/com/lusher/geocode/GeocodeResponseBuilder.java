package com.lusher.geocode;

public class GeocodeResponseBuilder {
    private int streetNumber = 1;
    private String street = "Apple Lane";
    private String city = "Pleasanttown";
    private String state = "FL";
    private int postalCode = 55555;
    private double latitude = 1;
    private double longitude = 1;

    public GeocodeResponse build() {
        return new GeocodeResponse(streetNumber, street, city, state, postalCode, latitude, longitude);
    }

    public GeocodeResponseBuilder streetNumber(int number) {
        this.streetNumber = number;
        return this;
    }

    public GeocodeResponseBuilder street(String street) {
        this.street = street;
        return this;
    }
    public GeocodeResponseBuilder city(String city) {
        this.city = city;
        return this;
    }
    public GeocodeResponseBuilder state(String state) {
        this.state = state;
        return this;
    }
    public GeocodeResponseBuilder postalCode(int postalCode) {
        this.postalCode = postalCode;
        return this;
    }
    public GeocodeResponseBuilder latitude(double latitude) {
        this.latitude = latitude;
        return this;
    }
    public GeocodeResponseBuilder longitude(double longitude) {
        this.longitude = longitude;
        return this;
    }
}
