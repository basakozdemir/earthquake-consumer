package com.basakozdemir.earthquakeconsumer.model;

import lombok.Data;

@Data
public class EarthquakeModel {
    public String place;
    public double mag;
    public long time;
    public String type;



}
