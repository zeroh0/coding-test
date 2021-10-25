package bankApplication;

import java.text.DecimalFormat;

public class Account {
    static final String bankNo="111";
    static int seq=0;
    private String ano;
    private String owner;
    private int balance;

    {
        seq++;
        DecimalFormat df = new DecimalFormat("000");
        df.format(seq);
        ano = bankNo +"-"+df.format(seq);
    }

    public Account(String owner, int balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public String getAno() {
        return ano;
    }
    public void setAno(String ano) {
        this.ano = ano;
    }
    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "계좌번호: " + ano + "\n계좌주: " + owner + "\n입금액: " + balance + "\n\r";
    }
}

