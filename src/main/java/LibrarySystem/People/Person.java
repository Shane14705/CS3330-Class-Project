package LibrarySystem.People;

import java.io.Serializable;
import java.util.Date;
import LibrarySystem.util.SSN;

public class Person implements Serializable {
    private String name;
    private String address;
    private Date date_of_birth;
    private String email_address;
    private SSN ssn;


    /**
     * Get this person's name.
     * @return Name of person
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of this person.
     * @param name The new name this person should have
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get this person's address.
     * @return The address of this person
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set this person's address.
     * @param address The new address for this person
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get this person's birth date.
     * @return This person's date of birth
     */
    public Date getDateOfBirth() {
        return date_of_birth;
    }

    /**
     * Set this person's birth date.
     * @param date_of_birth The date to set this person's birth date to
     */
    public void setDateOfBirth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    /**
     * Get this person's email address.
     * @return This person's email address
     */
    public String getEmailAddress() {
        return email_address;
    }

    /**
     * Set this person's email address.
     * @param email_address The email address to set for this person
     */
    public void setEmailAddress(String email_address) {
        this.email_address = email_address;
    }

    /**
     * Get this person's SSN.
     * @return This person's SSN
     */
    public SSN getSSN() {
        return ssn;
    }

    /**
     * Set this person's SSN.
     * @param ssn The new validated SSN to use for this person
     */
    public void setSSN(SSN ssn) {
        this.ssn = ssn;
    }

    /**
     * Tries to validate and set this person's SSN to one passed in as a string.
     * @param ssn The SSN string to attempt to validate
     * @throws IllegalArgumentException If unable to validate that the passed in string is a valid SSN
     */
    public void setSSN(String ssn) throws IllegalArgumentException {
        this.ssn = new SSN(ssn);

    }

    /**
     * Gets this person.
     * @return this
     */
    public Person getPerson() {
        return this;
    }

    public Person(String name, String address, Date date_of_birth, String email_address, SSN ssn) {
        this.name = name;
        this.address = address;
        this.date_of_birth = date_of_birth;
        this.email_address = email_address;
        this.ssn = ssn;
    }
}
