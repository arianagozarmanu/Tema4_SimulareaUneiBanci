/*
 * clasa care contine metoda de salvare a noilor date -- conturi create
 */
package tema4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Ariana
 */
public class WriteFile {
    static Bank bank=new Bank();
    public void save(){
		try{

			BufferedWriter out = new BufferedWriter(new FileWriter("date.txt"));
                        out.write(Integer.toString(bank.accountsNr));
                        out.newLine();
			for(int i=0;i<bank.accounts.size();i++)
                        {
                                Account acc=bank.accounts.get(i);
				out.write(acc.getPIN());
				out.newLine();
                                out.write(acc.getType());
				out.newLine();
                                out.write(acc.getClient().getNume());
				
				out.newLine();
                                out.write(acc.getClient().getCNP());
				out.newLine();
                                out.write(acc.getClient().getAdress());
				out.newLine();


                                if(acc.getType().equals("SavingAccount"))
                                {
                                    float res=bank.getBalance(acc.getPIN());
                                    out.write(Float.toString(res));
                                    out.newLine();
                                   
                                }
                                else
                                {
                                    float res=bank.getBalanceATM(acc.getPIN());
                                    out.write(Float.toString(res));
                                    out.newLine();
                               }
                            
                               out.write("-------------------------------------");
                               out.newLine();
                                

                               
			}
			out.close();
		}
		catch (IOException e) {}
		}
}
