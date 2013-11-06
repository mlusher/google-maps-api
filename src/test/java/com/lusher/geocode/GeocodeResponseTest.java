package com.lusher.geocode;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GeocodeResponseTest {


    private GeocodeResponse geocode;
    String response = "{\n" +
            "   \"results\" : [\n" +
            "      {\n" +
            "         \"address_components\" : [\n" +
            "            {\n" +
            "               \"long_name\" : \"200\",\n" +
            "               \"short_name\" : \"200\",\n" +
            "               \"types\" : [ \"street_number\" ]\n" +
            "            },\n" +
            "            {\n" +
            "               \"long_name\" : \"East Randolph Street\",\n" +
            "               \"short_name\" : \"E Randolph St\",\n" +
            "               \"types\" : [ \"route\" ]\n" +
            "            },\n" +
            "            {\n" +
            "               \"long_name\" : \"Loop\",\n" +
            "               \"short_name\" : \"Loop\",\n" +
            "               \"types\" : [ \"neighborhood\", \"political\" ]\n" +
            "            },\n" +
            "            {\n" +
            "               \"long_name\" : \"Chicago\",\n" +
            "               \"short_name\" : \"Chicago\",\n" +
            "               \"types\" : [ \"locality\", \"political\" ]\n" +
            "            },\n" +
            "            {\n" +
            "               \"long_name\" : \"Cook\",\n" +
            "               \"short_name\" : \"Cook\",\n" +
            "               \"types\" : [ \"administrative_area_level_2\", \"political\" ]\n" +
            "            },\n" +
            "            {\n" +
            "               \"long_name\" : \"Illinois\",\n" +
            "               \"short_name\" : \"IL\",\n" +
            "               \"types\" : [ \"administrative_area_level_1\", \"political\" ]\n" +
            "            },\n" +
            "            {\n" +
            "               \"long_name\" : \"United States\",\n" +
            "               \"short_name\" : \"US\",\n" +
            "               \"types\" : [ \"country\", \"political\" ]\n" +
            "            },\n" +
            "            {\n" +
            "               \"long_name\" : \"60601\",\n" +
            "               \"short_name\" : \"60601\",\n" +
            "               \"types\" : [ \"postal_code\" ]\n" +
            "            }\n" +
            "         ],\n" +
            "         \"formatted_address\" : \"200 East Randolph Street, Chicago, IL 60601, USA\",\n" +
            "         \"geometry\" : {\n" +
            "            \"location\" : {\n" +
            "               \"lat\" : 41.8848719,\n" +
            "               \"lng\" : -87.62143929999999\n" +
            "            },\n" +
            "            \"location_type\" : \"ROOFTOP\",\n" +
            "            \"viewport\" : {\n" +
            "               \"northeast\" : {\n" +
            "                  \"lat\" : 41.8862208802915,\n" +
            "                  \"lng\" : -87.62009031970848\n" +
            "               },\n" +
            "               \"southwest\" : {\n" +
            "                  \"lat\" : 41.8835229197085,\n" +
            "                  \"lng\" : -87.6227882802915\n" +
            "               }\n" +
            "            }\n" +
            "         },\n" +
            "         \"types\" : [ \"street_address\" ]\n" +
            "      }\n" +
            "   ],\n" +
            "   \"status\" : \"OK\"\n" +
            "}";


    //200 E Randolph St, Chicago, IL 60601

    @Test
    public void shouldReifyResponse() {
        geocode = new GeocodeResponseBuilder()
                .streetNumber(200)
                .street("East Randolph Street")
                .city("Chicago")
                .state("Illinois")
                .postalCode(60601)
                .latitude(41.8848719)
                .longitude(-87.62143929999999)
                .build();

        assertThat(new GeocodeResponse(response), is(geocode));
    }


}
