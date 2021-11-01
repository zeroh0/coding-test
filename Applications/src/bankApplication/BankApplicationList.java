package bankApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BankApplicationList {
    private static Scanner scanner = new Scanner(System.in);
    static List<Account> accountList  = new ArrayList<>();
    static List<String> printInfo = new ArrayList<>();
    static Date today = new Date();
    static SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
    static final String myUrl = "/Users/zeroh0/desktop/temp/BankApplication.txt"; // 경로

    public static void main(String[] args) throws IOException {
        boolean run = true;
        while(run) {
            printMenu();
            int selectNo = scanner.nextInt();
            switch(selectNo) {
                case 1: createAccount(); break;
                case 2: accountList(); break;
                case 3: deposit(); break;
                case 4: withdraw(); break;
                case 5: transfer(); break;
                case 6:
                    BufferedReader reader = new BufferedReader(
                            new FileReader(myUrl, Charset.forName("UTF-8"))
                    );
                    String line;
                    while((line = reader.readLine()) != null)
                        System.out.println(line);
                    reader.close();
                    break;
                case 7:
                    FileWriter fileWriter = new FileWriter(myUrl);
                    for(String s:printInfo)
                        fileWriter.write(s);
                    fileWriter.close();
                    run = false;
                    break;
            }
        }
        System.out.println("프로그램 종료");
    }

    private static void printMenu() {
        System.out.println("-------------------------------------------------------------------");
        System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.이체 | 6.이용내역조회 | 7.종료");
        System.out.println("-------------------------------------------------------------------");
        System.out.print("선택> ");
    }

    // 1. 계좌생성
    private static void createAccount() {
        System.out.println("------");
        System.out.println("계좌생성");
        System.out.println("------");

        System.out.print("계좌주:");
        String owner = scanner.next();
        System.out.print("초기입금액:");
        int balance = scanner.nextInt();

        Account acc = new Account(owner, balance);
        accountList.add(acc);
        printInfo.add("[계좌생성] "+ df.format(today) +"\n계좌번호: " + acc.getAno() + "\n계좌주: " + acc.getOwner() + "\n입금액: " + acc.getBalance() + "원" + "\n\r");
        System.out.println("결과:계좌가 생성되었습니다.");
    }

    // 2. 계좌목록
    private static void accountList() {
        System.out.println("------");
        System.out.println("계좌목록");
        System.out.println("------");

        for(int i=0;i<accountList.size();i++) {
            Account account=accountList.get(i);
            System.out.println(account);
        }
    }

    // 계좌찾기
    private static Account findAccount(String ano) {
        for(int i=0;i<accountList.size();i++) {
            Account account =accountList.get(i);
            if(account.getAno().equals(ano)) return account;
        }
        return null;
    }

    // 3. 예금
    private static void deposit() {
        System.out.println("------");
        System.out.println("예금");
        System.out.println("------");

        System.out.print("계좌번호");
        String ano = scanner.next();
        System.out.print("예금액");
        int amount = scanner.nextInt();

        Account acc = findAccount(ano);
        System.out.println("조회결과:"+acc);
        if (acc != null) {
            acc.setBalance(acc.getBalance() + amount);
            System.out.println("결과:예금이 성공되었습니다.");
            printInfo.add("[예금] "+ df.format(today) +"\n계좌번호:" + ano + "\n예금액: " +amount + "원" +"\n잔액: " + acc.getBalance() + "원" + "\n\r");
        }else {
            System.out.println("결과:계좌번호를 확인해주세요.");
        }
    }

    // 4. 출금
    private static void withdraw() {
        System.out.println("------");
        System.out.println("출금");
        System.out.println("------");

        System.out.print("계좌번호");
        String ano = scanner.next();
        System.out.print("출금액");
        int amount = scanner.nextInt();

        Account acc = findAccount(ano);
        if (acc != null) {
            if (acc.getBalance() - amount >= 0) {
                acc.setBalance(acc.getBalance() - amount);
                System.out.println("결과:출금이 성공되었습니다.");
                printInfo.add("[출금] "+ df.format(today) +"\n계좌번호:" + ano + "\n출금액: " +amount + "원" + "\n잔액: " + acc.getBalance() + "원" + "\n\r");
            }else {
                System.out.println("결과:잔고가 부족합니다.");
            }
        }else {
            System.out.println("결과:계좌번호를 확인해주세요.");
        }
    }

    // 5. 이체
    private static void transfer() {
        System.out.println("------");
        System.out.println("이체");
        System.out.println("------");

        System.out.print("보내는 계좌번호>");
        String ano1 = scanner.next();
        System.out.print("받는 계좌번호>");
        String ano2 = scanner.next();
        System.out.print("이체액>");
        int amount = scanner.nextInt();

        if(findAccount(ano1) == null || findAccount(ano2) == null) {
            System.out.println("계좌번호를 확인하세요!!");
        }else {
            Account a1 = findAccount(ano1);
            Account a2 = findAccount(ano2);
            if (a1.getBalance() - amount >= 0) {
                a1.setBalance(a1.getBalance()-amount);
                a2.setBalance(a2.getBalance()+amount);
                System.out.println("이체가 완료되었습니다.");
                printInfo.add("[이체] "+ df.format(today) +"\n보내는 계좌번호: " + ano1 + "\n받는 계좌번호: " + ano2 + "\n이체액: " + amount  + "원" +"\n\r");
            }else {
                System.out.println("결과:잔고가 부족합니다.");
            }
        }
    }

}

