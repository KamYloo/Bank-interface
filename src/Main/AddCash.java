package Main;
import Class.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCash extends CardsManagement{
    private JPanel addCash;
    private JTextField amountField;
    private JButton cancelButton;
    private JButton addButton;
    private JTextField numberCardField;

    public AddCash(PaymentCenter paymentCenter, Bank bank, Company company, Client client) {
        super(paymentCenter, bank, company, client);
        this.paymentCenter = paymentCenter;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setContentPane(addCash);
        setVisible(true);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCash();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancel();
            }
        });
    }
    public void addCash()
    {
        String amount = this.amountField.getText();
        String numberCard = this.numberCardField.getText();
        if (amount.isEmpty() || numberCard.isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Complete the fields", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            try
            {
                double amountD = Double.parseDouble(amount);
                long numberCardLong = Long.parseLong(numberCard);
                boolean cardFound = false;
                for (Card card : paymentCenter.getAllCards())
                {
                    if (card.getNumber() == numberCardLong)
                    {
                        card.addBalance(amountD);
                        JOptionPane.showMessageDialog(this,"Amount has been added!");
                        cancel();
                        cardFound = true;
                        break;
                    }
                }
                if (!cardFound)
                {
                    JOptionPane.showMessageDialog(this,"Given card number does not exist!");
                    cancel();
                }
            }catch (NumberFormatException e)
            {
                JOptionPane.showMessageDialog(this,"Invalid format: Amount", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public void cancel()
    {
        dispose();
        new BankManagement(paymentCenter,bank,company,client).setVisible(true);
    }
}
