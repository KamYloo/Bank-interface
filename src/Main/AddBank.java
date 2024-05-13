package Main;
import Class.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBank extends BankManagement{
    private JTextField nameBank;
    private JButton addButton;
    private JButton cancelButton;
    private JPanel addBank;
    public AddBank(PaymentCenter paymentCenter,Bank bank, Company company, Client client)
    {
        super(paymentCenter,bank,company,client);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400,300);
        setLocationRelativeTo(null);
        setContentPane(addBank);
        setVisible(true);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBank();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new BankManagement(paymentCenter,bank,company,client).setVisible(true);
            }
        });
    }

    private void addBank()
    {
        String name = this.nameBank.getText();
        if (name.isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Uzupelnij pola", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            paymentCenter.addBank(new Bank(name));
            JOptionPane.showMessageDialog(this,"Bank zostal dodany!");
            dispose();
            new BankManagement(paymentCenter,bank,company,client).setVisible(true);
        }
    }
}
