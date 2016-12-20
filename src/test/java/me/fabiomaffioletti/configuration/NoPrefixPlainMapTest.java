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
public class NoPrefixPlainMapTest {

    @Autowired
    private NoPrefixPlainMap noPrefixPlainMap;

    @Test
    public void testItShouldLoadWithSuccess() {
        assertThat(noPrefixPlainMap.getFoo(), is("bar"));
        assertThat(noPrefixPlainMap.getBar(), is("foo"));
        assertThat(noPrefixPlainMap.getAninteger(), is(0));
        assertThat(noPrefixPlainMap.getAlong(), is(1234567890L));
        assertThat(noPrefixPlainMap.isAboolean(), is(true));
    }

}
