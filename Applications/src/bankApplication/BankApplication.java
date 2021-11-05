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

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
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
                    try {
                        rs.close();
                        pstmt.close();
                        con.close();
                    } catch (NullPointerException e) {
                        run = false;
                    }
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

        System.out.print("계좌주: ");
        String owner = scanner.next();
        System.out.print("초기입금액: ");
        int balance = scanner.nextInt();

        sql = "insert into ACCOUNT values" +
                " ((select '111'||'-'||lpad(to_number(nvl(substr(nvl(max(ANO),0),5,3),0))+1,3,'0') from ACCOUNT) ,? ,?)";
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1, owner);
        pstmt.setInt(2, balance);

        int resultCnt = pstmt.executeUpdate();
        if(resultCnt > 0) {
            System.out.println("결과: 계좌를 생성했습니다.");
            // printInfo.add();
        } else {
            System.out.println("결과: 계좌 생성을 실패했습니다.");
        }
    }

    // 2. 계좌목록
    private static void accountList() throws SQLException {
        System.out.println("------");
        System.out.println("계좌목록");
        System.out.println("------");

        sql = "select ANO, OWNER, BALANCE from ACCOUNT order by ANO";
        pstmt = con.prepareStatement(sql);
        rs = pstmt.executeQuery(sql);
        while(rs.next()) {
            System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3));
        }
    }

    // 3. 예금
    private static void deposit() {
        System.out.println("------");
        System.out.println("예금");
        System.out.println("------");

        System.out.print("계좌번호: ");
        String ano = scanner.next();
        System.out.print("예금액: ");
        int amount = scanner.nextInt();

        try {
            sql = "update ACCOUNT set BALANCE = (select BALANCE from ACCOUNT where ANO = '"+ano+"') + " + amount + " where ANO = '"+ano+"'";
            pstmt = con.prepareStatement(sql);

            int resultCnt = pstmt.executeUpdate();
            if(resultCnt > 0) {
                System.out.println("결과: 예금을 성공했습니다.");
                // printInfo.add();
            } else {
                System.out.println("결과: 예금을 실패했습니다.");
            }
        } catch (SQLException e) {
            System.out.println("결과: 계좌번호를 확인해주세요.");
        }
    }

    // 4. 출금
    private static void withdraw() {
        System.out.println("------");
        System.out.println("출금");
        System.out.println("------");

        System.out.print("계좌번호: ");
        String ano = scanner.next();
        System.out.print("출금액: ");
        int amount = scanner.nextInt();

        try {
            sql = "select BALANCE from ACCOUNT where ANO = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, ano);
            rs = pstmt.executeQuery();
            rs.next();
            int balance = rs.getInt(1);

            if(balance - amount >= 0) {
                balance -= amount;
                sql = "update ACCOUNT set BALANCE = ? where ANO = ?";
                pstmt = con.prepareStatement(sql);
                pstmt.setInt(1, balance);
                pstmt.setString(2, ano);

                int resultCnt = pstmt.executeUpdate();
                if(resultCnt > 0) {
                    System.out.println("결과: 출금을 성공했습니다.");
                    // printInfo.add();
                } else {
                    System.out.println("결과: 출금을 실패했습니다.");
                }
            } else {
                System.out.println("결과: 잔고가 부족합니다.");
            }
        } catch (SQLException e) {
            System.out.println("결과: 계좌번호를 확인해주세요.");
        }
    }


    // 5. 이체
    private static void transfer() {
        System.out.println("------");
        System.out.println("이체");
        System.out.println("------");

        System.out.print("보내는 계좌번호> ");
        String ano1 = scanner.next();
        System.out.print("받는 계좌번호> ");
        String ano2 = scanner.next();
        System.out.print("이체액> ");
        int amount = scanner.nextInt();

        try {
            int balance1 = 0;
            int balance2 = 0;

            /*
            sql = "select BALANCE from ACCOUNT where ANO = ?" +
                  " union all" +
                  " select BALANCE from ACCOUNT where ANO = ?";
            */
            /*
            이걸로 변경!!!
            select sum(ano1), sum(ano2), sum(balance1), sum(balance2) from
            (select count(*) ano1, 0 ano2, BALANCE balance1, 0 balance2 from ACCOUNT where ANO = '111-005' group by BALANCE
            union all
            select 0 ano1, count(*) ano2, 0 balance1, BALANCE balance2 from ACCOUNT where ANO = '111-006' group by BALANCE);
            */
            sql = "" +
                    " (select count(*) ano1, sum(BALANCE) balance1 from ACCOUNT where ANO = ?" +
                    " union all" +
                    " select count(*) ano2, sum(BALANCE) balance2 from ACCOUNT where ANO = ?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, ano1);
            pstmt.setString(2, ano2);
            rs = pstmt.executeQuery();
            rs.next();
                balance1 = rs.getInt(1);
            rs.next();
                balance2 = rs.getInt(1);

            if(balance1 - amount >= 0) {
                balance1 -= amount;
                balance2 += amount;

                sql = "update ACCOUNT set BALANCE = ? where ANO = '"+ano1+"'";
                pstmt = con.prepareStatement(sql);
                pstmt.setInt(1, balance1);
                int resultCnt1 = pstmt.executeUpdate();

                sql = "update ACCOUNT set BALANCE = ? where ANO = '"+ano2+"'";
                pstmt = con.prepareStatement(sql);
                pstmt.setInt(1, balance2);
                int resultCnt2 = pstmt.executeUpdate();

                if(resultCnt1 > 0 && resultCnt2 > 0) {
                    System.out.println("결과: 이체을 성공했습니다.");
                    // printInfo.add();
                } else {
                    System.out.println("결과: 이체을 실패했습니다.");
                }
            }
        } catch (SQLException e) {
            System.out.println("결과: 계좌번호를 확인해주세요.");
            e.printStackTrace();
        }
    }

}