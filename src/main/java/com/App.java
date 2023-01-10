package com;

import com.DAMFramework.Connector.ConnectorFactory.MySqlConnectorFactory;
import com.DAMFramework.Ulti.SqlUlti;
import com.Model.Account;
import com.Model.CreditCard;
import com.Model.Information;
import com.Repository.AccountRepository;
import com.Repository.CreditCardRepository;
import com.Repository.InformationRepository;
import com.Repository.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    static public void main(String[] args) {


        SqlUlti sqlMapper = new SqlUlti();
        MySqlConnectorFactory.provideConnectionInfo("jdbc:mysql://localhost:3306/simple_db", "root", "123456");
        Repository informationTable = new InformationRepository();
        Repository accountTable = new AccountRepository();
        Repository creditCardRepository = new CreditCardRepository();
        Boolean breakFlag = false;

        System.out.println("\n\n\n======  DEMO DAM FRAMEWORK  ======\n");

        while (true) {

            Scanner input = new Scanner(System.in);
            System.out.println("1. SELECT QUERY TABLE INFORMATION");
            System.out.println("2. SELECT QUERY TABLE ACCOUNT");
            System.out.println("3. SELECT QUERY TABLE CREDIT CARD");
            System.out.println("4. SELECT QUERY WITH WHERE STATEMENT IN TABLE INFORMATION");
            System.out.println("5. SELECT QUERY WITH GROUP BY AND HAVING: Get information of the lastest account");
            System.out.println("6. INSERT QUERY TABLE INFORMATION & ACCOUNT");
            System.out.println("7. UPDATE QUERY TABLE INFORMATION");
            System.out.println("8. DELETE QUERY TABLE INFORMATION & ACCOUNT");
            System.out.println("9. ANY KEY TO EXIT");
            System.out.print("\nEnter your choice: ");
            int choice = input.nextInt();


            switch (choice) {

                case 1: {


                    // [SELECT] GET ALL Information IN DATABASE
                    System.out.println("\n\n");
                    System.out.println("====== ALL RECORDS OF THE INFORMATION TABLE ======\n");
                    ArrayList<Information> listInfos = (ArrayList<Information>) informationTable.SelectAll();
                    System.out.println("\n");
                    for (Information infor : listInfos) {
                        infor.display();
                    }
                    System.out.println("\n\n");
                    break;
                }
                case 2: {

                    System.out.println("\n");
                    System.out.println("====== ALL RECORDS OF THE ACCOUNT TABLE ======\n");
                    ArrayList<Account> accounts = (ArrayList<Account>) accountTable.SelectAll();
                    System.out.println("\n");
                    for (Account account : accounts) {
                        account.display();
                    }
                    System.out.println("\n\n");
                    break;
                }

                case 3: {
                    System.out.println("\n");
                    System.out.println("====== ALL RECORDS OF THE CREDIT CARD TABLE ======\n");
                    ArrayList<CreditCard> creditCards = (ArrayList<CreditCard>) creditCardRepository.SelectAll();
                    System.out.println("\n");
                    for (CreditCard creditCard : creditCards) {
                        creditCard.display();
                    }
                    System.out.println("\n\n");
                    break;
                }

                case 4: {


                    System.out.println("\n\n");
                    System.out.println("====== SELECT WHERE IN THE INFORMATION TABLE ======\n");

                    //[SELECT] get rows with where statement
                    List<Information> selectWhereInfors = (List<Information>) informationTable.SelectWhere("InforId = '2'");

                    if (selectWhereInfors.size() == 0) {
                        System.out.println(" Don't have any row is exist with above InforId");
                    } else {
                        for (Information infor : selectWhereInfors) {
                            infor.display();
                        }
                    }
                    System.out.println("\n\n");
                    break;
                }

                case 5: {
                    System.out.println("====== INFOR OF THE LATEST ACCOUNT ======\n");
                    //[SELECT] get rows with group by and having statement find the latest user
                    List<Information> selectWhereInfors = (List<Information>)  informationTable.SelectGroupByAndHaving
                            ("InforId", "InforId >= all (select u2.InforId from information u2)");
                    for (Information infor : selectWhereInfors) {
                        infor.display();
                    }
                    System.out.println("\n\n");
                    break;
                }

                case 6: {

                    //[INSERT] Primary key auto increment - Add new user
                    var insertedUser = new Information("4", "Nguyen", "Binh", "227 Nguyen Van Cu");
                    informationTable.Insert(insertedUser);

                    //[INSERT] Primary key is not auto increment
                    Account insertedAccount = new Account("4", "4", "nguyenvananh@gmail.com", "xH213241@AFNAASFJBAF");
                    accountTable.Insert(insertedAccount);
                    System.out.println("NOTIFICATION: INSERT QUERY EXECUTED !!!");
                    System.out.println("\n\n");
                    break;
                }

                case 7: {
                    //[UPDATE] Information
                    var updatedUser = new Information("4", "Nguyen Thanh", "An", "123 Nguyen Tri Phuong");
                    informationTable.Update(updatedUser);


                    System.out.println("NOTIFICATION: UPDATE QUERY EXECUTED !!!\n");
                    System.out.println("\n\n");
                    break;
                }

                case 8: {

                    //[DELETE] Account
                    Account deleteAccount = new Account("4", "4", "nguyenvananh@gmail.com", "xH213241@AFNAASFJBAF");
                    accountTable.Delete(deleteAccount);


                    //[DELETE] Information
                    var deleteInformation = new Information("4", "Nguyễn", "Bình", "123 Nguyễn Tri Phương");
                    informationTable.Delete(deleteInformation);


                    System.out.println("NOTIFICATION: DELETE QUERY EXECUTED !!!\n");
                    System.out.println("\n\n");
                    break;
                }

                default: {
                    breakFlag = true;
                    break;
                }
            }

            if(breakFlag == true){
                break;
            }

        }
    }
}
