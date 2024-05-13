package Main;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Class.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCreditCard extends CardsManagement{
    private JPanel addCreditCard;
    private JTextField creditLimitField;
    private JTextField numberCardField;
    private JComboBox clientComboBox;
    private JComboBox bankComboBox;
    private JButton addButton;
    private JButton cancelButton;
    private JSlider interestSlider;
    private JLabel interestLabel;
    private DefaultComboBoxModel<Bank> bankDefaultComboBoxModel;
    private DefaultComboBoxModel<Client> clientDefaultComboBoxModel;
    public AddCreditCard(PaymentCenter paymentCenter, Bank bank, Company company, Client client) {
        super(paymentCenter, bank, company, client);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setContentPane(addCreditCard);
        setVisible(true);
        interestSlider.setMajorTickSpacing(20);
        interestSlider.setMinorTickSpacing(5);
        interestSlider.setMinimum(0);
        interestSlider.setMaximum(100);
        interestSlider.setPaintLabels(true);
        interestSlider.setPaintTicks(true);
        bankDefaultComboBoxModel = new DefaultComboBoxModel<>();
        for (Bank bank1 : paymentCenter.getBanks())
            bankDefaultComboBoxModel.addElement(bank1);
        bankComboBox.setModel(bankDefaultComboBoxModel);
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
        interestSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = interestSlider.getValue();
                interestLabel.setText(value +"%");
            }
        });
        addButton.addActionListener(new ActionListener() {
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
    }
    public void addCreditCard()
    {
        Bank bank = (Bank) bankComboBox.getSelectedItem();
        Client client = (Client) clientComboBox.getSelectedItem();
        String numberCard = numberCardField.getText();
        String creditLimit = creditLimitField.getText();
        Integer interest = interestSlider.getValue();
        if (creditLimit.isEmpty() || numberCard.isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Complete the fields", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            try
            {
                long numberCardLong = Long.parseLong(numberCard);
                Double creditLimitInt = Double.parseDouble(creditLimit);
                bank.addCard(new CreditCard(numberCardLong,bank,client,creditLimitInt,interest));
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
