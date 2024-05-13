package Class;

public class DebitCard extends Card{
    private double debitLimit;

    public DebitCard(long number, Bank bank,Client client, double debitLimit)
    {
        super(number,client,bank);
        this.debitLimit=debitLimit;
    }
    public double getDebitLimit()
    {
        return debitLimit;
    }

    @Override
    public String toString() {
        return super.toString() + " "+debitLimit;
    }
}
