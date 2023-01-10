package com.Model;

import com.DAMFramework.Annotation.*;

@Table(name = "Accounts")
public class Account {

    //Primary key
    @PrimaryKey(name = "AccountID")
    @ColumnInfo(name = "AccountID", type = DataType.VARCHAR)
    public String AccountID;

    @ColumnInfo(name = "Email", type = DataType.VARCHAR)
    public String Email;

    @ColumnInfo(name = "HashedPassword", type = DataType.VARCHAR)
    public String HashedPassword;

    @ColumnInfo(name = "InforId", type = DataType.NCHAR)
    public String InforId;
    // ForeignKey
    @OneToOne(relationshipId = "1", tableName = "Information")
    @ForeignKey(relationshipId = "1", name = "InforId", references = "InforId")

    // 1 - 1
    public Information Information;

    public Account() {
    }

    public Account(String accountId, String InforId, String email, String pass) {
        this.AccountID = accountId;
        this.InforId = InforId;
        this.Email = email;
        this.HashedPassword = pass;
    }

    public void display() {

        System.out.println(AccountID + " " + InforId + "  " + Email + " " + HashedPassword);
    }

}