/*
 * Clasa pentru creearea unui obiect de tip Account
 */
package tema4;

/**
 *
 * @author Ariana
 */
public class Account {
    private String pin;
    private Person client;
    private String type; 
   

    public Account(String pin,Person client, String type) {
        this.pin=pin;
        this.client = client;
        this.type = type;
    }

  
/**
 * return PIN account
 * @return pin
 */
         public String getPIN(){
            return this.pin;
         }

       
/**
 * return the owner of the account 
 * @return client
 */
         public Person getClient(){
		return this.client;
	}
/**
 * return the account type
 * @return type
 */
         public String getType(){
             return this.type;
         }
         
       
}
