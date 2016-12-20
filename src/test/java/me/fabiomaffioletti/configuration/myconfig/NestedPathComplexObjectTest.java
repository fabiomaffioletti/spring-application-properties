package me.fabiomaffioletti.configuration.myconfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by fmaffioletti on 12/19/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NestedPathComplexObjectTest {

    @Autowired
    private NestedPathComplexObject nestedPathComplexObject;

    @Test
    public void testItShouldLoadWithSuccess() {
        assertThat(nestedPathComplexObject.getMyConfig().get("title"), is("myConfig"));
        assertThat(nestedPathComplexObject.getMyConfig().get("description"), is("Description"));
    }

}
