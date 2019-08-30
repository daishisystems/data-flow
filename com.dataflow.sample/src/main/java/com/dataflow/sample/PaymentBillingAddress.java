
package com.dataflow.sample;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "firstName", "lastName", "fullName", "addressLine1", "addressLine2", "addressLine3", "city",
        "region", "postalCode", "countryIso", "phone", "email" })
public class PaymentBillingAddress implements Serializable {

    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("fullName")
    private String fullName;
    @JsonProperty("addressLine1")
    private String addressLine1;
    @JsonProperty("addressLine2")
    private String addressLine2;
    @JsonProperty("addressLine3")
    private String addressLine3;
    @JsonProperty("city")
    private String city;
    @JsonProperty("region")
    private String region;
    @JsonProperty("postalCode")
    private String postalCode;
    @JsonProperty("countryIso")
    private String countryIso;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("email")
    private String email;
    private final static long serialVersionUID = -7338787486574850406L;

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("fullName")
    public String getFullName() {
        return fullName;
    }

    @JsonProperty("fullName")
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @JsonProperty("addressLine1")
    public String getAddressLine1() {
        return addressLine1;
    }

    @JsonProperty("addressLine1")
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    @JsonProperty("addressLine2")
    public String getAddressLine2() {
        return addressLine2;
    }

    @JsonProperty("addressLine2")
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    @JsonProperty("addressLine3")
    public String getAddressLine3() {
        return addressLine3;
    }

    @JsonProperty("addressLine3")
    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    @JsonProperty("postalCode")
    public String getPostalCode() {
        return postalCode;
    }

    @JsonProperty("postalCode")
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @JsonProperty("countryIso")
    public String getCountryIso() {
        return countryIso;
    }

    @JsonProperty("countryIso")
    public void setCountryIso(String countryIso) {
        this.countryIso = countryIso;
    }

    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("firstName", firstName).append("lastName", lastName)
                .append("fullName", fullName).append("addressLine1", addressLine1).append("addressLine2", addressLine2)
                .append("addressLine3", addressLine3).append("city", city).append("region", region)
                .append("postalCode", postalCode).append("countryIso", countryIso).append("phone", phone)
                .append("email", email).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(region).append(lastName).append(phone).append(addressLine3)
                .append(addressLine2).append(addressLine1).append(city).append(postalCode).append(email)
                .append(countryIso).append(fullName).append(firstName).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PaymentBillingAddress) == false) {
            return false;
        }
        PaymentBillingAddress rhs = ((PaymentBillingAddress) other);
        return new EqualsBuilder().append(region, rhs.region).append(lastName, rhs.lastName).append(phone, rhs.phone)
                .append(addressLine3, rhs.addressLine3).append(addressLine2, rhs.addressLine2)
                .append(addressLine1, rhs.addressLine1).append(city, rhs.city).append(postalCode, rhs.postalCode)
                .append(email, rhs.email).append(countryIso, rhs.countryIso).append(fullName, rhs.fullName)
                .append(firstName, rhs.firstName).isEquals();
    }

}
