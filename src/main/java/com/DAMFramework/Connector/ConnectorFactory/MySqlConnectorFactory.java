package com.DAMFramework.Connector.ConnectorFactory;

import com.DAMFramework.Connector.Connector;
import com.DAMFramework.Connector.MySqlConnector;

public class MySqlConnectorFactory extends ConnectorFactory {
    private MySqlConnectorFactory() { }

    public static Connector createConnector() {
        return new MySqlConnector(Url, Username, Password);
    }
}
