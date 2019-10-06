package com.example.controllers;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Company;

@RestController
@RequestMapping("/companies")
public class CompaniesController {

    // Inject Bike Repo
    // @Autowired
    // private BikeRepository bikeRepository;

    // List
    // connecting to "GET" http method
    @GetMapping("/aapl")
    public Company aapl() {
        Company company = new Company();

        company.setSymbol("AAPL");
        company.setCompanyName("Apple Inc.");
        company.setExchange("Nasdaq Global Select");
        company.setIndustry("Computer Hardware");
        company.setWebsite("http://www.apple.com");
        company.setDescription(
                "Apple Inc is an American multinational technology company. It designs, manufactures, and markets mobile communication and media devices, personal computers, and portable digital music players.");
        company.setCEO("Timothy D. Cook");
        company.setIssueType("cs");
        company.setSector("Technology");

        List<String> tags = Arrays.asList("Technology", "Consumer Electronics", "Computer Hardware");
        company.setTags(tags);

        return company;
    }

    @GetMapping("/fb")
    public Company fb() {
        Company company = new Company();
        company.setSymbol("FB");
        company.setCompanyName("Facebook Inc.");
        company.setExchange("Nasdaq Global Select");
        company.setIndustry("Technology");
        company.setWebsite("http://www.facebook.com");

        return company;
    }

    // View specific bike
    // getting the .../bikes/{id}
    // @GetMapping("/{id}")
    // public Bike get(@PathVariable("id") long id) {
    // //return new Bike();
    // return bikeRepository.getOne(id);
    // }

    // Create bikes
    // creating "form creates"
    // @PostMapping
    // @ResponseStatus(HttpStatus.OK)
    // public void create(@RequestBody Bike bike) {
    // bikeRepository.save(bike);
    // }

    // View specific bike
    // getting the .../bikes/{id}
    // @GetMapping("/{id}")
    // public Bike get(@PathVariable("id") long id) {
    // //return new Bike();
    // return bikeRepository.getOne(id);
    // }
}