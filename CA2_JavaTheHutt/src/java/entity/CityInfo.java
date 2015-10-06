/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;


/**
 *
 * @author Bente
 */
   @Entity
public class CityInfo
{
 @Id
  private String zip;
  private String city;
  @OneToMany(mappedBy = "cityInfo",cascade={CascadeType.ALL})
  private List <Address> addressList = new ArrayList();

    public CityInfo()
    {
    }

    public CityInfo(String zip, String city) {
        this.zip = zip;
        this.city = city;
    }
    
    
  
    public String getZip()
    {
        return zip;
    }

    public void setZip(String zip)
    {
        this.zip = zip;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }
    
    public void addAddress(Address a){
        this.addressList.add(a);
    }
  
}
