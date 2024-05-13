package Class;
import java.io.Serializable;
import java.time.LocalDateTime;

public class OperationsArchive implements Serializable {
    private Client client;
    private Bank bank;
    private long numberCard;
    private LocalDateTime dateOperation;
    private double amount;
    public OperationsArchive(Bank bank,Client client,long numberCard,LocalDateTime dateOperation,double amount)
    {
        this.bank=bank;
        this.client=client;
        this.numberCard=numberCard;
        this.dateOperation=dateOperation;
        this.amount= amount;
    }

    public Bank getBank() {
        return bank;
    }
    public Client getClient() {
        return client;
    }
    public Long getnumberCard()
    {
        return numberCard;
    }
    public LocalDateTime getDateOperation()
    {
        return dateOperation;
    }
    public Double getAmount()
    {
        return amount;
    }
}
