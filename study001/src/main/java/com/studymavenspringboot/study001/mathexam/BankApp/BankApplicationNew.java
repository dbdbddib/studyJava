package com.studymavenspringboot.study001.mathexam.BankApp;

import java.util.Scanner;

public class BankApplicationNew {
    private AccountService accountService = new AccountService();

    private void printMenu() {
        System.out.println("\n========================================================");
        System.out.println("1.계좌생성|2.계좌목록|3.예금|4.출금|5.종료");
        System.out.println("========================================================\n");
        living();
    }

    private int getUserChoice(Scanner input) throws Exception {
        System.out.print("선택 > ");
        String a = input.nextLine();
        return Integer.parseInt(a);
    }

    private void createAccount(Scanner input) throws Exception {
        System.out.println("--------");
        System.out.println("계좌생성");
        System.out.println("--------");

        System.out.print("계좌번호:");
        String bankNumber = input.nextLine();

        // 계좌 중복 확인
        if(accountService.findAccount(bankNumber) != null){
            System.out.println("\n계좌번호:'" + bankNumber + "'은 중복으로 인한 생성 불가능....");
            return;
        }

        System.out.print("계좌주:");
        String name = input.nextLine();
        System.out.print("초기입금액:");
        String current = input.nextLine();
        int money = Integer.parseInt(current);

        this.accountService.addAccount(new Account(name, bankNumber, money));
    }

    private void displayAccounts() {
        living();
    }

    private void depositFunds(Scanner input) throws Exception {
        Account result = getAccountDetails(input, "예금");

        if ( result == null ) {
            System.out.println("에러: 계좌가 존재하지 않습니다.");
            return;
        }
        if ( this.accountService.deposit(result.getBankNumber(), result.getCurrent()) ) {
            System.out.println("결과: 예금이 성공되었습니다.");
        }
    }


    private void withdrawFunds(Scanner input) throws Exception {
        Account result = getAccountDetails(input, "출금");
        if ( result == null ) {
            System.out.println("에러: 계좌가 존재하지 않습니다.\n");
            living();
            return;
        }
        if ( this.accountService.withdraw(result.getBankNumber(), result.getCurrent()) ) {
            System.out.println("결과: 출금이 성공되었습니다.");
        } else {
            System.out.println("에러: 출금이 안되었습니다.");
        }
    }

    private Account getAccountDetails(Scanner input, String title) {
        System.out.println("--------");
        System.out.println(title);  // 예금, 출금
        System.out.println("--------");

        System.out.print("계좌번호:");

        String bankNumber = input.nextLine();   // 계좌번호 받는 변수

        // 계좌번호 받고 계좌 찾는
        Account account = this.accountService.findAccount(bankNumber);

        if ( account == null ) {
            return null;
        }
        System.out.print(title + "액:");
        String current = input.nextLine();  // 예금액, 출금액
        int money = Integer.parseInt(current);



        return new Account("임시명", bankNumber, money);
    }


    // 계좌정보에 대한 함수
    private void living() {
        int n = 0;
        if(accountService.size() == 0) {
            System.out.println("현재 생성된 계좌가 존재하지 않습니다.\n");
        } else {
            for (Account account : this.accountService.getAllAccount()) {
                System.out.println((n + 1) + ". 계좌번호: " + account.getBankNumber() + "\t\t금액: " +
                        account.getCurrent() + "\t\t계좌주: " + account.getName() + "\n");
                n++;
            }
        }
    }


    public static void main(String[] args) {
        try {
            BankApplicationNew bapp = new BankApplicationNew();

            Scanner sc = new Scanner(System.in);

            boolean isRunning = true;

            while(isRunning) {
                bapp.printMenu();
                int choice = bapp.getUserChoice(sc);
                switch (choice) {
                    case 1:
                        bapp.createAccount(sc);
                        break;
                    case 2:
                        bapp.displayAccounts();
                        break;
                    case 3:
                        bapp.depositFunds(sc);
                        break;
                    case 4:
                        bapp.withdrawFunds(sc);
                        break;
                    case 5:
                        isRunning = false;
                        break;
                    default:
                        System.out.println("!!! 잘못된 입력입니다. !!!");
                        break;
                }

                // 메뉴 다시 표시 전 사용자에게 묻는 기능
                if (choice != 5) {
                    System.out.print("\n계속하시겠습니까? (y/n): ");
                    String continueChoice = sc.nextLine().trim();
                    if (!continueChoice.equalsIgnoreCase("y")) {
                        isRunning = false;
                    }
                } // if
            } // while
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    } // main()
} // class
