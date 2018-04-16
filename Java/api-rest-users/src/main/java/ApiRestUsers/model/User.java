package apiRestUsers.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;
import java.util.Date;

@Entity
public class User {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @OneToMany(mappedBy = "user")
    private Set<Address> address = new HashSet<Address>();
 
    private String name;
    private String email;
    private String password;
    private String birthDate;
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getBirthDate() {
        return birthDate;
    }
 
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    
    public Set<Address> getAddress() {
        return address;
    }
    
} 
