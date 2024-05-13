package Class;

public class CreditCard extends Card{
    private double creditLimit;
    private int interest;
    public CreditCard(long number, Bank bank,Client client, double creditLimit, int interest)
    {
        super(number,client,bank);
        this.creditLimit=creditLimit;
        this.interest=interest;
    }
    public double getCreditLimit()
    {
        return creditLimit;
    }
    public int getInterest()
    {
        return interest;
    }

    @Override
    public String toString() {
        return super.toString() + " "+creditLimit+" "+interest;
    }
}
