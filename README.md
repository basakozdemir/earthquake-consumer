# EarthquakeAPI Consumer
Spring application that consumes USGS Disaster API and manipulates to retrieve requested data.
Country codes are not available via USGS Disaster API thus the requirement for filtering with
codes are supported by custom implementation. GeoUtil support coordinates with related country
information such as short code and name. According to latitude and longitude of the countries
are fetched by given country code with given get parameter filter.

## Example Consumed URL
```bash
https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime={starttime}&endtime={endtime}&latitude={latitude}&longitude={longitude}&maxradius={maxradius}
```


## API Parameters

|Parameter| Type  |
|---------|-------|
|  days   |integer|
|  countryCode  |string|

## Example Request

```bash
http://localhost:8080/earthquakes?days=30&countryCode=TR
```

## How to access by frontend

```bash
http://localhost:8080
```

Static html file is served under resources/public/index.html

## Successful Result

![result example](https://github.com/basakozdemir/earthquake-consumer/blob/master/example/result.png)

## Not Found Result
![error example](https://github.com/basakozdemir/earthquake-consumer/blob/master/example/error.png)



