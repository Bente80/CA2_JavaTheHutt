/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Mikkel
 */
public class EntityNotFoundException extends Exception{
    
    public EntityNotFoundException(String e){
        super(e);
    }
    
}
