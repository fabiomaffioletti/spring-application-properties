package me.fabiomaffioletti.configuration.myconfig;

import me.fabiomaffioletti.ApplicationProperties;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by fmaffioletti on 12/19/16.
 */
@Data
@ApplicationProperties(locations = "classpath:myconfig/nested-path-complex-object.yml")
public class NestedPathComplexObject {

    private Map<String, String> myConfig;

}
