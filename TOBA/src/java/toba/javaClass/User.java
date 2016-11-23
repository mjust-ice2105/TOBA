package toba.javaClass;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author mpjustice
 * Matthew Justice
 * COP2806
 * 
 */

@Entity
public class User implements Serializable {
    
    // Variables
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String email;
    private String userName;
    private String password;
    
    
    // CONSTRUCTORS
    // No Arg constructor
    public User() {
        
        // No Arg assignment for Variables
        firstName = "";
        lastName = "";
        phone = "";
        address = "";
        city = "";
        state = "";
        zipCode = "";
        email = "";
        userName = "";
        password = "";
    }
    
    // Constructor for all Arg's
    public User(String firstName, String lastName, String phone, String address, 
            String city, String state, String zipCode, String email, String userName, 
            String password) {
        
        // Assign Variables the values that are passed to constructor
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.email = email;
        this.userName = userName;
        this.password = password;
        
    }
    
    
    // Create get and set methods for all Variables
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    
    
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    
    
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    
    
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    
    public String getUserName() {
        return userName;
    }
   public void setUserName(String userName) {
        this.userName = userName;
    } 
    
    public String getPassword() {
        return password;
    } 
    public void setPassword(String password) {
        this.password = password;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", firstName=" + firstName + ", lastName=" + 
                lastName + ", phone=" + phone + ", address=" + address + ", city=" + city + 
                ", state=" + state + ", zipCode=" + zipCode + ", email=" + email + ", userName=" + 
                userName + ", password=" + password + '}';
    }
    
}
