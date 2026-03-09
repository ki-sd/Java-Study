package com.github.ripmyskill;

import java.util.Scanner;

import com.github.ripmyskill.model.User;
import com.github.ripmyskill.service.HotelService;
import com.github.ripmyskill.service.UserService;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        HotelService hotel = new HotelService();
        UserService userService = new UserService();
        User currentUser = null; // 현재 로그인한 사용자 정보
        boolean isRunning = true;

        while (isRunning) {
            if (currentUser == null) {
                // [1단계: 로그인 전]
                System.out.println("\n--- 호텔 예약 시스템 ---");
                System.out.println("1. 로그인  2. 회원가입  3. 시스템 종료");
                int choice = getUserInput("선택: ");

                if (choice == -1) continue;
                switch (choice) {
                    case 1 -> {
                        System.out.print("아이디: "); String id = sc.nextLine();
                        System.out.print("비밀번호: "); String pw = sc.nextLine();
                        currentUser = userService.login(id, pw);
                        if (currentUser == null) System.err.println("잘못된 아이디 혹은 비밀번호 입니다.");
                    }
                    case 2 -> {
                        System.out.print("아이디를 입력해주세요:"); String id = sc.nextLine();
                        System.out.print("비밀번호를 입력해주세요:"); String pw = sc.nextLine();
                        System.out.print("성함을 입력해주세요:"); String name = sc.nextLine();
                        System.out.print("핸드폰 번호를 입력해주세요:"); String phone = sc.nextLine();
                    }
                    case 3 -> {
                        System.out.println("시스템을 종료합니다.");
                        isRunning = false;
                    }
                    default -> System.err.println("잘못된 입력입니다!");
                }
            } else {
                // [2단계: 로그인 후]
                System.out.println("\n--- " + currentUser.getName() + "님 환영합니다 ---");
                System.out.println("1. 객실 목록  2. 객실 예약  3. 내 예약 정보  4. 로그아웃");
                int choice = getUserInput("선택: ");

                switch (choice) {
                    case 1 -> hotel.showRoomGrid();
                    case 2 -> System.out.println("예약 메뉴 구현 예정");
                    case 3 -> System.out.println("예약 관리 메뉴 구현 예정");
                    case 4 -> {
                        currentUser = null;
                        System.out.println("로그아웃 되었습니다.");
                    }
                    default -> System.err.println("잘못된 입력입니다!");
                }
            }
        }
    }

    // 입력 및 오류 예외처리
    private static int getUserInput(String prompt) {
        System.out.print(prompt);
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("[오류] 숫자만 입력 가능합니다.");
            return -1; // 잘못된 입력임을 나타내는 값
        }
    }
}
