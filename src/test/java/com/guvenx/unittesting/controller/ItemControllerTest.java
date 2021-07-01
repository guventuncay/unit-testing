package com.guvenx.unittesting.controller;

import com.guvenx.unittesting.business.ItemBusinessService;
import com.guvenx.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class)
class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService businessService;

    @Test
    void dummyItem_basic() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10" +
                        //",\"quantity\":100" +
                        "}"))
                .andReturn();

    }

    @Test
    void itemFromBusinessService_basic() throws Exception {

        when(businessService.retrieveHardcodedItem()).thenReturn(
                new Item(2, "Item2", 10, 10)
        );

        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{id:2,name:Item2,price:10" +
                        //",\"quantity\":100" +
                        "}"))
                .andReturn();

    }

    @Test
    void retrieveAllItemsTest_basic() throws Exception {

        when(businessService.retrieveAllItems()).thenReturn(
                List.of(
                        new Item(10001, "Item1", 10, 20)
                        , new Item(10002, "Item2", 5, 10)
                        , new Item(10003, "Item3", 15, 2)
                )
        );

        RequestBuilder request = MockMvcRequestBuilders
                .get("/all-items-from-database")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[" +
                        "{id:10001,name:Item1,price:10}," +
                        "{}," +
                        "{id:10003,name:Item3,price:15}" +
                        "]"))
/*              this is not gonna work.
                .andExpect(content().json("[" +
                        "{id:10003,name:Item3,price:15}," +
                        "{}," +
                        "{id:10001,name:Item1,price:10}" +
                        "]"))
*/
                .andReturn();

    }

}