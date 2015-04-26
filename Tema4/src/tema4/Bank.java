/*
 * Creaza un obiect de tip Bank care va ajuta la efectuarea
 * operatiunilor cu conturi
 */
package tema4;

import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.JOptionPane;

/**
 *
 * @author Ariana
 */
public class Bank implements BankProc {
    static Hashtable table = new Hashtable(100);
    static ArrayList<Account> accounts=new ArrayList(100); //array de conturi
    static ArrayList<SavingAccount> saveAcc=new ArrayList(100); //array de saving account-uri
    static ArrayList<SpendingAccount> spendAcc=new ArrayList(100); //array de spending account-uri
    static ArrayList<String> pins=new ArrayList(100); //array de pin-uri
    static ArrayList<String> deactivateAccounts=new ArrayList(100); //array de conturi dezactivate
    static int accountsNr; //numar de conturi
    static double totalAmount; //suma toatala in banca
    static int deactivateAccNr; //numar de conturi dezactivate
    static String activeAcc; //contul activ
    static String activeAccAux; //contul activ anterior
       
     /**
     * add a new account
     * @param obj - de tip SavingAccount
     */
    @Override
    public void createSavingAccount(SavingAccount obj) {
                assert isWellFormed();
                 //SavingAccount acc=(SavingAccount) obj;
                String key=obj.getPIN();
                table.put(key, obj);
                this.accountsNr++;
                //System.out.println(accountsNr);
                this.totalAmount +=obj.getDepAmount();
                this.accounts.add(obj);
                this.saveAcc.add(obj);
                this.pins.add(obj.getPIN());
               // System.out.println(accounts.size());
    }
    
    /**
     * add a new account
     * @param obj - de tip SpendingAccount
     * @pre Tabela de hashing sa aiba acelasi nr. de elemente ca si arraylist-ul de conturi
     */
     @Override
    public void createSpendingAccount(SpendingAccount obj) {
                assert isWellFormed();
                String key=obj.getPIN();
                table.put(key, obj);
                this.accountsNr++;
                //System.out.println(accountsNr);
                this.totalAmount +=obj.getAmount();
                this.accounts.add(obj);
                this.spendAcc.add(obj);
                this.pins.add(obj.getPIN());
               // System.out.println(accounts.size());
    }

    /**
     * introduce un cont in lista de conturi dezactivate
     * @param PIN - pin-ul contului care trebuie dezactivat
     * @pre !PIN.isEmpty() 
     * parametrul PIN sa aiba o valoare 
     * @pre table.isEmpty()==false 
     * HashTable-ul cu conuturi sa aiba elemente
     */
    @Override
    public void deactivateAccount(String PIN) {
        assert !PIN.isEmpty();
        assert table.isEmpty()==false;
        deactivateAccounts.add(PIN);
        deactivateAccNr++;
    }

    /**
     * scoate un cont din lista de conturi dezactivate
     * @param PIN - pin-ul contului care trebuie reactivat
     * @pre parametrul PIN sa nu fie null
     */
    @Override
    public void activateAccount(String PIN) {
        assert !PIN.isEmpty();
        for(int i=0;i<deactivateAccNr;i++)
            if(deactivateAccounts.get(i).equals(PIN)){
                deactivateAccounts.remove(i);
                deactivateAccNr--;
            }
            else
                JOptionPane.showMessageDialog(null, "Your account is active!");
        
    }
    
    
    /**
     * cauta un PIN in HashTable
     * @param PIN - pin-ul contului care trebuie cautat
     * @return true sau false
     * @pre !PIN.isEmpty() 
     * parametrul PIN sa nu fie null
     */
    public boolean searchByPIN(String PIN)
    {
        assert !PIN.isEmpty();
        String key=PIN;
      //  System.out.println(table.size());
        return table.containsKey(key);   
    }
    
     /**
     * cauta un cont daca este dezactivat
     * @param PIN - pin-ul contului care trebuie rcautat
     * @return true sau false
     */
    public boolean notDeactivate(String PIN){
        for(int i=0;i<deactivateAccNr;i++)
            if(deactivateAccounts.get(i).equals(PIN))
                return false;
        return true;
    }
    
     /**
     * returneaza tipul unui cont anume cautat in functie de PIN
     * @param key - care este de fapt pin-ul unui cont, sau cheia din HashTable
     * @return tipul contului
     * @pre (!key.isEmpty())
     * parametrul key sa nu fie null
     */
    public String searchTypeAcc(String key){
        assert (!key.isEmpty());
        //System.out.println(key);
        for (int i=0;i<this.accountsNr;i++) {
           // System.out.println(this.accounts.get(i).getPIN());
            if(this.accounts.get(i).getPIN().equals(key))
               return this.accounts.get(i).getType();   
        }
        return "Nu s-a gasit!";
    }
      /**
     * cauta daca exista pin-ul dat ca parametru
     * @param PIN - PIN-ul ce trebuie cautat
     * @return true sau false
     * @pre !PIN.isEmpty()
     * parametrul PIN sa nu fie null
     */
    public boolean existPIN(String PIN){
         assert !PIN.isEmpty();
        for (int i=0;i<this.accountsNr;i++)
            if(pins.get(i).equals(PIN))
                return true;
        return false;
    }
     /**
     * schimba contul activ
     * @param PIN - PIN-ul contului cu care se schimba contul
     * @pre !PIN.isEmpty()
     * parametrul PIN sa nu fie null
     */
    public void setActiveAccount(String PIN){
        assert !PIN.isEmpty();
        this.activeAccAux=this.activeAcc;
        this.activeAcc=PIN;
    }
      /**
     * schimba contul activ ca fiind cel activ anterior
     */
    public void resetActiveAcc(){
        this.activeAcc=this.activeAccAux;
    }
      /**
     * face conexiune intre saving account si lista de conturi, pentru a putea interoga soldul
     */
    public void showBalance(){
         for (int i=0;i<this.saveAcc.size();i++) {
              if(this.saveAcc.get(i).getPIN().equals(activeAcc))
                  JOptionPane.showMessageDialog(null,"Your balance: "+saveAcc.get(i).getDepAmount());
         }
    }
    /**
     * returneaza suma de bani din cont
     * @param PIN prin care se identifica contul
     * @return suma de bani aflata in cont
     * @pre (!PIN.isEmpty())
     * PIN sa nu fie null
     */
    public float getBalance(String PIN){
        assert (!PIN.isEmpty());
         for (int i=0;i<this.saveAcc.size();i++) {
              if(this.saveAcc.get(i).getPIN().equals(PIN))
                  return saveAcc.get(i).getDepAmount();
         }
         return 0;
    }
     /**
     *face conexiune intre saving account si lista de conturi, pentru a putea scoate bani din cont
     * */
    public void extractMoney(int a){
        for (int i=0;i<this.saveAcc.size();i++) {
              if(this.saveAcc.get(i).getPIN().equals(activeAcc))
                  saveAcc.get(i).getMoney(a);
        }
    }
    /**
     *face conexiune intre saving account si lista de conturi, pentru a putea introduce bani in cont
     * */
    public void depositMoney(float a){
        for (int i=0;i<this.saveAcc.size();i++) {
              if(this.saveAcc.get(i).getPIN().equals(activeAcc))
                  saveAcc.get(i).putMoney(a);
        }
    }
    
     /**
     *face conexiune intre spending account si lista de conturi, pentru a putea scoate bani din cont
     * */
    public void extractMoneyATM(int a){
        for (int i=0;i<this.spendAcc.size();i++) {
              if(this.spendAcc.get(i).getPIN().equals(activeAcc))
                  spendAcc.get(i).getMoney(a);
        }
    }
     /**
     * face conexiune intre spending account si lista de conturi, pentru a putea depune bani din cont
     * @pre l>0
     * limita trebuie sa fie mai mare ca si 0
     * */
      public float depositMoneyATM(int a, float l){
        assert l>0;
        float res=0;
        for (int i=0;i<this.spendAcc.size();i++) {
              if(this.spendAcc.get(i).getPIN().equals(activeAcc))
                  res=spendAcc.get(i).putMoney(a,l);
        }
        return res;
               
    }
     /**
     * face conexiune intre spending account si lista de conturi, pentru a putea interoga soldul
     * */
      public void showBalanceATM(){
         for (int i=0;i<this.spendAcc.size();i++) {
              if(this.spendAcc.get(i).getPIN().equals(activeAcc))
                  JOptionPane.showMessageDialog(null,"Your balance: "+spendAcc.get(i).getAmount());
         }
    }
      /**
     * returneaza suma de bani din spending account
     * @param PIN - pin-ul contului pe care il interogam
     * @return suma de bani din cont
     * */
     public float getBalanceATM(String PIN){
         assert (!PIN.isEmpty());
         for (int i=0;i<this.spendAcc.size();i++) {
              if(this.spendAcc.get(i).getPIN().equals(PIN))
                  return spendAcc.get(i).getAmount();
         }
         return 0;
    }
       /**
     * verifica daca nr-ul de elemente din hashtable este egal cu cei din arraylist
     * @return true sau false
     * */
    protected boolean isWellFormed() {
     if(this.table.size()!=accounts.size())
			return false;

		return true;
    }
   
}
