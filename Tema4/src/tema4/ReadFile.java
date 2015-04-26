/*
 * clasa care contine o metoda de citire din fisier.
 */
package tema4;

import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Ariana
 */
public class ReadFile {
    static Bank bank=new Bank();
    public void hashPopulate(){
        FileInputStream f = null;
        try {
            f = new FileInputStream( "date.txt" );
        }catch(FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,e);
        }
        DataInputStream dis = new DataInputStream(f);
        try {
            Person client;
            String name,cnp,adress,type,pin,line;
            float amount;
            
     
            
            int nrAccounts=Integer.parseInt(dis.readLine());
            
            for (int i = 0; i < nrAccounts; i++) {
                 pin = dis.readLine();
                 type = dis.readLine();
                 name = dis.readLine();
                 cnp = dis.readLine();
                 adress = dis.readLine();
                 client= new Person(name,adress,cnp);

                 amount = Float.parseFloat(dis.readLine());

                 line = dis.readLine();

                 if (type.compareTo("SavingAccount")==0)
                 {
                    SavingAccount sa= new SavingAccount(pin,client,type,amount);
                    bank.createSavingAccount(sa);
                 }
                 else
                     if (type.compareTo("SpendingAccount")==0)
                     {
                        SpendingAccount spa = new SpendingAccount(pin,client,type,amount);
                        bank.createSpendingAccount(spa);
                     }

            }
        }
        catch(IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
     }
    }
    
