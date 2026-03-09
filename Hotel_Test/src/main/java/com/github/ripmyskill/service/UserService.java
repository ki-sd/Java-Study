package com.github.ripmyskill.service;

import com.github.ripmyskill.model.User;
import java.util.HashMap;
import java.util.Map;

public class UserService {

    private Map<String, User> users = new HashMap<>();

    public UserService() {
        users.put("admin", new User("admin","1234","관리자","010-0000-0000"));
        users.put("test", new User("test","1234","테스트","010-1234-5678"));
    }

    public void signUp(String id, String pw, String name, String phone) {
        if(users.containsKey(id)) {
            System.err.println("이미 존재하는 아이디입니다.");
            return;
        }
        users.put(id, new User(id, pw, name, phone));
        System.out.println("\n[회원가입 완료] " + name + "님, 환영합니다.");
    }

    public User login(String id, String pw) {
        User user = users.get(id);
        if (user != null && user.getPassword().equals(pw)) {
            return user;
        }
        return null;
    }
}
