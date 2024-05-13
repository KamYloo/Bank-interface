package Main;
import Class.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddATMCard extends CardsManagement{
    private JPanel addATMsCard;
    private JTextField numberCardField;
    private JTextField withDrawalLimitField;
    private JComboBox bankComboBox;
    private JComboBox clientComboBox;
    private JCheckBox accesToATMsCheckBox;
    private JButton cancelButton;
    private JButton addButton;
    private DefaultComboBoxModel<Bank> bankDefaultComboBoxModel;
    private DefaultComboBoxModel<Client> clientDefaultComboBoxModel;
    public AddATMCard(PaymentCenter paymentCenter, Bank bank, Company company, Client client) {
        super(paymentCenter, bank, company, client);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setContentPane(addATMsCard);
        setVisible(true);
        bankDefaultComboBoxModel = new DefaultComboBoxModel<>();
        for (Bank bank1 : paymentCenter.getBanks())
            bankDefaultComboBoxModel.addElement(bank1);
        bankComboBox.setModel(bankDefaultComboBoxModel);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAddATMsCard();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new CardsManagement(paymentCenter,bank,company,client).setVisible(true);
            }
        });
        bankComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Bank bank = (Bank) bankDefaultComboBoxModel.getSelectedItem();
                clientDefaultComboBoxModel = new DefaultComboBoxModel<>();
                for (Client client1 : bank.getClients())
                    clientDefaultComboBoxModel.addElement(client1);
                clientComboBox.setModel(clientDefaultComboBoxModel);
            }
        });
    }
    public void addAddATMsCard()
    {
        Bank bank = (Bank) bankComboBox.getSelectedItem();
        Client client = (Client) clientComboBox.getSelectedItem();
        String numberCard = numberCardField.getText();
        String withDrawalLimit = withDrawalLimitField.getText();
        if (withDrawalLimit.isEmpty() || numberCard.isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Complete the fields", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            try
            {
                long numberCardLong = Long.parseLong(numberCard);
                Double withDrawalLimitint = Double.parseDouble(withDrawalLimit);
                if (accesToATMsCheckBox.isSelected())
                    bank.addCard(new ATMCard(numberCardLong,bank,client,true,withDrawalLimitint));
                else
                    bank.addCard(new ATMCard(numberCardLong,bank,client,false,withDrawalLimitint));
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
