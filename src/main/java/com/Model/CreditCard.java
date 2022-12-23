package com.Model;

import com.DAMFramework.Annotation.*;

@Table(name = "creditcards")
public class CreditCard {
    @PrimaryKey(name = "CreditCardID")
    @ColumnInfo(name = "CreditCardID")
    public String CreditCardID;

    @ColumnInfo(name = "PersonID")
    public String PersonID;

    @ForeignKey(relationshipId = "1", name = "PersonID", references = "PersonID")
    @ManyToOne(relationshipId = "1", tableName = "users")
    public User user;
}