/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import deploy.DeploymentConfiguration;
import entity.CityInfo;
import entity.Person;
import exception.EntityNotFoundException;
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
        
        EntityManagerFactory emf;
        Facade f; 
        EntityManager em;
       

    public FacadeJUnitTest()
    {
       emf = Persistence.createEntityManagerFactory(DeploymentConfiguration.PU_NAME);
        f = new Facade(emf); 
        em = emf.createEntityManager(); 
    }
    
    @BeforeClass
    public static void setUp(){
       EntityManagerFactory emf2 = Persistence.createEntityManagerFactory(DeploymentConfiguration.PU_NAME);
        EntityManager em2 = emf2.createEntityManager(); 
//        CreateData.testData(em2);
    }
    
    
    @Before
    public void setUpbeforeeachtest(){
        emf = Persistence.createEntityManagerFactory(DeploymentConfiguration.PU_NAME);
        f = new Facade(emf); 
        em = emf.createEntityManager();
    }
    
    @Test
    public void getAllPersonsFromDatabaseTest() throws EntityNotFoundException
    {
        List<Person> p = f.getAllPersons();
        assertEquals(p.size(), 59);
    }
    
    @Test
    public void getPersonById() throws EntityNotFoundException{
        List<Person> l = f.getPersonsByZipCode("1127");
        Person p = f.getPersonById(l.get(0).getId());
        assertEquals(p.getFirstName(), "Anna");
    }
    
    @Test
    public void getPersonsByZipCode(){
        List<Person> l = f.getPersonsByZipCode("1401");
        assertEquals(l.get(0).getFirstName(), "Hans");
    }
    
    @Test
    public void getPersonsByCity(){
        List<Person> l = f.getPersonsByCity("Frederiksberg");
        assertEquals(l.get(0).getFirstName(), "Mads");
        assertEquals(l.get(1).getFirstName(), "Ole");
        assertEquals(l.get(5).getFirstName(), "Thomas");
    }
    
    @Test
    public void getAllZipFromDatabaseTest()
    {
        List<String> allZipCodes = f.getAllZipCodes();
        assertEquals(allZipCodes.size(), 59);
    }
    
    ////Virker hvis vi kører CreateData klassen.      
//    @Test
//    public void getonePersonByPhone() throws EntityNotFoundException
//    {
//        Person p = f.getPersonByPhone("33887590");
//        assertEquals(p.getFirstName(), "Korben");    
//    }
    
}
