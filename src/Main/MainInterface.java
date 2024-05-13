package Main;
import Class.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainInterface extends JFrame{
    protected PaymentCenter paymentCenter;
    protected Bank bank;
    protected Client client;
    protected Company company;
    private JButton bankManagementButton;
    private JButton closeButton;
    private JButton cardsManagementButton;
    private JButton companyManagementButton;
    private JPanel mainMenuPanel;
    private JButton operationsArchiveButton;
    private JButton paymentButton;


    public  MainInterface(PaymentCenter paymentCenter, Bank bank, Company company, Client client)
{
    this.paymentCenter=paymentCenter;
    this.bank=bank;
    this.client=client;
    this.company=company;
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setSize(900,500);
    setLocationRelativeTo(null);
    setContentPane(mainMenuPanel);
    setVisible(true);
    bankManagementButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new BankManagement(paymentCenter,bank,company,client).setVisible(true);
            dispose();
        }
    });
    closeButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            SystemSaveRead.SavetoFile(paymentCenter,bank,company,client);
            dispose();
        }
    });
    cardsManagementButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            new CardsManagement(paymentCenter,bank,company,client).setVisible(true);
        }
    });
    companyManagementButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            new ComapnyManagement(paymentCenter,bank,company,client).setVisible(true);
        }
    });
    operationsArchiveButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            new Archive(paymentCenter,bank,company,client,paymentCenter.getOperationsArchives()).setVisible(true);
        }
    });
    paymentButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            new Authorization(paymentCenter,bank,company,client).setVisible(true);
        }
    });
}

    public static void main(String[] args)
    {
        PaymentCenter paymentCenter = new PaymentCenter();
        Bank bank = new Bank("dsd");
        Company company = new Company("Biedronka",bank);
        Client client = new Client("xx","xx");
        SystemSaveRead systemSaveRead = new SystemSaveRead();
        SystemSaveRead.ReadFromFile(paymentCenter,bank,company,client);
        MainInterface main = new MainInterface(paymentCenter,bank,company,client);

    }
}
