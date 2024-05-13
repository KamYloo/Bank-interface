package Main;
import Class.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientManagement extends BankManagement{
    private boolean isListClientsBank;
    private JPanel clientManagement;
    private JList clientList;
    private JButton backButton;
    private JButton removeClientButton;
    private DefaultListModel<Client> clientDefaultListModel;

    public  ClientManagement(PaymentCenter paymentCenter, Bank bank, Company company, Client client,boolean isListClientsBank) {
        super(paymentCenter, bank, company, client);
        this.isListClientsBank=isListClientsBank;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setContentPane(clientManagement);
        setVisible(true);
        clientDefaultListModel = new DefaultListModel<>();
        if (isListClientsBank)
        {
            for (Client clients : bank.getClients())
            {
                clientDefaultListModel.addElement(clients);
            }
            clientList.setModel(clientDefaultListModel);
        }
        else {
            for (Client clients : company.getClients())
            {
                clientDefaultListModel.addElement(clients);
            }
            clientList.setModel(clientDefaultListModel);
        }

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                if (isListClientsBank)
                new BankManagement(paymentCenter,bank,company,client).setVisible(true);
                else {
                    new ComapnyManagement(paymentCenter,bank,company,client).setVisible(true);
                }
            }
        });
        removeClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeClient();
            }
        });
    }
    public void removeClient()
    {
        Client client = (Client) clientList.getSelectedValue();
        if(client != null)
        {
            if (isListClientsBank)
            {
                bank.removeClient(client);
                clientDefaultListModel.removeElement(client);
            }else {
                company.removeClient(client);
                clientDefaultListModel.removeElement(client);
            }
            JOptionPane.showMessageDialog(this,"Client has been deleted!");
        }
        else{
            JOptionPane.showMessageDialog(this,"Select the Client you want to delete", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
