package by.WebProject.TestTask.database.dao;

import by.WebProject.TestTask.database.connetion.ConnectionPool;


/**
 * part of DAO pattern
 *
 * @author Andrei Liashevich
 */
public abstract class DAO {

    protected ConnectionPool connectionPool = ConnectionPool.getInstance();
}
