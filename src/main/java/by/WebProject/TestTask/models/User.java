package by.WebProject.TestTask.models;

/**
 * part of mvc pattern as model
 *
 * @author Andrei Liashevich
 */
public class User {

    private  static final long serialVersionUID=1L;

    private int idUser;
    private String name;
    private String surname;
    private String login;
    private String eMail;
    private String phoneNumber;


    public User(){}

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return super.toString() + name + " "+surname+" "+login+" "+eMail+" "+phoneNumber + "\n";
    }
}
