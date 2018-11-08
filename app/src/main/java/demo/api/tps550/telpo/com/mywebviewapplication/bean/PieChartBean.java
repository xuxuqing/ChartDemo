package demo.api.tps550.telpo.com.mywebviewapplication.bean;

/**
 * Created by xx on 2018/10/19.
 */

public class PieChartBean {

    private int money = 0;
    private String date = "";

    public PieChartBean(int money, String date) {
        this.money = money;
        this.date = date;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
