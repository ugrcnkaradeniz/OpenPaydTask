package com.OpenPayd.step_definitions;

import com.OpenPayd.utilities.ConfigurationReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;

public class ApiStepDefs {
    Response response;
    String url= ConfigurationReader.get("baseurl")+"posts";
    @When("I get list of blog posts")
    public void iGetListOfBlogPosts() {
         response = RestAssured.given().accept(ContentType.JSON)
                .when().get(url);
         Assert.assertEquals(200,response.statusCode());
         Assert.assertEquals("application/json; charset=utf-8",response.contentType());
    }



    @Then("user {int} should have {int} posts")
    public void userShouldHavePosts(int user, int numposts) {
        response = RestAssured.given().accept(ContentType.JSON)
                .and()
                .queryParam("userId",user)
                .when().get(url);
        Assert.assertEquals(200,response.statusCode());
        List<Object> allUserId=response.path("userId");
        int expectedNumPosts=numposts;
        int actualNumPosts=allUserId.size();
        Assert.assertEquals(expectedNumPosts,actualNumPosts);



    }
    @Then("verify each blog posts have unique ID")
    public void verifyEachBlogPostsHaveUniqueID() {
        List<Object> AllUniqueId=response.path("id");

        for (Object Ids : AllUniqueId) {
         Assert.assertFalse(Ids.toString().isEmpty());
            
        }
    }
}
