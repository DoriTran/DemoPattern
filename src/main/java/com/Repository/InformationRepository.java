package com.Repository;

import com.DAMFramework.Connector.Connector;
import com.DAMFramework.Connector.ConnectorFactory.MySqlConnectorFactory;
import com.DAMFramework.QueryBuilder.Implement.SelectQuery;
import com.Model.Information;


public class InformationRepository implements Repository {
    public Object SelectAll() {
        Connector connector = MySqlConnectorFactory.createConnector();
        connector.Open();
        Object result =  SelectQuery.create(connector, Information.class).allRows().run(Information.class);
        connector.Close();
        return result;
    }

    @Override
    public Object SelectWhere(String whereClause) {
        Connector connector = MySqlConnectorFactory.createConnector();
        connector.Open();
        Object result = SelectQuery.create(connector, Information.class).where(whereClause).run(Information.class);
        connector.Close();
        return result;
    }

    @Override
    public Object SelectWhereAndGroupBy(String where, String groupBy) {
        Connector connector = MySqlConnectorFactory.createConnector();
        connector.Open();
        Object result =  SelectQuery.create(connector, Information.class).where(where).groupBy(groupBy).run(Information.class);
        connector.Close();
        return result;
    }

    @Override
    public Object SelectGroupByAndHaving(String groupBy, String having) {
        Connector connector = MySqlConnectorFactory.createConnector();
        connector.Open();
        Object result = SelectQuery.create(connector, Information.class).groupBy(groupBy).having(having).run(Information.class);
        connector.Close();
        return result;
    }
    @Override
    public void Insert(Object newUser) {
        Connector connector = MySqlConnectorFactory.createConnector();
        connector.Open();
        connector.Insert(Information.class,(Information) newUser);
        connector.Close();
    }
    @Override
    public void Update(Object updatedUser) {
        Connector connector = MySqlConnectorFactory.createConnector();
        connector.Open();
        connector.Update(Information.class, (Information) updatedUser);
        connector.Close();
    }
    @Override
    public void Delete(Object deletedUser) {
        Connector connector = MySqlConnectorFactory.createConnector();
        connector.Open();
        connector.Delete(Information.class, (Information)deletedUser);
        connector.Close();
    }
}
