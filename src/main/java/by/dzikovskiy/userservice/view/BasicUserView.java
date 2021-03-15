package by.dzikovskiy.userservice.view;

import by.dzikovskiy.userservice.entity.BasicUser;
import by.dzikovskiy.userservice.entity.UserEnum;
import by.dzikovskiy.userservice.service.UserEmailValidator;
import by.dzikovskiy.userservice.service.UserPhoneNumberValidator;
import by.dzikovskiy.userservice.service.UserRolesValidator;

import java.util.EnumSet;
import java.util.List;
import java.util.Scanner;

public class BasicUserView {
    private final Scanner scanner;

    public BasicUserView() {
        this.scanner = new Scanner(System.in);
    }

    public void printUsers(List<BasicUser> users) {
        if (users != null) {
            users.forEach(System.out::println);
        }
    }

    public BasicUser addUser() {
        BasicUser basicUser = new BasicUser();

        System.out.println("\nEnter user name:");
        basicUser.setName(scanner.nextLine());
        System.out.println("\nEnter user surname:");
        basicUser.setSurname(scanner.nextLine());
        System.out.println("\nEnter amount of phones you want to add(not more than 3):");
        int amount = scanner.nextInt();
        while (amount == 0 || amount > 3) {
            System.out.println("\nWrong input!");
            System.out.println("\nEnter amount of phones you want to add(not more than 3):");
            amount = scanner.nextInt();
        }
        scanner.nextLine();
        for (int i = 0; i < amount; i++) {
            System.out.println("\nEnter phone number:");
            String phoneNumber = scanner.nextLine();
            while (!UserPhoneNumberValidator.validateBelarusianNumber(phoneNumber)) {
                System.out.println("\nWrong number format");
                System.out.println("\nEnter phone number:");
                phoneNumber = scanner.nextLine();
            }
            basicUser.addPhoneNumber(phoneNumber);
        }

        System.out.println("\nEnter email: ");
        String email = scanner.nextLine();
        while (!UserEmailValidator.validateEmail(email)) {
            System.out.println("\nWrong email format!");
            System.out.println("\nEnter email:");
            email = scanner.nextLine();
        }
        basicUser.setEmail(email);

        System.out.println("\n");
        for (UserEnum userEnum : EnumSet.allOf(UserEnum.class)) {
            System.out.println("Level: " + userEnum.getLevel() + " name: " + userEnum);
        }
        System.out.println("\nEnter the name of role for user or separated by white space if more than one(not more than one from each level and one for super_admin):");

        String[] rolesString = scanner.nextLine().split(" ");
        EnumSet<UserEnum> userRoles = EnumSet.noneOf(UserEnum.class);
        for (String role : rolesString) {
            userRoles.add(UserEnum.valueOf(role.toUpperCase()));
        }

        while (!UserRolesValidator.validateIsCorrectNumberOfRoles(userRoles)) {
            System.out.println("\nWrong combination of roles!");
            System.out.println("\nEnter the name of role for user or separated by white space if more than one(not more than one from each level and one for super_admin):");
            rolesString = scanner.nextLine().split(" ");
            userRoles = EnumSet.noneOf(UserEnum.class);
            for (String role : rolesString) {
                userRoles.add(UserEnum.valueOf(role.toUpperCase()));
            }
        }
        for (UserEnum role : userRoles) {
            basicUser.addRole(role);
        }

        System.out.println("User added successfully");
        return basicUser;
    }
}
