/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafe;

import java.io.Serializable;

/**
 *
 * @author annie
 */
public class Drink extends Order implements Serializable{

    public Drink(String type,String name,int numbers) {
        super(type,name,numbers);
    }
    
}
