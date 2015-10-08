package by.WebProject.TestTask.database.dao.userDAO;

import by.WebProject.TestTask.models.User;
import org.apache.log4j.Logger;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * part of DAO pattern - implementation
 *
 * @author Andrei Liashevich
 */
public class UserDAOImpl extends UserDAO {

    Logger logger = Logger.getLogger(UserDAOImpl.class.getName());

    private int noOfRecords;

    public int getNoOfRecords(){
        return noOfRecords;
    }

    @Override
    public int addUsers(ArrayList<User> users) {

        Connection connection = null;
        PreparedStatement statement =null;

        try{
            connection = connectionPool.takeConnection();

            for(int i = 0; i < users.size();i++) {

                statement = connection.prepareStatement(
                        "INSERT INTO user (idUser, name, surname, login, eMail, phoneNumber) VALUES (NULL ,?,?,?,?,? )",Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, users.get(i).getName());
                statement.setString(2, users.get(i).getSurname());
                statement.setString(3, users.get(i).getLogin());
                statement.setString(4, users.get(i).geteMail());
                statement.setString(5, users.get(i).getPhoneNumber());

                statement.executeUpdate();
            }
        }catch (SQLException e){
            logger.error("SQL exception in addUsers() to database");
        }finally {
            connectionPool.closeConnection(connection,statement);
        }
        return users.size();
    }

    @Override
    public List<User> getUsers(int offset,int noOfRecords,String sortType, boolean reverseSort) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        List<User> userList = new ArrayList<>();
        String query = null;

        switch (sortType){
            case "sortByName":
                if(!reverseSort) query = "SELECT SQL_CALC_FOUND_ROWS * FROM user ORDER BY user.name LIMIT "+offset+", "+noOfRecords+"";
                else query = "SELECT SQL_CALC_FOUND_ROWS * FROM user ORDER BY  user.name DESC LIMIT "+offset+", "+noOfRecords+"";
                break;
            case "sortByLogin":
                if(!reverseSort) query = "SELECT SQL_CALC_FOUND_ROWS * FROM user ORDER BY user.login LIMIT "+offset+", "+noOfRecords+"";
                else query = "SELECT SQL_CALC_FOUND_ROWS * FROM user ORDER BY  user.login DESC LIMIT "+offset+", "+noOfRecords+"";
                break;
            case "sortBySurname":
                if(!reverseSort) query = "SELECT SQL_CALC_FOUND_ROWS * FROM user ORDER BY user.surname LIMIT "+offset+", "+noOfRecords+"";
                else query = "SELECT SQL_CALC_FOUND_ROWS * FROM user ORDER BY  user.surname DESC LIMIT "+offset+", "+noOfRecords+"";
                break;
            case "sortByEmail":
                if(!reverseSort) query = "SELECT SQL_CALC_FOUND_ROWS * FROM user ORDER BY user.eMail LIMIT "+offset+", "+noOfRecords+"";
                else query = "SELECT SQL_CALC_FOUND_ROWS * FROM user ORDER BY  user.eMail DESC LIMIT "+offset+", "+noOfRecords+"";
                break;
            case "sortByPhoneNumber":
                if(!reverseSort) query = "SELECT SQL_CALC_FOUND_ROWS * FROM user ORDER BY user.phoneNumber LIMIT "+offset+", "+noOfRecords+"";
                else query = "SELECT SQL_CALC_FOUND_ROWS * FROM user ORDER BY  user.phoneNumber DESC LIMIT "+offset+", "+noOfRecords+"";
                break;
        }

        User user = null;
        try{
            connection = connectionPool.takeConnection();
            statement = connection.createStatement();
            resultSet=statement.executeQuery(query);
            while(resultSet.next()){
                user=new User();

                user.setIdUser(Integer.parseInt(resultSet.getString(1)));
                user.setName(resultSet.getString(2));
                user.setSurname(resultSet.getString(3));
                user.setLogin(resultSet.getString(4));
                user.seteMail(resultSet.getString(5));
                user.setPhoneNumber(resultSet.getString(6));
                userList.add(user);
            }
            resultSet.close();
            resultSet=statement.executeQuery("SELECT found_rows()");
            if(resultSet.next()){
                this.noOfRecords=resultSet.getInt(1);
            }
        } catch (SQLException e){

            logger.error("SQL exception in getUsers() from database");

        }finally {
            connectionPool.closeConnection(connection,statement,resultSet);
        }
        return userList;
    }
}
