package com.unittest.gegemail;

import com.unittest.gegemail.model.Mail;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UtilsUnitTest {

    @Test
    public void remove_in_array() throws Exception {
        Mail[] testArray = new Mail[]{new Mail(), new Mail(), new Mail()};
        Mail[] resultArray = Utils.removeItemAtIndex(testArray, 2);
        Assert.assertEquals( 2, resultArray.length);
    }
}