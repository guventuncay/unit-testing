package com.guvenx.unittesting.business;

import com.guvenx.unittesting.data.ItemRepository;
import com.guvenx.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ItemBusinessServiceTest {

    @InjectMocks
    ItemBusinessService business;

    @Mock
    ItemRepository repository;

    @Test
    void retrieveAllItems() {
        when(repository.findAll()).thenReturn(
                List.of(
                        new Item(10001, "Item1", 10, 20),
                        new Item(10002, "Item2", 5, 10),
                        new Item(10003, "Item3", 15, 2)
                )
        );
        List<Item> items = business.retrieveAllItems();

        assertEquals(200, items.get(0).getValue());
        assertEquals(50, items.get(1).getValue());
        assertEquals(30, items.get(2).getValue());
    }

}