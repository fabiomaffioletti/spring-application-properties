package me.fabiomaffioletti.configuration;

import lombok.Data;
import me.fabiomaffioletti.ApplicationProperties;

/**
 * Created by fmaffioletti on 12/19/16.
 */
@Data
@ApplicationProperties(locations = "classpath:with-prefix-complex-object.yml", prefix = "bar")
public class WithPrefixComplexObjectBar {

    private String description;

    private Integer age;

}
