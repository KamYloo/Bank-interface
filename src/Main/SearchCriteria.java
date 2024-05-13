package Main;
import Class.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SearchCriteria extends Archive{
    private JPanel search;
    private JTextField bankField;
    private JTextField companyField;
    private JTextField clientNameField;
    private JTextField numberCardField;
    private JTextField amountField;
    private JButton cancelButton;
    private JButton searchButton;
    private JTextField clientSurnameField;

    public SearchCriteria(PaymentCenter paymentCenter, Bank bank, Company company, Client client, List<OperationsArchive> results) {
        super(paymentCenter, bank, company, client,results);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setContentPane(search);
        setVisible(true);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Archive(paymentCenter,bank,company,client,paymentCenter.getOperationsArchives()).setVisible(true);
            }
        });
    }
    public void search()
    {
        String bank1 = this.bankField.getText();
        String company1 = this.companyField.getText();
        String clientName = this.clientNameField.getText();
        String clientSurname = this.clientSurnameField.getText();
        String numberCard1 = this.numberCardField.getText();
        String amount1 = this.amountField.getText();
            try
            {
                List<OperationsArchive> results = paymentCenter.searchArchive(paymentCenter.getOperationsArchives(),bank1,clientName,clientSurname,amount1,numberCard1);
                JOptionPane.showMessageDialog(this,"Success!");
                dispose();
                new Archive(paymentCenter,bank,company,client,results).setVisible(true);
                System.out.println(results);
            }catch (NumberFormatException e)
            {
                JOptionPane.showMessageDialog(this,"Invalid format: NumberCard or Amount", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        }

}
