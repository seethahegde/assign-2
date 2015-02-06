package com.origamisoftware.teach.mock;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by seetha on 1/28/15.
 */
public class WebStockService implements StockService {

    private WebStockService() {

    }
    // Use this to create object instead use static factory
    public static WebStockService getInstance() {
        return new WebStockService();
    }

   @Override
   public StockQuote getQuote(String symbol, Date date) {
       //Filler for StockQuote till actual code is implemented
       StockQuote stkQt = new StockQuote(null, null,null);
       return stkQt;
   }
   public boolean userAuth(String username, String password) {
       return true;
   }
}
