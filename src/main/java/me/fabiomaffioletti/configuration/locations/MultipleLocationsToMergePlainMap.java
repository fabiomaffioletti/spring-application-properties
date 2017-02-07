package me.fabiomaffioletti.configuration.locations;

import lombok.Data;
import me.fabiomaffioletti.ApplicationProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fmaffioletti on 12/19/16.
 */
@Data
@ApplicationProperties(locations = {
        "classpath:locations/location-to-merge-1.yml",
        "classpath:locations/location-to-merge-2.yml"
})
public class MultipleLocationsToMergePlainMap {

    private Map<String, MultipleLocationsToMergeLink> links = new HashMap<>();



}
