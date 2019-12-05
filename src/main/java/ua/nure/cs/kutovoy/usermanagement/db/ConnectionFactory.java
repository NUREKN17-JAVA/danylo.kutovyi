package ua.nure.cs.kutovoy.usermanagement.domain.db;

import java.sql.Connection;

public interface ConnectionFactory {
	Connection createConnection() throws DatabaseException;
}
