package Main;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Class.*;
public class BankManagement extends MainInterface{
    private JButton addBankButton;
    private JButton backButton;
    private JButton removeBankButton;
    private JPanel bankManagement;
    private JList listBanks;
    private JButton addClientToBankButton;
    private JButton addFundsButton;
    private DefaultListModel<Bank> listModel;


    public  BankManagement(PaymentCenter paymentCenter,Bank bank, Company company, Client client)
    {
        super(paymentCenter,bank,company,client);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(700,500);
        setLocationRelativeTo(null);
        setContentPane(bankManagement);
        setVisible(true);
      listModel = new DefaultListModel<>();
      for (Bank banks : paymentCenter.getBanks())
          listModel.addElement(banks);
      listBanks.setModel(listModel);
     // listBanks.setCellRenderer(new CustomListCellRenderer());
        addBankButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddBank(paymentCenter,bank,company,client).setVisible(true);
                dispose();
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MainInterface(paymentCenter,bank,company,client).setVisible(true);
            }
        });
        removeBankButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeBank();
            }
        });
        addClientToBankButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               addClientBank();
            }
        });
        listBanks.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2)
                {
                    dispose();
                    Bank bank1 = (Bank) listBanks.getSelectedValue();
                    new ClientManagement(paymentCenter,bank1,company,client,true).setVisible(true);
                }
            }
        });
        addFundsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AddCash(paymentCenter,bank,company,client).setVisible(true);
            }
        });
    }

    public void removeBank()
    {
        Bank bank = (Bank) listBanks.getSelectedValue();
        if(bank != null)
        {
            listModel.removeElement(bank);
            paymentCenter.removeBank(bank);
            JOptionPane.showMessageDialog(this,"Bank has been deleted!");
        }
        else{
            JOptionPane.showMessageDialog(this,"Select the bank you want to delete", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void addClientBank()
    {
        Bank bank = (Bank) listBanks.getSelectedValue();
        if(bank != null)
        {
            dispose();
            new AddClientBank(paymentCenter,bank,company,client,false).setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(this,"Select the bank where you want to add a customer", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
