package com.globomatics.bike.controllers;

import java.util.List;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.rest.request.stocks.QuoteRequestBuilder;

@RestController
@RequestMapping("/api/v1/stocks")
public class StockController {

    final IEXTradingClient iexTradingClient = IEXTradingClient.create();
    private List<Quote> allStocks = new ArrayList<>();

    final Quote fbQuote = iexTradingClient.executeRequest(new QuoteRequestBuilder().withSymbol("FB").build());

    @GetMapping("/aapl")
    public Quote aapl() {
        final Quote quote = iexTradingClient.executeRequest(new QuoteRequestBuilder().withSymbol("AAPL").build());

        allStocks.add(quote);

        return quote;
    }

    @GetMapping("/fb")
    public Quote fb() {
        allStocks.add(fbQuote);

        return fbQuote;
    }

    @GetMapping("/fb/companyName")
    public String fbName() {
        return fbQuote.getCompanyName();
    }

    @GetMapping("/fb/openPrice")
    public BigDecimal fbOpenPrice() {
        return fbQuote.getOpen();
    }
    //get something specific from fb quote object 

    @GetMapping("/goog")
    public String goog() {
        StringBuilder result = new StringBuilder();
        String url = "https://api.iextrading.com/1.0/stock/goog/book";

        try {
            String line;
            URL urlObj = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            while ((line = rd.readLine()) != null)
                result.append(line);

            rd.close();

            //allStocks.add();

            return result.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/recentlyViewed")
    public List<Quote> recentlyViewed() {
        return allStocks;
    }
}