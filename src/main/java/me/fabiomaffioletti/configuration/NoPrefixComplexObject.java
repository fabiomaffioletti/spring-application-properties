package me.fabiomaffioletti.configuration;

import lombok.Data;
import me.fabiomaffioletti.ApplicationProperties;

import java.util.List;

/**
 * Created by fmaffioletti on 12/19/16.
 */
@Data
@ApplicationProperties(locations = "classpath:no-prefix-complex-object.yml")
public class NoPrefixComplexObject {

    private Foo foo;

    private Bar bar;

    @Data
    public static class Foo {

        private String title;

        private List<String> items;

    }

    @Data
    public static class Bar {

        private String description;

        private Integer age;

    }

}
