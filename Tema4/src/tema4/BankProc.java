/*
 *interfata pe care o impementeaza clasa Bank
 */
package tema4;

/**
 *
 * @author Ariana
 */
public interface BankProc {
    void createSavingAccount(SavingAccount obj);
    void createSpendingAccount(SpendingAccount obj);
    void deactivateAccount(String PIN);
    void activateAccount(String PIN);   
    void extractMoney(int a);
    void depositMoney(float a);
}
