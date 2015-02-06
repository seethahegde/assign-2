package com.origamisoftware.teach.mock;

/**
 * Created by seetha on 1/29/15.
 */
public class StockServiceFactory {

    //use the type of service to determine the type of class to return
    public StockService getService(String reqType){
        if(reqType == null){
            return null;
        }
        if(reqType.equalsIgnoreCase("web")){
            return WebStockService.getInstance();
        }
        if(reqType.equalsIgnoreCase("DB")){
            return DBStockService.getInstance();
        }
        return null;
    }
}
