package com.globomatics.bike.controllers;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.rest.request.stocks.QuoteRequestBuilder;

import com.globomatics.bike.models.Bike;
import com.globomatics.bike.repositories.BikeRepository;

@RestController
@RequestMapping("/api/v1/bikes")
public class BikesController {

    //Inject Bike Repo
    @Autowired
    private BikeRepository bikeRepository;

    //List bikes
    //connecting to "GET" http method
    @GetMapping
    public List<Bike> list() {
        // List<Bike> bikes = new ArrayList<>();
        // bikes.add(new Bike());
        // return bikes;

        //find all bikeRepository in our db table
        return bikeRepository.findAll();
    }

    //Create bikes
    //creating "form creates"
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Bike bike) {
        bikeRepository.save(bike);
    }

    //View specific bike 
    //getting the .../bikes/{id}
    @GetMapping("/{id}")
    public Bike get(@PathVariable("id") long id) {
        //return new Bike();
        return bikeRepository.getOne(id);
    }

    // @GetMapping("/stock")
    // public Quote get() {
    //     final IEXTradingClient iexTradingClient = IEXTradingClient.create();
    //     final Quote quote = iexTradingClient.executeRequest(new QuoteRequestBuilder().withSymbol("AAPL").build());
  
    //     return quote;
    // }
}