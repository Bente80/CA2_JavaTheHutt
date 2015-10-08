/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

/**
 *
 * @author Bente
 */

@Entity
public class Person extends InfoEntity
{
  private String firstName;
  private String lastName;  
  @ManyToMany(cascade={CascadeType.ALL})
  private List <Hobby> hobbyList = new ArrayList();


    public Person()
    {
    }
    
    public Person(String firstName, String lastName, String email, Address address)
    {
        super(email,address);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    

   public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    } 
    public List<Hobby> getHobbyList()
    {
        return hobbyList;
    }
    
    public void addHobby(Hobby h){
        this.hobbyList.add(h);
    }
    
//    public void addAddress(Address a){
//        this.getAddress().setStreet(a.getStreet());
//    }
    
}
