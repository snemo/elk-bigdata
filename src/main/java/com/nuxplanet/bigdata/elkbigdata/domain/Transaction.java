package com.nuxplanet.bigdata.elkbigdata.domain;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A Transaction.
 */
@Document(collection = "transaction")
@org.springframework.data.elasticsearch.annotations.Document(indexName = "transaction")
public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("transaction_date")
    @org.springframework.data.elasticsearch.annotations.Field(type = FieldType.Date)
    private ZonedDateTime transactionDate;

    @Field("product")
    private String product;

    @Field("price")
    @org.springframework.data.elasticsearch.annotations.Field(type = FieldType.Double)
    private BigDecimal price;

    @Field("payment_type")
    private String paymentType;

    @Field("customer_name")
    private String customerName;

    @Field("city")
    private String city;

    @Field("state")
    private String state;

    @Field("country")
    private String country;

    @Field("account_creation_date")
    @org.springframework.data.elasticsearch.annotations.Field(type = FieldType.Date)
    private ZonedDateTime accountCreationDate;

    @Field("last_login")
    @org.springframework.data.elasticsearch.annotations.Field(type = FieldType.Date)
    private ZonedDateTime lastLogin;

    @Field("latitude")
    @org.springframework.data.elasticsearch.annotations.Field(type = FieldType.Double)
    private Double latitude;

    @Field("longitude")
    @org.springframework.data.elasticsearch.annotations.Field(type = FieldType.Double)
    private Double longitude;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ZonedDateTime getTransactionDate() {
        return transactionDate;
    }

    public Transaction transactionDate(ZonedDateTime transactionDate) {
        this.transactionDate = transactionDate;
        return this;
    }

    public void setTransactionDate(ZonedDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getProduct() {
        return product;
    }

    public Transaction product(String product) {
        this.product = product;
        return this;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Transaction price(BigDecimal price) {
        this.price = price;
        return this;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public Transaction paymentType(String paymentType) {
        this.paymentType = paymentType;
        return this;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Transaction customerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCity() {
        return city;
    }

    public Transaction city(String city) {
        this.city = city;
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public Transaction state(String state) {
        this.state = state;
        return this;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public Transaction country(String country) {
        this.country = country;
        return this;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ZonedDateTime getAccountCreationDate() {
        return accountCreationDate;
    }

    public Transaction accountCreationDate(ZonedDateTime accountCreationDate) {
        this.accountCreationDate = accountCreationDate;
        return this;
    }

    public void setAccountCreationDate(ZonedDateTime accountCreationDate) {
        this.accountCreationDate = accountCreationDate;
    }

    public ZonedDateTime getLastLogin() {
        return lastLogin;
    }

    public Transaction lastLogin(ZonedDateTime lastLogin) {
        this.lastLogin = lastLogin;
        return this;
    }

    public void setLastLogin(ZonedDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Transaction latitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Transaction longitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Transaction transaction = (Transaction) o;
        if (transaction.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), transaction.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Transaction{" +
            "id=" + getId() +
            ", transactionDate='" + getTransactionDate() + "'" +
            ", product='" + getProduct() + "'" +
            ", price=" + getPrice() +
            ", paymentType='" + getPaymentType() + "'" +
            ", customerName='" + getCustomerName() + "'" +
            ", city='" + getCity() + "'" +
            ", state='" + getState() + "'" +
            ", country='" + getCountry() + "'" +
            ", accountCreationDate='" + getAccountCreationDate() + "'" +
            ", lastLogin='" + getLastLogin() + "'" +
            ", latitude=" + getLatitude() +
            ", longitude=" + getLongitude() +
            "}";
    }
}
