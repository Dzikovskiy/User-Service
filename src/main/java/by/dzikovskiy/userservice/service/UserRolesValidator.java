package by.dzikovskiy.userservice.service;

import by.dzikovskiy.userservice.entity.UserEnum;

import java.util.Set;

public class UserRolesValidator {

    public static boolean validateIsCorrectNumberOfRoles(Set<UserEnum> roles) {
        if (roles.size() == 1) {
            return true;
        }
        if (roles.size() > 2) {
            return false;
        }
        int level = 0;
        for (UserEnum role : roles) {
            if (role.getLevel() == 3) {
                return false;
            }
            if (role.getLevel() == level) {
                return false;
            }
            level = role.getLevel();
        }
        return true;
    }
}
