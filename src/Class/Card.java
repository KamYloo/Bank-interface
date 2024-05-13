package Class;

import java.io.Serializable;

public class Card implements Serializable {
    private long number;
    private Client client;
    private Bank bank;
    private double balance;

    public Card(long number,Client client, Bank bank)
    {
        this.number=number;
        this.bank=bank;
        this.client=client;
    }
    public long getNumber()
    {
        return number;
    }
    public double getBalance()
    {
        return balance;
    }
    public Bank getBank()
    {
        return bank;
    }
    public Client getClient()
    {
        return client;
    }
public void addBalance(double sum)
{
    balance +=sum;
}
public void withdrawBalance(double sum)
{
    balance -= sum;
}

    @Override
    public String toString() {
        return bank + " "+client+" "+number+" balans"+balance;
    }
}
