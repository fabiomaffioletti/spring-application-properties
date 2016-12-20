package me.fabiomaffioletti.configuration.locations;

import lombok.Data;
import me.fabiomaffioletti.ApplicationProperties;

/**
 * Created by fmaffioletti on 12/19/16.
 */
@Data
@ApplicationProperties(locations = {"classpath:locations/location1.yml", "classpath:locations/location2.yml"})
public class MultipleLocationsPlainMap {

    private String foo;

    private String bar;

}
