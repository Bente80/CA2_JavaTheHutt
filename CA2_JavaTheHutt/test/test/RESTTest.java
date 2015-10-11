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
        baseURI = "http://ca2javathehutt-smcphbusiness.rhcloud.com";
        defaultParser = Parser.JSON;
        basePath = "/ca2";
    }

    @Test
    public void getOnePersonFromDataBaseCompleteStreet()
    {
        when()
                .get("/api/person/complete/25")
                .then()
                .statusCode(200)
                .body("street", equalTo("Katastrofevej"));
    }

    @Test
    public void getOnePersonFromDataBaseCompleteadditionalInfo()
    {
        when()
                .get("/api/person/complete/40")
                .then()
                .statusCode(200)
                .body("additionalInfo", equalTo("40"));
    }
    
    @Test
    public void getOnePersonFromDataBaseCompleteCity()
    {
        when()
                .get("/api/person/complete/59")
                .then()
                .statusCode(200)
                .body("city", equalTo("Praestoe"));
    }
    @Test
    public void getAllPersonsFromDataBase(){
        when()
                .get("api/person/complete")
                .then()
                .statusCode(200)
                .body("size()", equalTo(59));
    }
   
    @Test
    public void getOnePersonFromDataBaseContactinfo()
    {
        when()
                .get("/api/person/contactinfo/2")
                .then()
                .statusCode(200)
                .body("firstName", equalTo("Jabba"));
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
