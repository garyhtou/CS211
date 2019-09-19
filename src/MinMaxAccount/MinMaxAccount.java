package MinMaxAccount;

public class MinMaxAccount extends BankingAccount {
    private int min;
    private int max;

    public MinMaxAccount(Startup s){
        super(s);
        min = this.getBalance();
        max = this.getBalance();
    }

    public void debit(Debit d){
        super.debit(d);
        resetMinMax();
    }

    public void credit(Credit c){
        super.credit(c);
        resetMinMax();
    }

    private void resetMinMax(){
        if(this.getBalance() < min){
            min = this.getBalance();
        } else if (this.getBalance() > max){
            max = this.getBalance();
        }
    }

    public int getMin(){
        return min;
    }

    public int getMax(){
        return max;
    }
}
