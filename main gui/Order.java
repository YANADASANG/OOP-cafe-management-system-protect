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
public class Order implements Serializable{
        private String name;
        private int numbers;
        private String type;
        private int prices;

        public Order(String type,String name, int numbers, int prices) {
            this.type = type;
            this.name = name;
            this.numbers = numbers;
            this.prices = prices;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNumbers() {
            return numbers;
        }

        public void setNumbers(int numbers) {
            this.numbers = numbers;
        }

        public void setPrice(int prices){
            this.prices = prices;
        }
        public int getPrices(){
            return prices;
        }
    }
