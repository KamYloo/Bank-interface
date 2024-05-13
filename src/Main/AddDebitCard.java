package Main;
import Class.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDebitCard extends CardsManagement{
    private JPanel addDebitCard;
    private JComboBox bankComboBox;
    private JComboBox clientComboBox;
    private JTextField numberCardField;
    private JTextField debitLimitField;
    private JButton addDebitCardButton;
    private JButton cancelButton;
    private DefaultComboBoxModel<Bank> bankDefaultComboBoxModel;
    private DefaultComboBoxModel<Client> clientDefaultComboBoxModel;
public AddDebitCard(PaymentCenter paymentCenter, Bank bank, Company company, Client client) {
    super(paymentCenter, bank, company, client);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setSize(400, 500);
    setLocationRelativeTo(null);
    setContentPane(addDebitCard);
    setVisible(true);
    bankDefaultComboBoxModel = new DefaultComboBoxModel<>();
    for (Bank bank1 : paymentCenter.getBanks())
        bankDefaultComboBoxModel.addElement(bank1);
    bankComboBox.setModel(bankDefaultComboBoxModel);
    addDebitCardButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            addCreditCard();
        }
    });
    cancelButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            cancel();
        }
    });
    bankComboBox.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Bank bank1 = (Bank) bankDefaultComboBoxModel.getSelectedItem();
            clientDefaultComboBoxModel = new DefaultComboBoxModel<>();
            for (Client client1 : bank1.getClients())
                clientDefaultComboBoxModel.addElement(client1);
            clientComboBox.setModel(clientDefaultComboBoxModel);
        }
    });
}
    public void addCreditCard()
    {
        Bank bank = (Bank) bankComboBox.getSelectedItem();
        Client client = (Client) clientComboBox.getSelectedItem();
        String numberCard = numberCardField.getText();
        String debitLimit = debitLimitField.getText();
        if (debitLimit.isEmpty() || numberCard.isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Complete the fields", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            try
            {
                long numberCardLong = Long.parseLong(numberCard);
                Double debitLimitInt = Double.parseDouble(debitLimit);
                bank.addCard(new DebitCard(numberCardLong,bank,client,debitLimitInt));
                JOptionPane.showMessageDialog(this,"Credit card has been added!");
                cancel();
            }catch (NumberFormatException e)
            {
                JOptionPane.showMessageDialog(this,"Invalid format: CardNumber or CreditLimit", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public void cancel()
    {
        dispose();
        new CardsManagement(paymentCenter,bank,company,client).setVisible(true);
    }
}
