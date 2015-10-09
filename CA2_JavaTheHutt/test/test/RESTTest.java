/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import static com.jayway.restassured.RestAssured.basePath;
import static com.jayway.restassured.RestAssured.baseURI;
import static com.jayway.restassured.RestAssured.defaultParser;
import static com.jayway.restassured.RestAssured.when;
import com.jayway.restassured.parsing.Parser;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isA;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Bente
 */
public class RESTTest
{

    public RESTTest()
    {
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {
        baseURI = "http://localhost:8080";
        defaultParser = Parser.JSON;
        basePath = "/CA2_JavaTheHutt";
    }

    @Test
    public void getOnePersonFromDataBaseCompleteStreet()
    {
        when()
                .get("/api/person/complete/4")
                .then()
                .statusCode(200)
                .body("street", equalTo("Torbenvej"));
    }

    @Test
    public void getOnePersonFromDataBaseCompleteadditionalInfo()
    {
        when()
                .get("/api/person/complete/4")
                .then()
                .statusCode(200)
                .body("additionalInfo", equalTo("34, 2.tv"));
    }
    
    @Test
    public void getOnePersonFromDataBaseCompleteCity()
    {
        when()
                .get("/api/person/complete/4")
                .then()
                .statusCode(200)
                .body("city", equalTo("Bullerby"));
    }
    @Test
    public void getAllPersonsFromDataBase(){
        when()
                .get("api/person/complete")
                .then()
                .statusCode(200)
                .body("size()", equalTo(2));
    }
   
    @Test
    public void getOnePersonFromDataBaseContactinfo()
    {
        when()
                .get("/api/person/contactinfo/3")
                .then()
                .statusCode(200)
                .body("firstName", equalTo("Sille"));
    }

    @Test
    public void testOfRubberrishInURL()
    {
        when()
                .get("/api/person/Dette er noget vrøvl")
                .then()
                .statusCode(500);
    }

    @Test
    public void testOfApiNotOkay()
    {
        when()
                .get("/api/personoooongdjlsgndsl")
                .then()
                .statusCode(404);
    }
    @Test
    public void putPostDelete(){
    
    
    }
}
