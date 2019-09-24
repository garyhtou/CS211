package Chapter9.MinMaxAccount;

/*
 * Gary Tou
 * 9/19/2019
 */

public class MinMaxAccount extends BankingAccount {
    private int min; //minimum balance ever recorded
    private int max; //maximum balance ever recorded

    /**
     * Constructor for new Chapter9.MinMaxAccount and sets the min max to current balance
     * @param s Startup
     */
    public MinMaxAccount(Startup s){
        super(s); //Send to super class
        min = this.getBalance(); //Set min to current balance
        max = this.getBalance(); //Set max to current balance
    }

    /**
     * Sends debit request and updates min max balance. Overrides parent class
     * @param d debit request
     */
    public void debit(Debit d){
        super.debit(d); //send to super class which will set new balance
        updateMinMax(); //check the new balance
    }

    /**
     * Sends credit request and updates min max balance. Overrides parent class
     * @param c credit request
     */
    public void credit(Credit c){
        super.credit(c); //send to super class which will set new balance
        updateMinMax(); //check the new balance
    }

    /**
     * Updates the minimum and maximum account balance using the current balance.
     * I created this method to prevent having the same code in multiple places (coding best practice)
     */
    private void updateMinMax(){
        if(this.getBalance() < min){ //sets new min balance if current balance is below it
            min = this.getBalance();
        } else if (this.getBalance() > max){ //sets new max balance if current balance is above it
            max = this.getBalance();
        }
    }

    /**
     * Returns the minimum account balance ever recorded
     * @return min. bal
     */
    public int getMin(){
        return min;
    }

    /**
     * Returns the maximum account balance ever recorded
     * @return max. bal
     */
    public int getMax(){
        return max;
    }
}
