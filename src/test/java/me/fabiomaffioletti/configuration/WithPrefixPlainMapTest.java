package me.fabiomaffioletti.configuration;

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
public class WithPrefixPlainMapTest {

    @Autowired
    private WithPrefixPlainMap withPrefixPlainMap;

    @Test
    public void testItShouldLoadWithSuccess() {
        assertThat(withPrefixPlainMap.getFoo(), is("prefix.bar"));
        assertThat(withPrefixPlainMap.getBar(), is("prefix.foo"));
        assertThat(withPrefixPlainMap.getAninteger(), is(-1));
        assertThat(withPrefixPlainMap.getAlong(), is(987654321L));
        assertThat(withPrefixPlainMap.isAboolean(), is(false));
    }

}
