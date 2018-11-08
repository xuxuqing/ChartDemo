package demo.api.tps550.telpo.com.mywebviewapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.List;

import demo.api.tps550.telpo.com.mywebviewapplication.bean.CompositeIndexBean;
import demo.api.tps550.telpo.com.mywebviewapplication.bean.IncomeBean;
import demo.api.tps550.telpo.com.mywebviewapplication.bean.LineChartBean;
import demo.api.tps550.telpo.com.mywebviewapplication.bean.PieChartBean;
import demo.api.tps550.telpo.com.mywebviewapplication.bean.VtDateValueBean;
import demo.api.tps550.telpo.com.mywebviewapplication.utils.LocalJsonAnalyzeUtil;
import demo.api.tps550.telpo.com.mywebviewapplication.utils.MPChartUtils;
import demo.api.tps550.telpo.com.mywebviewapplication.wegith.MyPieChart;
import demo.api.tps550.telpo.com.mywebviewapplication.wegith.chartmanger.LineChartManager;

public class BarChartActivity extends AppCompatActivity {

    private BarChart barChart;
    private MyPieChart pieChart;
    private LineChart lineChart;
    /**
     * barChart数据
     */
    private List<VtDateValueBean> dateValueList = new ArrayList<>();


    private LineChartManager lineChartManager1;
    /**
     * linechart数据
     */
    private LineChartBean lineChartBean;
    private List<IncomeBean> incomeBeanList;//个人收益
    private List<CompositeIndexBean> shanghai;//沪市指数
    private List<CompositeIndexBean> shenzheng;//深市指数
    private List<CompositeIndexBean> GEM;//创业板指数

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);

        barChart = (BarChart) findViewById(R.id.barChart);
        pieChart = (MyPieChart) findViewById(R.id.pieChart);
        lineChart = (LineChart) findViewById(R.id.lineChart);
        //初始化-柱状图
        MPChartUtils.initBarChart(barChart, dateValueList);
        setBarChartData();

        //初始化-饼状图
        MPChartUtils.initPieChart(pieChart);
        setPieChartData();

        //初始化-线型图
        lineChartManager1 = new LineChartManager(lineChart);
        setLineChartData();
    }

    /**
     * 设置饼状图数据
     */
    private void setPieChartData() {
        ArrayList<PieChartBean> pieChartList = new ArrayList<>();
        pieChartList.add(new PieChartBean(60, "啊啊啊"));
        pieChartList.add(new PieChartBean(20, "阿斯达"));
        pieChartList.add(new PieChartBean(10, "光伏发电"));
        pieChartList.add(new PieChartBean(4, "第三方刚的官方"));
        pieChartList.add(new PieChartBean(6, "元图腾与"));

        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.parseColor("#ff0000"));
        colors.add(Color.parseColor("#00ff00"));
        colors.add(Color.parseColor("#0000ff"));
        colors.add(Color.parseColor("#ffff00"));
        colors.add(Color.parseColor("#ff00ff"));
        MPChartUtils.showPieChart(pieChart, pieChartList, colors);
    }

    /**
     * 设置柱状图数据
     */
    private void setBarChartData() {
        dateValueList.add(new VtDateValueBean(2,"10-01"));
        dateValueList.add(new VtDateValueBean((float) 0.2,"10-02"));
        dateValueList.add(new VtDateValueBean((float) 0.9,"10-03"));
        dateValueList.add(new VtDateValueBean((float) 1.9,"10-04"));
        dateValueList.add(new VtDateValueBean((float) 5.9,"10-05"));
        dateValueList.add(new VtDateValueBean((float) 2.9,"10-06"));
        dateValueList.add(new VtDateValueBean(2,"10-01"));

        barChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
//                if (isUp){
//                e.getX();       //X轴坐标 记得转 int
                float y = e.getY();//当前柱状图Y轴值
//                e.getIcon();    //对应 BarEntry(float x, float y, Drawable icon)
                String data = (String) e.getData();//对应 BarEntry(float x, float y, Object data)

                Log.d("xuanz",y+"  "+data);

            }

            @Override
            public void onNothingSelected() {

            }
        });
        MPChartUtils.showBarChart(barChart,dateValueList);
    }

    /**
     * 设置线型图数据
     */
    private void setLineChartData() {
        //获取数据
        lineChartBean = LocalJsonAnalyzeUtil.JsonToObject(this, "line_chart.json", LineChartBean.class);
        incomeBeanList = lineChartBean.getGRID0().getResult().getClientAccumulativeRate();

        shanghai = lineChartBean.getGRID0().getResult().getCompositeIndexShanghai();
        shenzheng = lineChartBean.getGRID0().getResult().getCompositeIndexShenzhen();
        GEM = lineChartBean.getGRID0().getResult().getCompositeIndexGEM();


        //展示图表
        lineChartManager1.showLineChart(incomeBeanList, "我的收益", getResources().getColor(R.color.blue));
        lineChartManager1.addLine(shanghai, "上证指数", getResources().getColor(R.color.orange));
        lineChartManager1.addLine(shenzheng, "深证指数", getResources().getColor(R.color.green));
        lineChartManager1.addLine( GEM, "创业指数", getResources().getColor(R.color.colorAccent));
        //设置曲线填充色 以及 MarkerView
//        Drawable drawable = getResources().getDrawable(R.drawable.fade_blue);
//        lineChartManager1.setChartFillDrawable(drawable);
        lineChartManager1.setMarkerView(this);
    }
}
