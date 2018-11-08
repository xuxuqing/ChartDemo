package demo.api.tps550.telpo.com.mywebviewapplication.bean;

/**
 * Created by xx on 2018/10/19.
 */

public class VtDateValueBean {

    private float money = 0f;
    private String date = "10-19";

    public VtDateValueBean(float money, String date) {
        this.money = money;
        this.date = date;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
