package Class;

public class ATMCard extends Card{
    private boolean accesstoATMs;
    private double withdrawalLimit;
    public ATMCard(long number, Bank bank,Client client,boolean accesstoATMs, double withdrawalLimit)
    {
        super(number,client,bank);
        this.accesstoATMs=accesstoATMs;
        this.withdrawalLimit=withdrawalLimit;
    }
    public boolean isAccesstoATMs()
    {
        return accesstoATMs;
    }
    public double getWithdrawalLimit()
    {
        return withdrawalLimit;
    }
    @Override
    public String toString() {
        return super.toString() + " "+withdrawalLimit+" "+accesstoATMs;
    }
}
