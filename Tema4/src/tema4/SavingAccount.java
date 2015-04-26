/*
 * Clasa Saving Account 
 */
package tema4;

import javax.swing.JOptionPane;

/**
 *
 * @author Ariana
 */
public class SavingAccount extends Account {

    private float depAmount; // suma depusa la banca
    private float interest; //dobanda lunara;
    
    public SavingAccount(String pin, Person client, String type, float money) {
        super(pin, client, type);
        this.depAmount=money;
    }
    /**
         * returneaza suma de bani din cont
         * @return suma de bani
         */
     public float getDepAmount()
    {
            return this.depAmount;
        }
        /**
         * Depune suma "sum" in cont
         * @param sum - suma depusa
         */
        public void putMoney(float sum)
	{
		this.depAmount =sum + this.depAmount;
                addInterest(depAmount);

	}
        /**
         * Calculeaza dobanda si o adauga sumei din cont
         * @param a - suma din ont
         */
        public void addInterest(float a){
            this.depAmount=this.depAmount+(5*depAmount)/100;
        }
        /**
         * Extrage suma "sum" din cont
         * @param sum - suma extrasa
         */
	public void getMoney(int sum)
	{
            if(sum<=this.depAmount){
		this.depAmount=this.depAmount-sum;
                JOptionPane.showMessageDialog(null,"Succes!");
            }
            else
                JOptionPane.showMessageDialog(null, "You don't have enough money in your account! Check your balance!", null, 0);
	}
}
