package bankApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BankApplication {
    private static Scanner scanner = new Scanner(System.in);
    static List<Account> accountList  = new ArrayList<>();
    static List<String> printInfo = new ArrayList<>();
    static Date today = new Date();
    static SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
    static final String myUrl = "/Users/zeroh0/desktop/temp/BankApplication.txt"; // 경로

    static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
    static final String user = "bank";
    static final String password = "bank";

    static Connection con = null;
    static PreparedStatement pstmt = null;
    static ResultSet rs = null;
    static String sql = null;

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection(url, user, password);

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
                    System.out.println("준비 중입니다!");
                    /*
                    BufferedReader reader = new BufferedReader(
                            new FileReader(myUrl, Charset.forName("UTF-8"))
                    );
                    String line;
                    while((line = reader.readLine()) != null)
                        System.out.println(line);
                    reader.close();
                    */
                    break;
                case 7:
                    /*
                    FileWriter fileWriter = new FileWriter(myUrl);
                    for(String s:printInfo)
                        fileWriter.write(s);
                    fileWriter.close();
                    */

                    rs.close();
                    pstmt.close();
                    con.close();

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
    private static void createAccount() throws SQLException {
        System.out.println("------");
        System.out.println("계좌생성");
        System.out.println("------");

        System.out.print("계좌주:");
        String owner = scanner.next();
        System.out.print("초기입금액:");
        int balance = scanner.nextInt();

        sql = "insert into ACCOUNT values" +
                " ((select '111'||'-'||lpad(to_number(nvl(substr(nvl(max(ANO),0),5,3),0))+1,3,'0') from ACCOUNT) ,? ,?)";
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1, owner);
        pstmt.setInt(2, balance);

        int resultCnt = pstmt.executeUpdate();
        if(resultCnt > 0) System.out.println("결과: 계좌가 생성되었습니다.");
        else System.out.println("결과: 계좌 생성을 실패하였습니다.");
    }

    // 2. 계좌목록
    private static void accountList() throws SQLException {
        System.out.println("------");
        System.out.println("계좌목록");
        System.out.println("------");

        sql = "select * from ACCOUNT order by ANO";
        pstmt = con.prepareStatement(sql);
        rs = pstmt.executeQuery(sql);
        while(rs.next()) {
            System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3));
        }
    }

    // 계좌찾기
    private static String findAccount(String ano) throws SQLException {
        sql = "select ANO from ACCOUNT order by ANO";
        pstmt = con.prepareStatement(sql);
        rs = pstmt.executeQuery(sql);
        rs.next();
        return (rs.getString(1));
    }

    // 3. 예금
    private static void deposit() throws SQLException {
        System.out.println("------");
        System.out.println("예금");
        System.out.println("------");

        System.out.print("계좌번호");
        String ano = scanner.next();
        System.out.print("예금액");
        int amount = scanner.nextInt();

        String acc = findAccount(ano);
        System.out.println("조회결과:"+acc);
        if (acc != null) {
            sql = "select BALANCE from ACCOUNT where ANO = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, acc);
            rs = pstmt.executeQuery();
            rs.next();
            int balance = rs.getInt(1) + amount;

            sql = "update ACCOUNT set BALANCE = ? where ANO = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, balance);
            pstmt.setString(2, acc);

            int resultCnt = pstmt.executeUpdate();
            if(resultCnt > 0) {
                System.out.println("결과: 예금이 성공되었습니다.");
                // printInfo.add("[예금] "+ df.format(today) +"\n계좌번호:" + ano + "\n예금액: " +amount + "원" +"\n잔액: " + acc.getBalance() + "원" + "\n\r");
            } else {
                System.out.println("결과: 예금을 실패했습니다.");
            }

        } else {
            System.out.println("결과: 계좌번호를 확인해주세요.");
        }
    }

    // 4. 출금
    private static void withdraw() throws SQLException {
        System.out.println("------");
        System.out.println("출금");
        System.out.println("------");

        System.out.print("계좌번호");
        String ano = scanner.next();
        System.out.print("출금액");
        int amount = scanner.nextInt();

        String acc = findAccount(ano);
        if (acc != null) {
            sql = "select BALANCE from ACCOUNT where ANO = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, acc);
            rs = pstmt.executeQuery();
            rs.next();
            int balance = rs.getInt(1);
            if(balance - amount >= 0) {
                balance -= amount;
                sql = "update ACCOUNT set BALANCE = ? where ANO = ?";
                pstmt = con.prepareStatement(sql);
                pstmt.setInt(1, balance);
                pstmt.setString(2, acc);

                int resultCnt = pstmt.executeUpdate();
                if(resultCnt > 0) {
                    System.out.println("결과: 예금이 성공되었습니다.");
                    // printInfo.add("[출금] "+ df.format(today) +"\n계좌번호:" + ano + "\n출금액: " +amount + "원" + "\n잔액: " + acc.getBalance() + "원" + "\n\r");
                } else {
                    System.out.println("결과: 예금을 실패했습니다.");
                }

            } else {
                System.out.println("결과: 잔고가 부족합니다.");
            }

        }else {
            System.out.println("결과: 계좌번호를 확인해주세요.");
        }
    }

    // 5. 이체
    private static void transfer() throws SQLException {
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
        } else {
            String a1 = findAccount(ano1);
            String a2 = findAccount(ano2);

            sql = "select BALANCE from ACCOUNT where ANO = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, a1);
            rs = pstmt.executeQuery();
            rs.next();
            int balance_a1 = rs.getInt(1);

            sql = "select BALANCE from ACCOUNT where ANO = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, a2);
            rs = pstmt.executeQuery();
            rs.next();
            int balance_a2 = rs.getInt(1);

            if (balance_a1 - amount >= 0) {
                balance_a1 -= amount;
                balance_a2 += amount;

                String sql1 = "update ACCOUNT set BALANCE = ? where ANO = ?";
                PreparedStatement pstmt1 = con.prepareStatement(sql);
                pstmt1.setInt(1, balance_a1);
                pstmt1.setString(2, a1);
                int resultCnt_a1 = pstmt1.executeUpdate();

                String sql2 = "update ACCOUNT set BALANCE = ? where ANO = ?";
                PreparedStatement pstmt2 = con.prepareStatement(sql);
                pstmt2.setInt(1, balance_a2);
                pstmt2.setString(2, a2);
                int resultCnt_a2 = pstmt2.executeUpdate();

                if(resultCnt_a1 > 0 && resultCnt_a2 > 0) {
                    System.out.println("결과: 예금이 성공되었습니다.");
                    // printInfo.add("[출금] "+ df.format(today) +"\n계좌번호:" + ano + "\n출금액: " +amount + "원" + "\n잔액: " + acc.getBalance() + "원" + "\n\r");
                } else {
                    System.out.println("결과: 예금을 실패했습니다.");
                }
                pstmt1.close();
                pstmt2.close();

            }else {
                System.out.println("결과: 잔고가 부족합니다.");
            }
        }

    }

}