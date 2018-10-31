
package com.dataflow.sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@JsonPropertyOrder({ "Id", "ContactDetailsNickName", "Address1", "Address2", "Address3", "City", "PostalCode", "Region",
        "Country", "Email", "FirstName", "LastName", "Gender", "Telephone", "PoBox", "MetadataItems" })
@DefaultCoder(SerializableCoder.class)
public class PaymentDetail implements Serializable {

    @JsonProperty("Id")
    private Integer id;
    @JsonProperty("ContactDetailsNickName")
    private String contactDetailsNickName;
    @JsonProperty("Address1")
    private String address1;
    @JsonProperty("Address2")
    private String address2;
    @JsonProperty("Address3")
    private String address3;
    @JsonProperty("City")
    private String city;
    @JsonProperty("PostalCode")
    private String postalCode;
    @JsonProperty("Region")
    private String region;
    @JsonProperty("Country")
    private String country;
    @JsonProperty("Email")
    private String email;
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("Gender")
    private Integer gender;
    @JsonProperty("Telephone")
    private String telephone;
    @JsonProperty("PoBox")
    private String poBox;
    @JsonProperty("MetadataItems")
    private List<MetadataItem> metadataItems = new ArrayList<MetadataItem>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 7418609063016625547L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public PaymentDetail() {
    }

    /**
     * 
     * @param region
     * @param lastName
     * @param contactDetailsNickName
     * @param address1
     * @param address2
     * @param address3
     * @param city
     * @param country
     * @param id
     * @param postalCode
     * @param metadataItems
     * @param email
     * @param poBox
     * @param gender
     * @param firstName
     * @param telephone
     */
    public PaymentDetail(Integer id, String contactDetailsNickName, String address1, String address2, String address3,
            String city, String postalCode, String region, String country, String email, String firstName,
            String lastName, Integer gender, String telephone, String poBox, List<MetadataItem> metadataItems) {
        super();
        this.id = id;
        this.contactDetailsNickName = contactDetailsNickName;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.city = city;
        this.postalCode = postalCode;
        this.region = region;
        this.country = country;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.telephone = telephone;
        this.poBox = poBox;
        this.metadataItems = metadataItems;
    }

    @JsonProperty("Id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("ContactDetailsNickName")
    public String getContactDetailsNickName() {
        return contactDetailsNickName;
    }

    @JsonProperty("ContactDetailsNickName")
    public void setContactDetailsNickName(String contactDetailsNickName) {
        this.contactDetailsNickName = contactDetailsNickName;
    }

    @JsonProperty("Address1")
    public String getAddress1() {
        return address1;
    }

    @JsonProperty("Address1")
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    @JsonProperty("Address2")
    public String getAddress2() {
        return address2;
    }

    @JsonProperty("Address2")
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @JsonProperty("Address3")
    public String getAddress3() {
        return address3;
    }

    @JsonProperty("Address3")
    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    @JsonProperty("City")
    public String getCity() {
        return city;
    }

    @JsonProperty("City")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("PostalCode")
    public String getPostalCode() {
        return postalCode;
    }

    @JsonProperty("PostalCode")
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @JsonProperty("Region")
    public String getRegion() {
        return region;
    }

    @JsonProperty("Region")
    public void setRegion(String region) {
        this.region = region;
    }

    @JsonProperty("Country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("Country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("Email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("Email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("FirstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("FirstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("LastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("LastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("Gender")
    public Integer getGender() {
        return gender;
    }

    @JsonProperty("Gender")
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @JsonProperty("Telephone")
    public String getTelephone() {
        return telephone;
    }

    @JsonProperty("Telephone")
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @JsonProperty("PoBox")
    public String getPoBox() {
        return poBox;
    }

    @JsonProperty("PoBox")
    public void setPoBox(String poBox) {
        this.poBox = poBox;
    }

    @JsonProperty("MetadataItems")
    public List<MetadataItem> getMetadataItems() {
        return metadataItems;
    }

    @JsonProperty("MetadataItems")
    public void setMetadataItems(List<MetadataItem> metadataItems) {
        this.metadataItems = metadataItems;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
