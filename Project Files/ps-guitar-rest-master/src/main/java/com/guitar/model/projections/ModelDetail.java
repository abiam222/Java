package com.guitar.model.projections;

import org.springframework.data.rest.core.config.Projection;

import java.math.BigDecimal;

import com.guitar.model.Manufacturer;
import com.guitar.model.Model;
import com.guitar.model.ModelType;

//all types, even below have to match
@Projection(name="modelDetail", types={Model.class})
public interface ModelDetail {
    //Everything our UI needs

    //Types and names have to match entity attributes
    //?? for above 
    String getName();
    BigDecimal getPrice();
    Manufacturer getManufacturer();
    ModelType getModelType();
    int getFrets();
    String getWoodType();

}