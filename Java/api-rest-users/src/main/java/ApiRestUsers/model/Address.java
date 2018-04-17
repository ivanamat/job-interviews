package apiRestUsers.model;
 
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Set;
import apiRestUsers.model.User;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String country;
	private String state;
	private String city;
	private String street;
	private String zip;

    @JsonIgnore
    @ManyToOne
	private User user;
	
    public Address(final User user, final String country, final String state, final String city, final String street, final String zip) {
        this.country = country;
        this.state = state;
        this.city = city;
        this.street = street;
        this.zip = zip;
        this.user = user;
    }

    public Long getId() {
        return id;
    }
    
    public String getCountry() {
        return country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
 
    public String getStreet() {
        return street;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
    
} 
