package com.guvenx.unittesting.spike;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJTest {

    @Test
    public void learning() {
        List<Integer> numbers = List.of(12, 24, 46);

        assertThat(numbers)
                .hasSize(3)
                .contains(12, 46)
                .allMatch(x -> x > 10)
                .allMatch(x -> x < 100)
                .noneMatch(x -> x % 2 == 1);

        assertThat("")
                .isEmpty();
        assertThat("abcd")
                .contains("cd")
                .startsWith("abc")
        ;

      /*assertThat(numbers, hasSize(3));
        assertThat(numbers, hasItems(12,24));
        assertThat(numbers, everyItem(greaterThan(10)));
        assertThat(numbers, everyItem(lessThan(100)));

        assertThat("",blankOrNullString());
        assertThat("abCDe",containsString("CD"));
        assertThat("abCDe",endsWith("CDe"));*/

    }
}
