package by.dzikovskiy.userservice.entity;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class BasicUser {
    private String name;
    private String surname;
    private String email;
    private final List<String> phoneNumbers;
    private final EnumSet<UserEnum> roles;

    public BasicUser() {
        this.phoneNumbers = new ArrayList<>(3);
        this.roles = EnumSet.noneOf(UserEnum.class);
    }

    public void addRole(UserEnum role) {
        this.roles.add(role);
    }

    public void deleteRole(UserEnum role) {
        this.roles.remove(role);
    }

    public void addPhoneNumber(String number) {
        this.phoneNumbers.add(number);
    }

    public void deletePhoneNumber(String number) {
        this.phoneNumbers.remove(number);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public EnumSet<UserEnum> getRoles() {
        return roles;
    }
}
