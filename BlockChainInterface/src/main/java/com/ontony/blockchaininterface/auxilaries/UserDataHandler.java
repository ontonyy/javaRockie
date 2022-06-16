package com.ontony.blockchaininterface.auxilaries;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ontony.blockchaininterface.blockchain.User;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class UserDataHandler {
    private static Map<String, User> users = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    public static User getUserByName(String name) throws IOException {
        setUsersFromFiles();
        return users.get(name);
    }

    public static List<User> getAllUsers() throws IOException {
        setUsersFromFiles();
        return users.values().stream().toList();
    }

    public static void setUsersFromFiles() throws IOException {
        File[] usersFiles = new File("users").listFiles();
        if (usersFiles != null && usersFiles.length > 0) {
            for (File file : usersFiles) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                Reader reader = Files.newBufferedReader(Paths.get(file.getPath()));
                User fileUser =  gson.fromJson(reader, User.class);
                users.put(fileUser.name, fileUser);
            }
        }
    }

    public static void updateUserFile(User user) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Writer writer = Files.newBufferedWriter(Paths.get("users/" + user.name.toLowerCase() + ".json"));
        gson.toJson(user, writer);
        writer.close();
    }
}
