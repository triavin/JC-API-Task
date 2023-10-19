package com.juaracoding;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiTest1 {

    private JSONObject requestBody;
    private RequestSpecification request;
    private Response response;
    public MovieDb movieDb;

    public void authorization(String token){
        request.header("Authorization", token);
        request.header("Content-Type", "application/json");
    }
    public void baseUrl(String endpoint){
        RestAssured.baseURI = endpoint;
    }
    @BeforeClass
    public void setUp(){
        this.movieDb = new MovieDb();
        this.requestBody = movieDb.getRequest();
    }

    @AfterClass
    public void finish(){
        System.out.println("Test Finish !");
    }

//    @Test(priority = 1)
//    public void getNowPlaying(){
//        given()
//                .header("Authorization", movieDb.getToken())
//                .header("Content-Type", "application/json")
//                .when()
//                .get(movieDb.getEndpointNowPlaying())
//                .then()
//                .statusCode(200)
//                .log().all();
//
//    }
    @Test(priority = 1)
    public void getPopularMovie(){
        baseUrl(movieDb.getEndpoint());
        request = RestAssured.given();

        authorization(movieDb.getToken());

        response = request.get(movieDb.getPopularMovie());
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("Get Now Playing, status code : " + response.getStatusCode());

    }
    @Test(priority = 2)
    public void getNowPlaying(){
        baseUrl(movieDb.getEndpoint());
        request = RestAssured.given();

        authorization(movieDb.getToken());

        response = request.get(movieDb.getNowPlaying());
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("Get Now Playing, status code : " + response.getStatusCode());

    }
    @Test(priority = 2)
    public void addRating(){
        baseUrl(movieDb.getEndpoint());
        request = RestAssured.given();

        requestBody.put("value","8,5");
        authorization(movieDb.getToken());
        request.body(requestBody.toJSONString());

        response = request.post(movieDb.addRatingMovie("968051"));
        Assert.assertEquals(response.getStatusCode(), 201);
        System.out.println("Get Now Playing, status code : " + response.getStatusCode());

    }

}
