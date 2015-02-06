package com.origamisoftware.teach.mock;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by seetha on 1/30/15.
 */
public class StockQuoteTest {
    StockQuote stkQt;
    String symbol;
    BigDecimal expectedPrice;
    Date date;

    //Initialization of test data
    @Before
    public void setup() {
        symbol ="AAPL";
        expectedPrice = new BigDecimal(10);
        date = Calendar.getInstance().getTime();
        stkQt = new StockQuote(date, expectedPrice, symbol);
    }

    //Test stock Symbol,
    //Positive case first
    @Test
    public void testPositiveStockSymbol() {
        String recvSymbol = stkQt.getStockSymbol();
        //checking if the return value is equal to the value we set
        assertEquals("Checking equal stock symbols", symbol, stkQt.getStockSymbol());
    }
    //Test Negative case for stock Symbol
    @Test
    public void testNegativeStockSymbol() {
        //Alter the stock symbol
        String newSymbol = symbol + "test";
        //checking if the return value is NOT equal to the value we set
        //assertThat(objectUnderTest, is(not(someOtherObject)));
        assertTrue("Checking unequal stock symbols", newSymbol != stkQt.getStockSymbol());
    }

    //Test stock Price, both positive and negative case
    @Test
    public void testPositiveStockPrice() {
        //checking if the return value is equal to the value we set
        assertEquals("Checking equal stock symbols", expectedPrice, stkQt.getStockPrice());
    }
    //Test Negative case for Stock Price
    @Test
    public void testNegativeStockPrice() {
        //Alter the stock price
        BigDecimal changedPrice = expectedPrice.add(new BigDecimal(10));
        //Now check if new value is not equal to value we set
        //assertNotEquals("Checking wrong Price", changedPrice, stkQt.getStockPrice());
        assertTrue("Checking wrong Price", changedPrice != stkQt.getStockPrice());
    }
    //Test stock date
    @Test
    public void testPositiveDate() {
        Calendar calendar = Calendar.getInstance();
        assertEquals("Testing correct date", date, stkQt.getDateRecorded());
    }
    //Test Negative date
    @Test
    public void testNegativeDate() {
        Calendar calendar = Calendar.getInstance();
        //Add a day and check if inequality is passes
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date newDate = calendar.getTime();
        assertNotSame("Testing wrong date", newDate, stkQt.getDateRecorded());
    }
}
