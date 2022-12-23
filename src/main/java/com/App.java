package com;

import java.beans.IntrospectionException;
import java.sql.*;

import com.DAMFramework.Connector.ConnectorFactory.MySqlConnectorFactory;
import com.Model.Account;
import com.Model.User;
import com.Repository.AccountRepository;
import com.Repository.CreditCardRepository;
import com.Repository.Repository;
import com.Repository.UserRepository;
import com.DAMFramework.Ulti.SqlUlti;


public class App {
    static public void main(String[] args) {
            SqlUlti sqlMapper = new SqlUlti();
            MySqlConnectorFactory.provideConnectionInfo("jdbc:mysql://localhost:3306/simpledb", "root", "MySQL3082001");

            // [SELECT] GET ALL TABLES IN DATABASE
            Repository userRepository = new UserRepository();
            Object users = userRepository.SelectAll();

            Repository accountRepository = new AccountRepository();
            Object accounts = accountRepository.SelectAll();

            Repository creditCardRepository = new CreditCardRepository();
            Object creditCards = creditCardRepository.SelectAll();

            //[SELECT] get rows with where statement
            System.out.println(userRepository.SelectWhere("personID = '1'"));

            //[SELECT] get rows with where statement and group by statement
            System.out.println(userRepository.SelectWhereAndGroupBy("personId = '1'","personId"));

            //[SELECT] get rows with group by and having statement find the latest user
            System.out.println(userRepository.SelectGroupByAndHaving
                    ("PersonID","PersonID >= all ( select u2.PersonID from users u2)"));

            //[INSERT] Primary key auto increment - Add new user
            User insertedUser = new User("6","John","Stones");
            userRepository.Insert(insertedUser);

            //[INSERT] Primary key is not auto increment
            Account insertedAccount = new Account(5,"5");
            accountRepository.Insert(insertedAccount);

            //[UPDATE]
            User updatedUser= new User("5","John", "Cena", insertedAccount);
            userRepository.Update(updatedUser);

            //[DELETE] Account
            accountRepository.Delete(insertedAccount);

            //[DELETE] User
            User deleteUser = new User("6","John", "Stones");
            userRepository.Delete(deleteUser);

    }
}
