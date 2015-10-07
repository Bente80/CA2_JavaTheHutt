/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import entity.Person;
import javax.ws.rs.core.Context;
import com.google.gson.JsonParser;
import entity.Phone;
import facade.Facade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Bente
 */
@Path("person/")
public class RestService
{

    @Context
    private UriInfo context;
        EntityManagerFactory emf;
        EntityManager em;
        Facade f;

    /**
     * Creates a new instance of RestService
     */
    
    public RestService()
    {
        emf = Persistence.createEntityManagerFactory("PU");
        em = emf.createEntityManager();
        f = new Facade(emf);
    }

    @GET
    @Path("complete/{id}")
    @Produces("application/json")
    public Response getProjectById()
    {
        return Response.status(Response.Status.OK).entity(makePerson(f.getPersonById(new Long(id))).toString()).build(); 
    }

    /**
     * PUT method for updating or creating an instance of RestService
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content)
    {
    }

    private JsonObject makePerson(Person person)
    {
        JsonObject jo = new JsonObject();
        jo.addProperty("firstName", person.getFirstName());
        jo.addProperty("lastName", person.getLastName());
        jo.addProperty("email", person.getEmail());
        jo.addProperty("street", person.getAddress().getStreet());
        jo.addProperty("additionalInfo", person.getAddress().getAdditionalInfo());
        jo.addProperty("zipCode", person.getAddress().getCityInfo().getZip());
        jo.addProperty("city", person.getAddress().getCityInfo().getCity());
        JsonArray JpersTlf = new JsonArray();
        JsonObject pers;
        for (Phone phone : person.getPhoneList()){
        pers = new JsonObject();
        pers.addProperty("number", phone.getNumber());
        pers.addProperty("description", phone.getDescription());
        JpersTlf.add(pers);
        }
        jo.add("PersonTlf", JpersTlf);
        return jo;
    }
}
