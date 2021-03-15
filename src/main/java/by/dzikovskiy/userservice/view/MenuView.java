package by.dzikovskiy.userservice.view;

import by.dzikovskiy.userservice.entity.BasicUser;
import by.dzikovskiy.userservice.repository.BasicUserRepository;

import java.util.List;
import java.util.Scanner;

public class MenuView {
    private final BasicUserView userView;
    private final BasicUserRepository basicUserRepository;
    private final Scanner scanner;
    private List<BasicUser> users;

    public MenuView() {
        this.scanner = new Scanner(System.in);
        this.basicUserRepository = new BasicUserRepository();
        this.userView = new BasicUserView();
        this.users = basicUserRepository.getAll();
    }

    public void menu() {
        while (true) {
            System.out.println("1. Print all users");
            System.out.println("2. Add user");
            System.out.println("3. Delete user");
            System.out.println("4. Edit user");
            System.out.println("5. Exit");

            switch (scanner.nextInt()) {
                case 1:
                    users = basicUserRepository.getAll();
                    userView.printUsers(users);
                    break;
                case 2:
                    basicUserRepository.save(userView.addUser());
                    break;
                case 3:
                    userView.deleteUser();
                    break;
//                case 4:
//                    book = booksView.addBook();
//                    repository.delete(book);
                case 5:
                    return;
                default:
                    System.out.println("Wrong command");
                    break;
            }
        }
    }
}
