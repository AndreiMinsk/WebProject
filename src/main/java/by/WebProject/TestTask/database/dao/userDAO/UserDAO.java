package by.WebProject.TestTask.database.dao.userDAO;

import by.WebProject.TestTask.database.dao.DAO;
import by.WebProject.TestTask.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * part of DAO pattern
 *
 * @author Andrei Liashevich
 */
public abstract class UserDAO extends DAO {

    abstract public int addUsers(ArrayList<User> users);//add list
    abstract public List<User> getUsers(int offset,int noOfRecords,String sortType, boolean reverseSort);//get list
    abstract public int getNoOfRecords();
}
