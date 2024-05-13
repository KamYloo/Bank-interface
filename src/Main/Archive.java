package Main;
import Class.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Archive extends MainInterface{
    private JPanel operationsArchive;
    private JTable operationsTable;
    private JButton clearButton;
    private JButton backButton;
    private JButton searchCriteriaButton;
private DefaultTableModel operationsDefaultTableModel;
    public Archive(PaymentCenter paymentCenter, Bank bank, Company company, Client client, List<OperationsArchive> results) {
        super(paymentCenter, bank, company, client);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setContentPane(operationsArchive);
        setVisible(true);
        String[] columnames = {"Bank","Client","NumberCard","DateAuthorization","Amount"};
        operationsDefaultTableModel = new DefaultTableModel(columnames,0);
        for (OperationsArchive operationsArchive :results)
        {
            operationsDefaultTableModel.addRow(new Object[]{operationsArchive.getBank(),operationsArchive.getClient(),operationsArchive.getnumberCard(),operationsArchive.getDateOperation(),"-"+operationsArchive.getAmount()});
        }
        operationsTable.setModel(operationsDefaultTableModel);
        searchCriteriaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new SearchCriteria(paymentCenter,bank,company,client,results).setVisible(true);
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MainInterface(paymentCenter,bank,company,client).setVisible(true);
            }
        });
    }
    public void clear()
    {
            operationsDefaultTableModel.setRowCount(0);
            for (OperationsArchive operationsArchive: paymentCenter.getOperationsArchives())
                paymentCenter.removeOperationsArchive(operationsArchive);
            JOptionPane.showMessageDialog(this,"All Operations have been deleted!");
    }
}
