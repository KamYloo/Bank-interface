package Class;

public class TransportCompany extends Company{
    public TransportCompany(String name,Bank bank)
    {
        super(name,bank);
    }

    @Override
    public String toString() {
        return "TransportCompany " + super.toString();
    }
}
