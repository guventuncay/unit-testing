package com.guvenx.unittesting.business;

import com.guvenx.unittesting.data.SomeDataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SomeDataServiceBasicStub implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[]{1,2,3};
    }
}

class SomeDataServiceEmptyStub implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[]{};
    }
}

class SomeDataServiceOneValueStub implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[]{3};
    }
}

class SomeBusinessStubTest {

    @Test
    void calculateSumUsingDataService_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDateService(new SomeDataServiceBasicStub());

        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void calculateSumUsingDataService_empty() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDateService(new SomeDataServiceEmptyStub());

        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void calculateSumUsingDataService_oneValue() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDateService(new SomeDataServiceOneValueStub());

        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 3;
        assertEquals(expectedResult, actualResult);
    }
}