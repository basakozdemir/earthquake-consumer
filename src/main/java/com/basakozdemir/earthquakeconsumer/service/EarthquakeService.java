package com.basakozdemir.earthquakeconsumer.service;

import com.basakozdemir.earthquakeconsumer.model.EarthquakeModel;
import com.basakozdemir.earthquakeconsumer.util.DateUtil;
import com.basakozdemir.earthquakeconsumer.util.GeoUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class EarthquakeService {
    private final String USGS_BASE_URL = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime={starttime}&endtime={endtime}&latitude={latitude}&longitude={longitude}&maxradius={maxradius}";

    @Autowired
    RestTemplate restTemplate;

    public ArrayList<EarthquakeModel> getEarthquakes(int lastXDays, String countryCode) throws JsonProcessingException {
        GeoUtil.coordinates coordinatesEnum = GeoUtil.coordinates.valueOf(countryCode);

        Map<String, String> params = new HashMap<>();

        params.put("starttime", DateUtil.getDateXDaysAgo(lastXDays).toString());
        params.put("endtime", LocalDate.now().toString());
        params.put("latitude", String.valueOf(coordinatesEnum.getLatitude()));
        params.put("longitude", String.valueOf(coordinatesEnum.getLongitude()));
        params.put("maxradius", "5");

        String responseJson = restTemplate.getForObject(USGS_BASE_URL, String.class, params);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        JsonNode responseJsonNode = new ObjectMapper().readTree(responseJson);
        ArrayNode featuresArrNode = (ArrayNode) responseJsonNode.get("features");


        ArrayList<EarthquakeModel> earthquakes = new ArrayList<>();
        if (featuresArrNode.isArray()) {
            for (JsonNode feature : featuresArrNode) {
                JsonNode propertiesNode = feature.get("properties");
                EarthquakeModel earthquakeModel = mapper.convertValue(propertiesNode, new TypeReference<EarthquakeModel>(){});
                if(earthquakeModel.type.equals("earthquake"))
                    earthquakes.add(earthquakeModel);
            }
        }

        return earthquakes;
    }

}
