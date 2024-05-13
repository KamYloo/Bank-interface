package Class;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Company implements Serializable {
    private String name;
    private Bank bank;
    private List<Client> clients = new ArrayList();

    public Company(String name,Bank bank)
    {
        this.name=name;
        this.bank=bank;
    }
    public void addClient(Client client)
    {
        clients.add(client);
        bank.addClient(client);
    }
    public void removeClient(Client client)
    {
        clients.remove(client);
        bank.removeClient(client);
    }
    public List<Client> getClients()
    {
        return clients;
    }
    public Bank getBank()
    {
        return bank;
    }

    @Override
    public String toString() {
        return name;
    }
}
