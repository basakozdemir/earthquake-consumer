# EarthquakeAPI Consumer
Spring application that consumes USGS Disaster API and manipulates to retrieve requested data.

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

## Successful Result

![result example](https://github.com/basakozdemir/earthquake-consumer/blob/master/example/result.png)

## Not Found Result
![error example](https://github.com/basakozdemir/earthquake-consumer/blob/master/example/error.png)



