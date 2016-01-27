package pl.pwr;

import java.io.Serializable;

/**
 * Created by Alek on 12/13/2015.
 */
public class Model {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private double ccNumber;
    private String phone;
    private String dollars;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getCcNumber() {
        return ccNumber;
    }

    public void setCcNumber(double ccNumber) {
        this.ccNumber = ccNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDollars() {
        return dollars;
    }

    public void setDollars(String dollars) {
        this.dollars = dollars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Model model = (Model) o;

        if (id != model.id) return false;
        if (Double.compare(model.ccNumber, ccNumber) != 0) return false;
        if (!firstName.equals(model.firstName)) return false;
        if (!lastName.equals(model.lastName)) return false;
        if (!email.equals(model.email)) return false;
        if (!phone.equals(model.phone)) return false;
        return dollars.equals(model.dollars);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        temp = Double.doubleToLongBits(ccNumber);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public boolean hasValidEmail() {
        if(email.contains("@"))
            return email.split("@")[1].contains(".");
        return false;
    }
}
