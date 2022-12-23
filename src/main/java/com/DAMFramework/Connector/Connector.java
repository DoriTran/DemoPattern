package com.DAMFramework.Connector;

import java.beans.IntrospectionException;
import java.sql.*;
import java.util.ArrayList;
import com.DAMFramework.Ulti.SqlUlti;
import com.DAMFramework.QueryBuilder.Action.AbleWhere;
import com.DAMFramework.QueryBuilder.Action.AbleQuery;
import com.DAMFramework.QueryBuilder.Implement.DeleteQuery;
import com.DAMFramework.QueryBuilder.Implement.InsertQuery;
import com.DAMFramework.QueryBuilder.Implement.SelectQuery;
import com.DAMFramework.QueryBuilder.Implement.UpdateQuery;
import com.DAMFramework.QueryBuilder.Query;

public abstract class Connector {
    // Connection information
    String url = "";
    String username = "";
    String password = "";

    // Connection
    public Connection connection = null;
    public ResultSet resultSet = null;

    public void Open() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void Close() {
        try {
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public <T> AbleWhere Select(Class<T> type) {
        return SelectQuery.create(this, type);
    }
    public <T> boolean Insert(Class<T> type, T obj) {
        InsertQuery insertQuery = new InsertQuery<T>(this, type, obj);
        return insertQuery.ExecuteNonQuery();
    }
    public <T> boolean Update(Class<T> type, T obj) {
        UpdateQuery updateQuery = new UpdateQuery<T>(this, type, obj);
        return updateQuery.ExecuteNonQuery();
    }
    public <T> boolean Delete(Class<T> type, T obj) {
        DeleteQuery deleteQuery = new DeleteQuery<T>(this, type, obj);
        return deleteQuery.ExecuteNonQuery();
    }

    public Object ExecuteQuery(Class<?> itemType, String query) throws SQLException, IllegalAccessException, IntrospectionException {
        PreparedStatement statement = connection.prepareStatement(query);
        this.resultSet = statement.executeQuery();
        ArrayList<Object> list = new ArrayList<>();
        var sqlMapper = new SqlUlti();
        while (this.resultSet.next()){
            var obj =   sqlMapper.MapWithRelationship(itemType,this, this.resultSet);
            list.add(obj);
        }
        AbleQuery newQuery = new Query(this);
        return list;
    }
    public Object ExecuteQueryWithOutRelationship(Class<?> itemType, String query) throws SQLException, IllegalAccessException {
        PreparedStatement statement = connection.prepareStatement(query);
        this.resultSet = statement.executeQuery();
        ArrayList<Object> list = new ArrayList<>();
        var sqlMapper = new SqlUlti();
        while (this.resultSet.next()){
            var obj =   sqlMapper.MapWithOutRelationship(itemType,this, this.resultSet);
            list.add(obj);
        }
        return list;
    }
    public boolean ExecuteNonQuery(String query) throws SQLException, IllegalAccessException {
        AbleQuery newQuery = new Query(this);
        return newQuery.ExecuteNonQuery();
    }
}
