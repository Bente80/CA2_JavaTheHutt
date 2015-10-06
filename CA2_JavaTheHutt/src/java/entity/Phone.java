/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Bente
 */
@Entity
public class Phone
{
 @Id
  private String number;
  private String description;
    @ManyToOne(cascade={CascadeType.ALL})
    private InfoEntity infoEntity;

    public Phone()
    {
    }

    public Phone(String number, String description) {
        this.number = number;
        this.description = description;
    }
    
    public void setInfoEntity(InfoEntity e){
        this.infoEntity = e;
    }
    
    public String getNumber()
    {
        return number;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
  
    
}
