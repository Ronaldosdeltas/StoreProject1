package com.CRUD2.StoreProject1.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class ClientDto {
    @NotEmpty(message = "The First Name is required.")
    private String FirstName;

    @NotEmpty(message = "The Last Name is required.")
    private String LastName;

    @NotEmpty(message = "The Last Name is required.")
    @Email
    private String email;

    private String phone;
    private String address;

    public @NotEmpty(message = "The First Name is required.") String getFirstName() {
        return FirstName;
    }

    public void setFirstName(@NotEmpty(message = "The First Name is required.") String firstName) {
        FirstName = firstName;
    }

    public @NotEmpty(message = "The Last Name is required.") String getLastName() {
        return LastName;
    }

    public void setLastName(@NotEmpty(message = "The Last Name is required.") String lastName) {
        LastName = lastName;
    }

    public @NotEmpty(message = "The Last Name is required.") @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotEmpty(message = "The Last Name is required.") @Email String email) {
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
}
