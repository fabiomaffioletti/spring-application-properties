package me.fabiomaffioletti.configuration.locations;

import lombok.Data;
import me.fabiomaffioletti.ApplicationProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fmaffioletti on 12/19/16.
 */
@Data
public class MultipleLocationsToMergeLink {

    private Map<String, String> allKeys = new HashMap<>();

    private Map<String, String> allValues = new HashMap<>();

}
