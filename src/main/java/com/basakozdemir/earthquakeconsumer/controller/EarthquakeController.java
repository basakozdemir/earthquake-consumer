package com.basakozdemir.earthquakeconsumer.controller;

import com.basakozdemir.earthquakeconsumer.model.EarthquakeModel;
import com.basakozdemir.earthquakeconsumer.service.EarthquakeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class EarthquakeController {


    @Autowired
    EarthquakeService earthquakeService;

    @GetMapping(path ="/earthquakes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<EarthquakeModel> get(@RequestParam(name = "days") int days,
                                          @RequestParam(name = "countryCode") String countryCode) throws JsonProcessingException {

        return earthquakeService.getEarthquakes(days, countryCode);

    }




}
