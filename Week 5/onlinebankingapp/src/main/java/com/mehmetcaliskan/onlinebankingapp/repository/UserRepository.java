package com.mehmetcaliskan.onlinebankingapp.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mehmetcaliskan.onlinebankingapp.entity.User;
import com.mehmetcaliskan.onlinebankingapp.util.LocalDateAdapter;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Repository
public class UserRepository {
    List<User> users;

    @PostConstruct
    private void init() throws FileNotFoundException {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();

        users = new LinkedList<>(Arrays.asList(gson.fromJson(new FileReader("src/main/resources/users.json"), User[].class)));
    }

    public User getUserByTcKimlikNo(String tcKimlikNo) {
        return users.stream()
                .filter(user -> user.getTcKimlikNo().equals(tcKimlikNo))
                .findFirst()
                .orElse(null);
    }

    public boolean save(User user) {
        users.stream()
                .filter(u -> u.getTcKimlikNo().equals(user.getTcKimlikNo()))
                .findFirst().ifPresent(user1 -> users.remove(user1));

        users.add(user);
        return updateFile();
    }

    private boolean updateFile() {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();

        try (FileWriter writer = new FileWriter("src/main/resources/users.json")) {
            gson.toJson(users, writer);
            writer.flush();
            return true;
        } catch (Exception e) {
            System.out.println("An error occurred while writing the users.json file.");
            e.printStackTrace();
            return false;
        }
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
        updateFile();
    }
}
