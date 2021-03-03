package com.company.data;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDB {
    Connection getconnection() throws SQLException, ClassNotFoundException;
}
