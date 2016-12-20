package me.fabiomaffioletti.configuration;

import lombok.Data;
import me.fabiomaffioletti.ApplicationProperties;

/**
 * Created by fmaffioletti on 12/19/16.
 */
@Data
@ApplicationProperties(locations = "classpath:with-prefix-plain-map.yml", prefix = "prefix")
public class WithPrefixPlainMap {

    private String foo;

    private String bar;

    private Integer aninteger;

    private Long along;

    private boolean aboolean;

}
