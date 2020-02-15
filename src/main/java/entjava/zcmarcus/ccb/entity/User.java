package entjava.zcmarcus.ccb.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Date;

/**
 * The type User.
 */
@Entity(name = "User")
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator =  "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "user_name", unique = true)
    private String userName;

    @Column(name = "password")
    private String passWord;

    @Column(name = "email")
    private String email;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "creation_date")
    private Date creationDate;

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param userName      the user name
     * @param passWord      the pass word
     * @param email         the email
     * @param lastName      the last name
     * @param firstName     the first name
     * @param creationDate the creation date
     */
    public User(String userName, String passWord, String email,
                String lastName, String firstName, Date creationDate) {

        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
        this.creationDate = creationDate;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets pass word.
     *
     * @return the pass word
     */
    public String getPassWord() {
        return passWord;
    }

    /**
     * Sets pass word.
     *
     * @param passWord the pass word
     */
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets creation date.
     *
     * @return the creation date
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Sets creation date.
     *
     * @param creationDate the creation date
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", user_name='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", last_name='" + userName + '\'' +
                ", first_name='" + userName + '\'' +
                ", creation_date='" + creationDate + '\'' +
                "}";

    }
}
