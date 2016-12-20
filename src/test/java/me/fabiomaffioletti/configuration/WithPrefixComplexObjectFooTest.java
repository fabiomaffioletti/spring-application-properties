package me.fabiomaffioletti.configuration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by fmaffioletti on 12/19/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WithPrefixComplexObjectFooTest {

    @Autowired
    private WithPrefixComplexObjectFoo withPrefixComplexObjectFoo;

    @Test
    public void testItShouldLoadWithSuccess() {
        assertThat(withPrefixComplexObjectFoo.getTitle(), is("Foo"));
    }

}
