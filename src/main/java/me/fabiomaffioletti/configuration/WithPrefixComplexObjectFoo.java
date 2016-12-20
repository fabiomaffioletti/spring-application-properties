package me.fabiomaffioletti.configuration;

import lombok.Data;
import me.fabiomaffioletti.ApplicationProperties;

import java.util.List;

/**
 * Created by fmaffioletti on 12/19/16.
 */
@Data
@ApplicationProperties(locations = "classpath:with-prefix-complex-object.yml", prefix = "foo")
public class WithPrefixComplexObjectFoo {

    private String title;

    private List<String> items;

}
