package com.Model;

import com.DAMFramework.Annotation.*;

@Table(name = "CreditCards")
public class CreditCard {


    @PrimaryKey(name = "CreditCardID")
    @ColumnInfo(name = "CreditCardID")
    public String CreditCardID;

    @ColumnInfo(name = "AccountID")
    public String accountID;

    @ColumnInfo(name="NumberCard",type = DataType.VARCHAR)
    public String NumberCard;

    @ForeignKey(relationshipId = "1", name = "AccountID", references = "AccountID")
    @ManyToOne(relationshipId = "1", tableName = "Accounts")
    public Account account;


    public void display(){

        System.out.println(CreditCardID + " " + accountID + " " + NumberCard);
    }
}