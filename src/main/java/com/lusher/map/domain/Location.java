package com.lusher.map.domain;

import com.lusher.geocode.GeocodeResponse;
import com.lusher.geocode.Geocoder;

import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;

public class Location {

    private final Address address;
    private final Position position;

    public Location(Address address) {
        this.address = address;
        this.position = fetchPosition();
    }

    public Position getPosition() {
        return position;
    }

    private Position fetchPosition() {
        GeocodeResponse response = Geocoder.executeRequest(address);
        return new Position(response.getLatitude(), response.getLongitude());
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
