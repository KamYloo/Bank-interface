package Main;
import Class.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ComapnyManagement extends MainInterface{
    private JPanel companyManagement;
    private JList companyList;
    private JButton addCompanyButton;
    private JButton removeCompanyButton;
    private JButton backButton;
    private JButton addClientButton;
    private DefaultListModel<Company> companyDefaultListModel;
    public  ComapnyManagement(PaymentCenter paymentCenter, Bank bank, Company company, Client client) {
        super(paymentCenter, bank, company, client);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setContentPane(companyManagement);
        setVisible(true);
        companyDefaultListModel = new DefaultListModel<>();
        for (Company company1 : paymentCenter.getCompanies())
            companyDefaultListModel.addElement(company1);
        companyList.setModel(companyDefaultListModel);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MainInterface(paymentCenter,bank,company,client).setVisible(true);
            }
        });
        addCompanyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AddCompany(paymentCenter,bank,company,client).setVisible(true);
            }
        });
        removeCompanyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeCompany();
            }
        });
        addClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addClient();
            }
        });
        companyList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2)
                {
                    dispose();
                    Company company = (Company) companyList.getSelectedValue();
                    Bank bank1 = company.getBank();
                    new ClientManagement(paymentCenter,bank1,company,client,false).setVisible(true);
                }
            }
        });
    }
    public void removeCompany()
    {
        Company company = (Company) companyList.getSelectedValue();
        if(company != null)
        {
            companyDefaultListModel.removeElement(company);
            paymentCenter.removeCompany(company);
            JOptionPane.showMessageDialog(this,"Company has been deleted!");
        }
        else{
            JOptionPane.showMessageDialog(this,"Select the Company you want to delete", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void addClient()
    {
        Company company = (Company) companyList.getSelectedValue();
        Bank bank = company.getBank();
        if(company != null)
        {
            dispose();
            new AddClientBank(paymentCenter,bank,company,client,true).setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(this,"Select the Company where you want to add a customer", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
