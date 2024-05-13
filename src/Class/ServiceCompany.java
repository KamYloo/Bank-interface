package Class;

public class ServiceCompany extends Company{
    public ServiceCompany(String name,Bank bank)
    {
        super(name,bank);
    }

    @Override
    public String toString() {
        return "ServiceCompany " +super.toString();
    }
}
