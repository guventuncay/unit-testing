package com.guvenx.unittesting.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    private String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

    @Test
    public void jsonAssert_StrictTrue_exactMatchExceptForSpaces() throws JSONException {
        String expectedResponse = "{\"id\": 1,\"name\":\"Ball\"" +
                ",\"price\":10,\"quantity\":100" +
                "}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, true);
    }

    @Test
    public void jsonAssert_StrictFalse_exactMatchExceptForSpaces() throws JSONException {
        String expectedResponse = "{\"id\":1,\"name\":\"Ball\"" +
//                ",\"price\":10,\"quantity\":100" +
                "}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }

    @Test
    public void jsonAssert_WithoutExcapeCharacters() throws JSONException {
        String expectedResponse =
                "{id:1,name:Ball,price:10,quantity:100}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, true);
    }
}
