package Main;
import Class.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddClientBank extends BankManagement{
    private boolean isClientBankAndCompany;
    private JTextField nameField;
    private JTextField surnameField;
    private JButton addButton;
    private JButton cancelButton;
    private JPanel addBankClient;
    public AddClientBank(PaymentCenter paymentCenter, Bank bank, Company company, Client client, boolean isClientBankAndCompany) {
        super(paymentCenter, bank, company, client);
        this.isClientBankAndCompany=isClientBankAndCompany;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setContentPane(addBankClient);
        setVisible(true);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addClientBank();
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
    public void addClientBank()
    {
        String name = this.nameField.getText();
        String surname = this.surnameField.getText();
        if (name.isEmpty() || surname.isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Uzupelnij pola", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
               if (isClientBankAndCompany)
               {
                   company.addClient(new Client(name,surname));
                   JOptionPane.showMessageDialog(this, "Osoba zostala dodana do firmy!");
                   dispose();
                   new ComapnyManagement(paymentCenter, bank, company, client).setVisible(true);
               }
               else {
                   bank.addClient(new Client(name, surname));
                   JOptionPane.showMessageDialog(this, "Osoba zostala dodana!");
                   dispose();
                   new BankManagement(paymentCenter, bank, company, client).setVisible(true);
               }
        }
    }
}
