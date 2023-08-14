package io.swagger.petstore.info;

import io.restassured.response.ValidatableResponse;
import io.swagger.petstore.TestBase.TestBase;
import io.swagger.petstore.utils.TestUtils;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class UserCRUDTest extends TestBase
{
    private String username="Vishwa22";
    private String firstName="Vishwa";
    private String lastName="Patel";
    private String email="vpatel@gmail.com"+ TestUtils.getRandomValue();
    private String password="nnnmnn";
    private String phone="1234567899";
    private int userStatus=1;
    private int userId;
    static  ValidatableResponse response;
    @Steps
    UserSteps userSteps;

    @Title("This will create a new user")
    @Test
    public void test001()
    {
        userSteps.createUser(username, firstName,lastName,email,password,phone,userStatus)
                .log().all().statusCode(201);
        userId= response.extract().path("id");
    }
}
