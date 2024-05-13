package Class;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Bank implements Serializable {
    private String name;
    private List<Client> clients = new ArrayList<>();
    private List<Card> cards = new ArrayList<>();
    public Bank(String name)
    {
        this.name=name;
    }
    public void addClient(Client client)
    {
        clients.add(client);
    }
    public void removeClient(Client client)
    {
        clients.remove(client);
    }
    public List<Client> getClients()
    {
        return clients;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void removeCard(Card card) {
        cards.remove(card);
    }

    public List<Card> getCards() {
        return cards;
    }
    public String getName()
    {
        return name;
    }

    public void setCards(List<Card> cards)
    {
        this.cards=cards;
    }
public void setClients(List<Client> clients)
{
    this.clients=clients;
}

    @Override
    public String toString() {
        return name;
    }
}
