package com.github.ripmyskill.service;

import com.github.ripmyskill.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {

    private Map<String, User> users = new HashMap<>();
    private final ObjectMapper mapper;
    private final String FILE_PATH = "users.json";

    public UserService() {
        this.mapper = new ObjectMapper();
        this.mapper.registerModules(new JavaTimeModule());
        this.mapper.enable(SerializationFeature.INDENT_OUTPUT);

        loadUsersFromJson();
    }

    //회원가입
    public void signUp(String id, String pw, String name, String phone) {
        if(users.containsKey(id)) {
            System.err.println("이미 존재하는 아이디입니다.");
            return;
        }
        users.put(id, new User(id, pw, name, phone, false));
        saveUsersToJson();
        System.out.println("\n[회원가입 완료] " + name + "님, 환영합니다.");
    }

    //로그인
    public User login(String id, String pw) {
        User user = users.get(id);
        if (user != null && user.getPassword().equals(pw)) {
            return user;
        }
        return null;
    }

    public void saveUsersToJson() {
        try {
            mapper.writeValue(new File(FILE_PATH), users.values());
            System.out.println("[시스템] 사용자 정보가 users.json에 저장되었습니다.");
        } catch (IOException e) {
            System.err.println("[오류] 저장 실패" + e.getMessage());
        }
    }

    public void loadUsersFromJson() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            users.put("admin", new User("admin", "1234", "관리자", "010-0000-0000", true));
            users.put("test", new User("test","1234","테스트","010-1234-5678", false));
            return;
        }

        try {
            List<User> userList = mapper.readValue(file, new TypeReference<List<User>>() {});
            for (User user : userList) {
                users.put(user.getUserId(), user);
            }
            System.out.println("[시스템] 사용자 정보를 불러왔습니다.");
        } catch (IOException e) {
            System.err.println("[오류] 로딩 실패: " + e.getMessage());
        }
    }

    public User findUserById(String id) {
        return users.get(id);
    }
}
