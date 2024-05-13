package Main;
import Class.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardsManagement extends MainInterface{
    private JButton removeCardButton;
    private JButton backButton;
    private JButton addCreditCardButton;
    private JPanel cardsManagement;
    private JButton addDebitCardButton;
    private JButton addATMCardButton;
    private JTable cardsTable;
    private DefaultTableModel cardTableModel;

    public  CardsManagement(PaymentCenter paymentCenter, Bank bank, Company company, Client client) {
        super(paymentCenter, bank, company, client);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(900, 500);
        setLocationRelativeTo(null);
        setContentPane(cardsManagement);
        setVisible(true);
        String[] columnNames = {"Bank","Client","NumberCard","Balance","WithdrawalLimit","CreditLimit","Interest","debitLimit","AccesstoATMs"};
        cardTableModel = new DefaultTableModel(columnNames,0);
            for (Card card : paymentCenter.getAllCards())
            {
                if (card instanceof ATMCard)
                {
                    ATMCard atmCard = (ATMCard) card;
                    cardTableModel.addRow(new Object[]{atmCard.getBank(),atmCard.getClient(),atmCard.getNumber(),atmCard.getBalance(),atmCard.getWithdrawalLimit(),"-","-","-",atmCard.isAccesstoATMs()});
                }
                 if (card instanceof CreditCard)
                {
                    CreditCard creditCard = (CreditCard) card;
                    cardTableModel.addRow(new Object[]{creditCard.getBank(),creditCard.getClient(),creditCard.getNumber(),creditCard.getBalance(),"-",creditCard.getCreditLimit(),creditCard.getInterest()+"%","-"});
                }
                 if (card instanceof DebitCard)
                {
                    DebitCard debitCard = (DebitCard) card;
                    cardTableModel.addRow(new Object[]{debitCard.getBank(),debitCard.getClient(),debitCard.getNumber(),debitCard.getBalance(),"-","-","-",debitCard.getDebitLimit(),"-"});
                }
            }
            cardsTable.setModel(cardTableModel);
        removeCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeCard();
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MainInterface(paymentCenter,bank,company,client).setVisible(true);
            }
        });
        addCreditCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AddCreditCard(paymentCenter,bank,company,client).setVisible(true);
            }
        });
        addDebitCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AddDebitCard(paymentCenter,bank,company,client).setVisible(true);
            }
        });
        addATMCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AddATMCard(paymentCenter,bank,company,client).setVisible(true);
            }
        });
    }
    public void removeCard() {
      // Card card = (Card) cardsTable.getSelectedRow();
      //  if (card != null) {
         //   cardDefaultListModel.removeElement(card);
       //     bank.removeCard(card);
      //      JOptionPane.showMessageDialog(this, "Card has been deleted!");
      //  } else {
      //      JOptionPane.showMessageDialog(this, "Select the Card you want to delete", "Error", JOptionPane.ERROR_MESSAGE);
      //  }
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
