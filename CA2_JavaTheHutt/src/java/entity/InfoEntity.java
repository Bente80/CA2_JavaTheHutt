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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 *
 * @author Bente
 */
@Entity
@Inheritance(strategy= InheritanceType.JOINED)
public class InfoEntity
{
 @Id
 @GeneratedValue(strategy = GenerationType.SEQUENCE)  
  private Long ID;
  private String email;
    @ManyToOne(cascade={CascadeType.ALL})
    private Address address;
    @OneToMany(mappedBy = "infoEntity",cascade={CascadeType.ALL})
    private List <Phone> phoneList = new ArrayList();

    public InfoEntity()
    {
    }

    public InfoEntity(String email, Address address) {
        this.email = email;
        this.address = address;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public void addPhone(Phone p){
        this.phoneList.add(p);
    }
}
