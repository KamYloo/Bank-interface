package Main;
import Class.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class Authorization extends MainInterface{
    private JPanel authorization;
    private JTextField numberCardField;
    private JTextField amountField;
    private JButton cancelButton;
    private JButton payButton;
    public Authorization(PaymentCenter paymentCenter, Bank bank, Company company, Client client) {
        super(paymentCenter, bank, company, client);
        this.paymentCenter=paymentCenter;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setContentPane(authorization);
        setVisible(true);
        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authorization();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancel();
            }
        });
    }
    public void authorization()
    {
        String numberCard = this.numberCardField.getText();
        String amount = this.amountField.getText();
        if (numberCard.isEmpty() || amount.isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Complete the fields", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            try
            {
                long numberCardLong = Long.parseLong(numberCard);
                double amountD = Double.parseDouble(amount);
                paymentCenter.paymentAuthorization(paymentCenter.getAllCards(),amountD, LocalDateTime.now(),numberCardLong);
                cancel();
            }catch (NumberFormatException e)
            {
                JOptionPane.showMessageDialog(this,"Invalid format: CardNumber or CreditLimit", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public void cancel()
    {
        dispose();
        new MainInterface(paymentCenter,bank,company,client).setVisible(true);
    }
}
