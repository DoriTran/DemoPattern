package com.Model;

import com.DAMFramework.Annotation.*;

import java.util.ArrayList;

@Table(name = "Information")
public class Information {


    @PrimaryKey(name = "InforId",autoId = false)
    @ColumnInfo(type = DataType.VARCHAR, name = "InforId")
    public String InforId;

    @ColumnInfo(type = DataType.VARCHAR, name = "Lastname")
    public String Lastname;//  varchar(255),

    @ColumnInfo(type = DataType.VARCHAR, name = "Firstname")
    public String Firstname;// varchar(255),

    @ColumnInfo(type = DataType.VARCHAR, name = "Address")
    public String Address;//  varchar(255),


//    @ColumnInfo(name = "AccountId", type = DataType.INT)
//    public int AccountID;

    // một user - có 1 account: 1 - 1
    @OneToOne(relationshipId = "2", tableName = "Accounts")
    @ForeignKey(relationshipId = "2", name = "AccountID", references = "AccountID")
    public Account account;

    public Information(){}

    public Information(String personID, String lastname, String firstname, String address){
        this.InforId = personID;
        this.Lastname = lastname;
        this.Firstname = firstname;
        this.Address = address;
    }

    public Information(String personID, String lastname, String firstname, Account account) {
        this.InforId = personID;
        this.Lastname = lastname;
        this.Firstname = firstname;
        this.account = account;
//        this.AccountID = account.AccountID;
    }

    //override toString
    public String toString() {
        return InforId + " " + Lastname + " " + Firstname ;
    }

    public void display(){

        System.out.println(InforId + " " + Lastname + " " + Firstname +  " " + Address);
    }
}
