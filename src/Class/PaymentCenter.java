package Class;

import javax.swing.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PaymentCenter extends JFrame implements Serializable {
    private List<Bank> banks = new ArrayList();
    private List<Company> companies = new ArrayList();
    private List<OperationsArchive> operationsArchives = new ArrayList();
public void addBank(Bank bank)
{
    banks.add(bank);
}
public void removeBank(Bank bank)
{
    banks.remove(bank);
}
public List<Bank> getBanks()
{
    return banks;
}
public void setBanks(List<Bank> banks)
{
    this.banks = banks;
}
    public void addCompany(Company company)
    {
        companies.add(company);
    }
    public void removeCompany(Company company)
    {
        companies.remove(company);
    }
    public List<Company> getCompanies()
    {
        return companies;
    }
    public void removeOperationsArchive(OperationsArchive operationsArchive)
    {
        operationsArchives.remove(operationsArchive);
    }
    public void setCompanies(List<Company> companies)
    {
        this.companies=companies;
    }
    public List<OperationsArchive> getOperationsArchives()
    {
        return operationsArchives;
    }
    public void setOperationsArchives(List<OperationsArchive> operationsArchives)
    {
        this.operationsArchives=operationsArchives;
    }
    public List<Card> getAllCards()
    {
        List<Card> allCards = new ArrayList<>();
        for (Bank bank:banks) {
            allCards.addAll(bank.getCards());
        }
        return allCards;
    }
    public void paymentAuthorization(List<Card> cards, double sum, LocalDateTime dateAuthorization, long numberCard)
    {
        for (Card card : cards)
        {
            if (card instanceof ATMCard)
            {
                ATMCard atmCard = (ATMCard) card;
                if (numberCard == atmCard.getNumber() && sum <= atmCard.getBalance() && sum <= atmCard.getWithdrawalLimit() && atmCard.isAccesstoATMs() == true)
                {
                    atmCard.withdrawBalance(sum);
                    OperationsArchive operationsArchive = new OperationsArchive(atmCard.getBank(),atmCard.getClient(),atmCard.getNumber(),dateAuthorization,sum);
                    operationsArchives.add(operationsArchive);
                    JOptionPane.showMessageDialog(this,"Autoryzacja powiodla sie!");
                    return;
                }
            }
            else if (card instanceof DebitCard)
            {
                DebitCard debitCard = (DebitCard) card;
                if (numberCard == debitCard.getNumber() && sum <= debitCard.getBalance() && sum <= debitCard.getDebitLimit())
                {
                    debitCard.withdrawBalance(sum);
                    OperationsArchive operationsArchive = new OperationsArchive(debitCard.getBank(),debitCard.getClient(),debitCard.getNumber(),dateAuthorization,sum);
                    operationsArchives.add(operationsArchive);
                    JOptionPane.showMessageDialog(this,"Autoryzacja powiodla sie!");
                    return;
                }
            }
            else if (card instanceof CreditCard)
            {
                CreditCard creditCard = (CreditCard) card;
                if (numberCard == creditCard.getNumber() && sum <= creditCard.getBalance() && sum <= creditCard.getCreditLimit())
                {
                    creditCard.withdrawBalance(sum);
                    OperationsArchive operationsArchive = new OperationsArchive(creditCard.getBank(),creditCard.getClient(),creditCard.getNumber(),dateAuthorization,sum);
                    operationsArchives.add(operationsArchive);
                    JOptionPane.showMessageDialog(this,"Autoryzacja powiodla sie!");
                    return;
                }
            }
            else {
                JOptionPane.showMessageDialog(this,"Autoryzacja nie powiodla sie!");
            }
        }
    }
    public List<OperationsArchive> searchArchive(List<OperationsArchive> archive, String bankName, String clientName, String clientSurname, String amount, String numberCard)
    {
        return archive.stream().filter(operationsArchive -> (bankName.isEmpty() || operationsArchive.getBank().getName().equals(bankName)) &&
                (clientName.isEmpty() || operationsArchive.getClient().getName().equals(clientName)) &&
                (clientSurname.isEmpty() || operationsArchive.getClient().getSurname().equals(clientSurname)) &&
                (numberCard.isEmpty() || operationsArchive.getnumberCard().equals(Long.parseLong(numberCard))) &&
                (amount.isEmpty() || operationsArchive.getAmount() == Double.parseDouble(amount))).collect(Collectors.toList());
    }
}
