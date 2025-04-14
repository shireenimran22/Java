package com.btm.webapp.models;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.Date;

public class ClientDto
{
    @NotEmpty(message = "The First Name is required")
    private String firstName;

    @NotEmpty(message="The Last Name is required")
    private String lastName;

    @NotEmpty(message="The Email is required")
    @Email
    private String email;

    private String phone;
    private String address;
    private Date createdAt;

    @NotEmpty(message = "The status is required")
    private String state;

    public @NotEmpty(message = "The First Name is required") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotEmpty(message = "The First Name is required") String firstName) {
        this.firstName = firstName;
    }

    public @NotEmpty(message = "The Last Name is required") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotEmpty(message = "The Last Name is required") String lastName) {
        this.lastName = lastName;
    }

    public @NotEmpty(message = "The Email is required") @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotEmpty(message = "The Email is required") @Email String email) {
        this.email = email;
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

    public @NotEmpty(message = "The status is required") String getState() {
        return state;
    }

    public Date getCreatedAt() {
        return createdAt;
    }


    public void setState(@NotEmpty(message = "The status is required") String state) {
        this.state = state;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
