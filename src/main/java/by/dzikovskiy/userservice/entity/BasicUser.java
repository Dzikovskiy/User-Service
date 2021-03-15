package by.dzikovskiy.userservice.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class BasicUser implements Serializable {
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

    public Set<UserEnum> getRoles() {
        return roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BasicUser)) return false;

        BasicUser basicUser = (BasicUser) o;

        if (!name.equals(basicUser.name)) return false;
        if (!surname.equals(basicUser.surname)) return false;
        if (!email.equals(basicUser.email)) return false;
        if (!phoneNumbers.equals(basicUser.phoneNumbers)) return false;
        return roles.equals(basicUser.roles);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + phoneNumbers.hashCode();
        result = 31 * result + roles.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "BasicUser{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                ", roles=" + roles +
                '}';
    }
}
