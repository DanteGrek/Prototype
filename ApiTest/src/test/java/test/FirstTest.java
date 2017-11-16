package test;

import api.ApiEngine;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;

/**
 * Created by osolomin on 16.11.17.
 */
@Features("Test")
public class FirstTest {

    @Test
    public void firstTest(){
        Assert.assertEquals(new ApiEngine().doGet("pakeges").statusCode(), 401);
    }

    @Test(groups = {"Smoke"})
    public void secondTest(){
        Assert.assertEquals(new ApiEngine().doGet("pakeges").statusCode(), 404);
    }
}
