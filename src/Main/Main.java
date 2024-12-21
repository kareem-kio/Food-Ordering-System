package Main;

import Accounts.AccountsManager;
import Accounts.User;
import FileManagement.FileManager;
import PaymentSystem.Payment;
import PaymentSystem.PaymentGateway;
import PaymentSystem.PaymentsManager;



import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        FileManager.readAllJSON();

        User user1 = new User("Ahmed","Nigger","IHateISIS","nigga@gmail.com","+201552715358","nigga land");
        AccountsManager.AddUser(user1);
        User user2 = new User("Khayat", "SheikhWalter", "niggaballs", "abdulrahman.elkhayat101@gmail.com", "+201147562225", "Cairo");
        AccountsManager.AddUser(user2);
        User user3 = new User("Azad","shialover","IloveJava","balls@gmail.com","+201552715358","Tahran");
        AccountsManager.AddUser(user3);

//        Order p1 = new Order();
//        Order p2 = new Order();
//        Order p3 = new Order();
//        Order p4 = new Order();
//        Order p5 = new Order();
//
//        p1.Checkout(d1);
//
//        p2.Checkout(d2);
//        p2.Refund(p2.getPayment());
//
//        p3.Checkout(d2);
//
//        p4.Checkout(d1);
//        p4.Refund(p4.getPayment());
//
//        p5.Checkout(d2);
//
//        System.out.println("---------------------------------");
//        for(Payment p: PaymentsManager.ReturnPayments()){
//            p.DisplayPaymentInfo();
//        }

        FileManager.writeAllJSON();
    }
}