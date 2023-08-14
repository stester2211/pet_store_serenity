package io.swagger.petstore.info;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.swagger.petstore.models.UserPojo;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class UserSteps
{
    @Step
    public ValidatableResponse createUser(String username, String firstName, String lastName, String email, String password, String phone,int userStatus)
    {
        UserPojo userPojo= new UserPojo();
        userPojo.setUsername(username);
        userPojo.setFirstName(firstName);
        userPojo.setLastName(lastName);
        userPojo.setEmail(email);
        userPojo.setPassword(password);
        userPojo.setPhone(phone);
        userPojo.setUserStatus(userStatus);

        return SerenityRest.given().log().all()
                //.basePath(Path.USERS)
                .contentType(ContentType.JSON)
                .body(userPojo)
                .when()
                .post()
                .then();
    }
}
