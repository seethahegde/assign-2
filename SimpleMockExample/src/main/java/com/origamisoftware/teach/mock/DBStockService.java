package com.origamisoftware.teach.mock;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by seetha on 1/28/15.
 */
public class DBStockService implements StockService {

    private DBStockService() {

    }
    // Use this to create object instead use static factory
    public static DBStockService getInstance() {
        return new DBStockService();
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
