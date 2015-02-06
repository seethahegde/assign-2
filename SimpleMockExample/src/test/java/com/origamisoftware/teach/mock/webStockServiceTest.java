package com.origamisoftware.teach.mock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

/**
 * This test class shows how to use Mocks to test a class that has an external dependency
 */
public class webStockServiceTest {
    String username;
    String password;
    String stockSymbol;
    BigDecimal expectedPrice;
    StockService stockServiceMock;

    //Initialization of test data
    @Before
    public void setup() {
        /*
        *Initializing the variables
         */

        username="abc";
        password="asdf";

        stockSymbol = "APPL";
        expectedPrice = new BigDecimal(10);


    }
    @Test
    public void testGetStockQuote() {
        StockServiceFactory stockServiceFactory = new StockServiceFactory();
        /**Choose the type of service. This Tester tests webStockServiceTest
         **/
        StockService stockService = stockServiceFactory.getService("web");
        //NOW USE Mockito
        stockServiceMock = Mockito.mock(stockService.getClass());

        // next create the data we expect the service to return
        Date endDate = Calendar.getInstance().getTime();
        Calendar startCalendar = Calendar.getInstance();
        int NumberOfDayOfData = 15;
        startCalendar.add(Calendar.DAY_OF_YEAR, -NumberOfDayOfData);
        Date startDate = startCalendar.getTime();


        // tell the mock service to return the data the getQuote() method is called with a specific symbol
        when(stockServiceMock.getQuote(any(String.class), any(Date.class))).thenReturn(
                new StockQuote(Calendar.getInstance().getTime(), expectedPrice, stockSymbol));
        //tell the mock service to call UserAuth class when userAuth is called.
        when(stockServiceMock.userAuth(any(String.class), any(String.class))).thenReturn(new UserAuth(username, password).isValidCredential());


        // now create the StickTicker instance to test
        StockTicker stockTicker = new StockTicker(stockServiceMock);

        // now execute the method we want to test
        List<StockQuote> stockHistory = stockTicker.getStockHistory(stockSymbol, startDate, endDate);


        // now verify that it returned the expected results.

        if (stockServiceMock.userAuth(username, password)) {
            // there should 15 days of data
            assertTrue("There should be 15 days of data", stockHistory.size() == NumberOfDayOfData);
        }
    }

    @Test

    public void testInValidUserAuth() {
        StockServiceFactory stockServiceFactory = new StockServiceFactory();
        /**Choose the type of service. This Tester tests webStockServiceTest
         **/
        StockService stockService = stockServiceFactory.getService("web");
        //NOW USE Mockito
        stockServiceMock = Mockito.mock(stockService.getClass());

        //Checking if mocking of verifying credentials is working.
        //assertTrue("Checking username and password", stockServiceMock.userAuth(username, password));

        //Now alter the password to check if wrong password is sent, the test returns false
        password="wrong";
        when(stockServiceMock.userAuth(any(String.class), any(String.class))).thenReturn(new UserAuth(username, password).isValidCredential());
        assertFalse("Checking username and password", stockServiceMock.userAuth(username, password));
    }
}
