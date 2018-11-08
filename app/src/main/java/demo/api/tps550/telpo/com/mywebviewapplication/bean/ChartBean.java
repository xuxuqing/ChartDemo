package demo.api.tps550.telpo.com.mywebviewapplication.bean;

/**
 * Created by xx on 2018/10/19.
 */

public class ChartBean {

    private float num = 0;
    private String date = "";

    public ChartBean(float money, String date) {
        this.num = money;
        this.date = date;
    }

    public float getNum() {
        return num;
    }

    public void setNum(float num) {
        this.num = num;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
