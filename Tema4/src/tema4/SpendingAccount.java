/*
 * clasa Spending Account
 */
package tema4;

import javax.swing.JOptionPane;

/**
 *
 * @author Ariana
 */
public class SpendingAccount extends Account{
      private float amount; // suma imprumutata de la banca
      private float poundage; //comision

    public SpendingAccount(String pin, Person client, String type, float money) {
        super(pin, client, type);
        this.amount=money;
    }
    /**
         * returneaza suma de bani din cont
         * @return suma de bani
         */
     public float getAmount()
	{  
		return this.amount;
	}
      /**
         * Depune suma "sum" in cont depinzand de o anumita limita
         * @param sum - suma depusa
         * @param l - limita impusa
         * @return banii care au ramas peste limita
         */
     public float putMoney(int sum,float l)
	{
            if((sum + this.amount)<l)
		this.amount =sum + this.amount;
            else{
                float aux=this.amount;
                this.amount=l;
                return (sum+aux)-l;
            }
            return 0;
	}
        /**
         * Extrage suma "sum" din cont
         * @param sum - suma extrasa
         */
	public void getMoney(int sum)
	{
            if(sum<=this.amount){
		this.amount=this.amount-sum;
                calcPoundage();
                JOptionPane.showMessageDialog(null,"Succes!");
            }
            else
                  JOptionPane.showMessageDialog(null,"You don't have enough money in your account! Check your balance!");
	}
        
        /**
         * calculeaza comision pentru extragere bani din cont
         */
        public void calcPoundage(){
            this.amount=this.amount-((float)0.05*this.amount)/100;
        }
}
