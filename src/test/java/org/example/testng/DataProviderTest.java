package org.example.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

    @Test(dataProvider = "data")
    public void test(Object[] data) {
        for (Object d : data) {
            System.out.println(d);
        }
    }

    @DataProvider
    private  Object[][] data() {
        return new Object[][] {
                {"Hi", "John"},
                {"Hi", "Jack", "world"}
        };
    }
}
