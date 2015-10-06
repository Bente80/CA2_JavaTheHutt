/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javax.persistence.Persistence;

/**
 *
 * @author Bente
 */
public class ShemaBuilder
{
    public static void main(String[] args)
    {
        Persistence.generateSchema("PU", null);
    }
}
