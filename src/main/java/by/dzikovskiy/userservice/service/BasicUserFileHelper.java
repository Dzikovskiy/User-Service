package by.dzikovskiy.userservice.service;

import by.dzikovskiy.userservice.entity.BasicUser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BasicUserFileHelper {
    private final String fileName;

    public BasicUserFileHelper(String fileName) {
        this.fileName = fileName;
    }

    public void writeBasicUsersListToFile(List<BasicUser> users) {
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

            objectOut.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<BasicUser> readBasicUsersListFromFile() {
        List<BasicUser> users = new ArrayList<>();
        File f = new File(fileName);

        if(f.exists()){
            try (FileInputStream fileIn = new FileInputStream(fileName); ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
                users = (List<BasicUser>) objectIn.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        }else{
            System.out.println("File not exists");
        }

        return users;
    }
}
