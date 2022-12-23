package com.DAMFramework.Connector.ConnectorFactory;

import com.DAMFramework.Connector.Connector;
import com.DAMFramework.Connector.MsSqlConnector;

public class MsSqlConnectorFactory extends ConnectorFactory {
    private MsSqlConnectorFactory() { }

    public static Connector createConnector() {
        return new MsSqlConnector(Url, Username, Password, Port, DatabaseName);
    }
}
