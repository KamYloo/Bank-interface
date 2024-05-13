package Class;

public class ShopCompany extends Company{
    public ShopCompany(String name,Bank bank)
    {
        super(name,bank);
    }

    @Override
    public String toString() {
        return "ShopCompany " +super.toString();
    }
}
