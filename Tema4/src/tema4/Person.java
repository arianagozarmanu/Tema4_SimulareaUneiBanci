/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

/**
 *
 * @author Ariana
 */
public class Person {
    private String name="";
    private String address="";
    private String cnp="";

   
      public Person(String name,String address,String cnp) {
                this.name = name;
		this.address = address;
                this.cnp=cnp;
	}
      /**
       * Intoarce numele clientului
       * @return name - numele clientului
       */
        public String getNume()
        {
            return this.name;
        }
  
        /**
         * Intoarce CNP-ul clientului
         * @return CNP - codul numeric personal al clientului
         */
        public String getCNP()
        {
            return this.cnp;
        }
        /**
         * Intoarce adresa clientului
         * @return adresa clientului
         */
        public String getAdress()
        {   
            return this.address;
        }
       
}
