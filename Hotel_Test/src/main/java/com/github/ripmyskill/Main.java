package com.github.ripmyskill;

import java.util.Scanner;

import com.github.ripmyskill.model.User;
import com.github.ripmyskill.service.HotelService;
import com.github.ripmyskill.service.UserService;

import static org.fusesource.jansi.Ansi.Color.*;
import static org.fusesource.jansi.Ansi.ansi;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        UserService userService = new UserService();
        HotelService hotel = new HotelService(userService);
        User currentUser = null; // 현재 로그인한 사용자 정보
        boolean isRunning = true;

        while (isRunning) {
            if (currentUser == null) {
                // 1단계: 로그인 전
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
                        System.out.println("회원가입을 시작합니다.");
                        System.out.print("아이디를 입력해주세요:"); String id = sc.nextLine();
                        System.out.print("비밀번호를 입력해주세요:"); String pw = sc.nextLine();
                        System.out.print("성함을 입력해주세요:"); String name = sc.nextLine();
                        System.out.print("전화 번호를 입력해주세요(예:010-1234-5678):"); String phoneNumber = sc.nextLine();

                        if(id.isEmpty() || pw.isEmpty()) {
                            System.err.println("아이디와 비밀번호는 필수 입력 사항입니다.");
                            continue;
                        }else
                            userService.signUp(id,pw,name,phoneNumber);
                    }
                    case 3 -> {
                        System.out.println("시스템을 종료합니다.");
                        isRunning = false;
                    }
                    default -> System.err.println("잘못된 입력입니다!");
                }
            } else {
                if (currentUser.isAdmin()) {
                    System.out.println(ansi().fg(CYAN).bold().a("\n[관리자 모드로 접속했습니다]").reset());
                    boolean wantLogout = showAdminMenu(hotel);
                    if (wantLogout) currentUser = null;

                } else {
                    // 2단계: 로그인 후
                    System.out.println("\n--- " + currentUser.getName() + "님 환영합니다 ---");
                    System.out.println("1. 객실 목록  2. 객실 예약  3. 내 예약 정보  4. 로그아웃");
                    int choice = getUserInput("선택: ");

                    switch (choice) {
                        case 1 -> hotel.showRoomGrid();
                        case 2 -> {
                            hotel.showRoomGrid();
                            int roomNo = getUserInput("예약할 객실 번호를 입력하세요:");
                            if (roomNo != -1) {
                                hotel.reserveRoom(roomNo, currentUser);
                            }
                        }
                        case 3 -> {
                            hotel.showMyReservations(currentUser);
                            choice = getUserInput("1.예약 취소  2.돌아가기\n선택:");
                            if (choice == 1) {
                                System.out.print("취소할 예약 번호를 입력해주세요:");
                                String rId = sc.nextLine();
                                if (rId.trim().isEmpty()) {
                                    System.out.println("예약 번호를 입력해야 합니다.");
                                    continue;
                                }
                                boolean isSuccess = hotel.cancelReservations(rId, currentUser);

                                if (isSuccess) {
                                    System.out.println(ansi().fg(GREEN).bold().a("성공적으로 취소되었습니다.").reset());
                                } else {
                                    System.out.println(ansi().fg(RED).bold().a("취소 처리에 실패했습니다.").reset());
                                }
                            } else if (choice == 2) {
                                break;
                            } else {
                                System.err.println("잘못된 입력입니다.");
                            }
                        }
                        case 4 -> {
                            currentUser = null;
                            System.out.println("로그아웃 되었습니다.");
                        }
                        default -> System.err.println("잘못된 입력입니다!");
                    }
                }
            }
        }
    }

    private static boolean showAdminMenu(HotelService hotel) {
        System.out.println(ansi().fg(CYAN).bold().a("\n--- 관리자 메뉴 ---").reset());
        System.out.println("1. 전체 예약 현황 조회 및 취소");
        System.out.println("2. 총 매출 확인");
        System.out.println("3. 객실 현황 보기");
        System.out.println("4. 로그아웃");

        int choice = getUserInput("선택: ");

        switch (choice) {
            case 1 -> {
                hotel.showAllReservations();
                int subChoice = getUserInput("\n1. 예약 강제 취소   2. 돌아가기\n선택: ");
                if (subChoice == 1) {
                    System.out.print("취소할 예약 번호를 입력하세요: ");
                    String rId = sc.nextLine();
                    if (!rId.trim().isEmpty()) {
                        hotel.cancelReservationsAdmin(rId);
                    }
                }
            }
            case 2 -> hotel.showTotalSales();
            case 3 -> hotel.showRoomGrid();
            case 4 -> {
                System.out.println("관리자 모드를 종료하고 로그아웃합니다.");
                return true;
            }
            default -> System.err.println("잘못된 입력입니다.");
        }
        return false;
    }


    // 입력 및 오류 예외처리
    private static int getUserInput(String prompt) {
        System.out.print(prompt);
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("[오류] 숫자만 입력 가능합니다.");
            return -1; // 잘못된 입력
        }
    }
}
