/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.CityInfo;
import entity.Person;
import facade.Facade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import sql.CreateData;

/**
 *
 * @author Bente
 */
public class FacadeJUnitTest
{
       
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
        Facade f = new Facade(emf); 
        EntityManager em = emf.createEntityManager();
        
        

    public FacadeJUnitTest()
    {
        
    }
    
    @BeforeClass
    public static void setUp(){
//        CreateData.testData(em);
    }
    
    @Test
    public void getAllPersonsFromDatabaseTest()
    {
        List<Person> p = f.getAllPersons();
        assertEquals(p.size(), 2);
    }
    
    @Test
    public void getPersonById(){
        Person p = f.getPersonById(4L);
        assertEquals(p.getFirstName(), "Korben");
    }
    
    @Test
    public void getPersonsByZipCode(){
        List<Person> l = f.getPersonsByZipCode("3487");
        assertEquals(l.get(0).getFirstName(), "Korben");
    }
    
    @Test
    public void getPersonsByCity(){
        List<Person> l = f.getPersonsByCity("Bullerby");
        assertEquals(l.get(0).getFirstName(), "Korben");
    }
    
    @Test
    public void getonePersonByPhone()
    {
        Person p = f.getPersonByPhone("33887590");
        assertEquals(p.getFirstName(), "Korben");
        
    }
    
    @Test
    public void getAllZipFromDatabaseTest()
    {
        List<String> allZipCodes = f.getAllZipCodes();
        assertEquals(allZipCodes.size(), 4);
    }
}
