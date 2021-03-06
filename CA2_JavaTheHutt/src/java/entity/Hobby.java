/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


/**
 *
 * @author Bente
 */
@Entity
public class Hobby
{
 @Id
  private String name;
  private String description; 
    @ManyToMany(mappedBy = "hobbyList",cascade={CascadeType.ALL})
    private List<Person> persons;

    public Hobby()
    {
    }

    public Hobby(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
    
    public void addPerson(Person p){
        this.persons.add(p);
    }
  
}
