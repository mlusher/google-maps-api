package com.lusher.geocode;

import com.lusher.map.domain.Address;
import com.lusher.map.domain.Position;
import com.lusher.map.domain.Location;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GeocodingIntegrationTest {

    private Address address;
    private Position coordinates;


    @Before
    public void setUp() throws Exception {
        address = new Address("200 E Randolph St", "Chicago", "IL", 60601);
        coordinates = new Position(41.8848719, -87.62143929999999);
    }

    @Test
    public void locationDeterminesCoordsFromAddress() {
        Location location = new Location(address);

        assertThat(
                location.getPosition(),
                is(coordinates)
        );
    }
}
