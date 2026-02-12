package array.ex;

import java.util.Scanner;

public class ArrayEx9 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int productCount = 0;
        String[] productNames = new String[10];
        int[] productPrices = new int[10];

        while (true) {
            System.out.println("1. 상품등록 | 2. 상품 목록 | 3. 종료");
            System.out.print("메뉴를 선택하세요:");
            int menu = scn.nextInt();

            if(menu == 1) {
                if(productCount == 10) {
                    System.out.println("더 이상 상품을 등록할 수 없습니다.");
                }
                scn.nextLine();
                System.out.print("상품 이름을 입력하세요:");
                productNames[productCount] = scn.nextLine();
                System.out.print("상품 가격을 입력하세요:");
                productPrices[productCount] = scn.nextInt();
                productCount++;
            }
            else if(menu == 2) {
                if(productCount == 0) {
                    System.out.println("등록된 상품이 없습니다.");
                }
                for(int i=0; i<productCount; i++) {
                    System.out.println(productNames[i] + ": " + productPrices[i] + "원");
                }
            }
            else if(menu == 3) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            else {
                System.out.println("잘못된 명령어입니다.");
            }
        }
    }
}
