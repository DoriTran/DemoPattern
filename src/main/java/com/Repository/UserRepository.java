package com.Repository;

import com.DAMFramework.Connector.Connector;
import com.DAMFramework.Connector.ConnectorFactory.MySqlConnectorFactory;
import com.Model.User;
import com.DAMFramework.QueryBuilder.Implement.SelectQuery;

public class UserRepository implements Repository {
    public Object SelectAll() {
        Connector connector = MySqlConnectorFactory.createConnector();
        connector.Open();
        Object result =  SelectQuery.create(connector, User.class).allRows().run(User.class);
        connector.Close();
        return result;
    }

    @Override
    public Object SelectWhere(String whereClause) {
        Connector connector = MySqlConnectorFactory.createConnector();
        connector.Open();
        Object result = SelectQuery.create(connector, User.class).where(whereClause).run(User.class);
        connector.Close();
        return result;
    }

    @Override
    public Object SelectWhereAndGroupBy(String where, String groupBy) {
        Connector connector = MySqlConnectorFactory.createConnector();
        connector.Open();
        Object result =  SelectQuery.create(connector, User.class).where(where).groupBy(groupBy).run(User.class);
        connector.Close();
        return result;
    }

    @Override
    public Object SelectGroupByAndHaving(String groupBy, String having) {
        Connector connector = MySqlConnectorFactory.createConnector();
        connector.Open();
        Object result = SelectQuery.create(connector, User.class).groupBy(groupBy).having(having).run(User.class);
        connector.Close();
        return result;
    }
    @Override
    public void Insert(Object newUser) {
        Connector connector = MySqlConnectorFactory.createConnector();
        connector.Open();
        connector.Insert(User.class,(User) newUser);
        connector.Close();
    }
    @Override
    public void Update(Object updatedUser) {
        Connector connector = MySqlConnectorFactory.createConnector();
        connector.Open();
        connector.Update(User.class, (User) updatedUser);
        connector.Close();
    }
    @Override
    public void Delete(Object deletedUser) {
        Connector connector = MySqlConnectorFactory.createConnector();
        connector.Open();
        connector.Delete(User.class, (User)deletedUser);
        connector.Close();
    }
}
