package com.guitar.model.projections;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;
//import org.springframework.ui.Model;

//import com.guitar.model.Manufacturer;
import com.guitar.model.Model;
import com.guitar.model.ModelType;
//This file customizes projections, names, and types
@Projection(name="modelDetailView", types= {Model.class})
public interface ModelDetailView {
    @Value("#{target.name}")//using this so I don't have to
    //call "getName()" for the method below. I can call it
    //something else 
    String getModelName();
    BigDecimal getPrice();
    @Value("#{target.manufacturer.name}")
   // Manufacturer getManufacturer();
   //changing above to return just a string of the name
   //but without the whole manufacturer data object
    String getManufacturerName();

    ModelType getModelType();
    int getFrets();
    String getWoodType();

    @Value("#{target.manufacturer.name.split('')[0]} #{target.name}")
    String getFullName();

}