package com.DAMFramework.Ulti;

import com.DAMFramework.Connector.Connector;

import java.beans.IntrospectionException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlUlti extends Ulti {
    public SqlUlti(){
        this.converter = new SqlConverter();
    }

    @Override
    protected <T> void MapOneToMany(Class<T> type, Connector cnn, ResultSet dr, T obj)
            throws SQLException, IllegalAccessException, IntrospectionException {
         this.converter.MapOneToMany(type,cnn,dr,obj,this);
    }

    @Override
    protected <T> void MapToOne(Class<T> type, Connector cnn, ResultSet dr, T obj)
            throws SQLException, IllegalAccessException {
        this.converter.MapToOne(type,cnn,dr,obj,this);

    }
}
