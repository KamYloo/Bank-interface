package Main;
import Class.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCompany extends ComapnyManagement{
    private JPanel addCompany;
    private JRadioButton transportCompanyRadioButton;
    private JRadioButton shopCompanyRadioButton;
    private JRadioButton serviceComapnyRadioButton;
    private JTextField nameCompanyField;
    private JButton cancelButton;
    private JButton addButton;
    private JComboBox bankComboBox;
    private DefaultComboBoxModel<Bank> bankDefaultComboBoxModel;

    public AddCompany(PaymentCenter paymentCenter, Bank bank, Company company, Client client) {
        super(paymentCenter, bank, company, client);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setContentPane(addCompany);
        setVisible(true);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(transportCompanyRadioButton);
        buttonGroup.add(serviceComapnyRadioButton);
        buttonGroup.add(shopCompanyRadioButton);
        transportCompanyRadioButton.setSelected(true);
        bankDefaultComboBoxModel = new DefaultComboBoxModel<>();
        for (Bank bank1 : paymentCenter.getBanks())
            bankDefaultComboBoxModel.addElement(bank1);
        bankComboBox.setModel(bankDefaultComboBoxModel);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ComapnyManagement(paymentCenter,bank,company,client);
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCompany();
            }
        });
    }
    private void addCompany()
    {
        Bank bank = (Bank) bankComboBox.getSelectedItem();
        String name = this.nameCompanyField.getText();
        if (name.isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Complete the field", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            if (transportCompanyRadioButton.isSelected())
                paymentCenter.addCompany(new TransportCompany(name,bank));
            if (shopCompanyRadioButton.isSelected())
                paymentCenter.addCompany(new ShopCompany(name,bank));
            if (serviceComapnyRadioButton.isSelected())
                paymentCenter.addCompany(new ServiceCompany(name,bank));
            JOptionPane.showMessageDialog(this,"Company has been added!");
            dispose();
            new ComapnyManagement(paymentCenter,bank,company,client).setVisible(true);
        }
    }
}
