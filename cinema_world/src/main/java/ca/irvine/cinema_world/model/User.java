package ca.irvine.cinema_world.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    public int id;
    public String username;
    public String password;
    //public String email;
    //public String phoneNumber;
    //public boolean adminRight;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}