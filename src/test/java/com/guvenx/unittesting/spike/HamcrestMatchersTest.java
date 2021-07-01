package com.guvenx.unittesting.spike;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersTest {

    @Test
    public void learning(){
        List<Integer> numbers = List.of(12, 24, 45);

        assertThat(numbers, hasSize(3));
        assertThat(numbers, hasItems(12,24));
        assertThat(numbers, everyItem(greaterThan(10)));
        assertThat(numbers, everyItem(lessThan(100)));

        assertThat("",blankOrNullString());
        assertThat("abCDe",containsString("CD"));
        assertThat("abCDe",endsWith("CDe"));

    }
}
