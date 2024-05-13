package Class;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class SystemSaveRead implements Serializable {
    public static void SavetoFile(PaymentCenter paymentCenter,Bank bank, Company company,Client client) {
        try {
            FileOutputStream fileOut1 = new FileOutputStream("SystemData.txt");
            FileOutputStream fileOut2 = new FileOutputStream("OperationsArchive.txt");
            ObjectOutputStream out1 = new ObjectOutputStream(fileOut1);
            ObjectOutputStream out2 = new ObjectOutputStream(fileOut2);
            List<Bank> banks = new ArrayList<>(paymentCenter.getBanks());
            List<Company> companies = new ArrayList<>(paymentCenter.getCompanies());
            List<OperationsArchive> operationsArchives = new ArrayList<>(paymentCenter.getOperationsArchives());
            List<Client> clients = new ArrayList<>(bank.getClients());
            List<Card> cards = new ArrayList<>(bank.getCards());
            out1.writeObject(banks);
            out1.writeObject(companies);
            out2.writeObject(operationsArchives);
            out1.writeObject(clients);
            out1.writeObject(cards);
            out1.close();
            out2.close();
            fileOut1.close();
            fileOut2.close();
            System.out.println("Zapisano stan systemu do plikow");
        } catch (IOException e) {
            System.err.println("Błąd podczas zapisywania stanu systemu: " + e.getMessage());
        }
    }

    public static void ReadFromFile(PaymentCenter paymentCenter,Bank bank, Company company, Client client) {
        try {
            FileInputStream fileIn1 = new FileInputStream("SystemData.txt");
            FileInputStream fileIn2 = new FileInputStream("OperationsArchive.txt");
            ObjectInputStream in1 = new ObjectInputStream(fileIn1);
            ObjectInputStream in2 = new ObjectInputStream(fileIn2);
            List<Bank> banks = (List<Bank>) in1.readObject();
            List<Company> companies = (List<Company>) in1.readObject();
            List<OperationsArchive> operationsArchives = (List<OperationsArchive>) in2.readObject();
            List<Client> clients = (List<Client>) in1.readObject();
            List<Card> cards = (List<Card>) in1.readObject();
            paymentCenter.setBanks(banks);
            paymentCenter.setCompanies(companies);
            paymentCenter.setOperationsArchives(operationsArchives);
            bank.setClients(clients);
            bank.setCards(cards);
            in1.close();
            in2.close();
            fileIn1.close();
            fileIn2.close();
            System.out.println("Odczytano stan systemu z plikow");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Błąd podczas odczytywania stanu systemu: " + e.getMessage());
        }
    }
}
