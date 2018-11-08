package demo.api.tps550.telpo.com.mywebviewapplication.utils;

import android.graphics.Color;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.util.ArrayList;
import java.util.List;

import demo.api.tps550.telpo.com.mywebviewapplication.bean.PieChartBean;
import demo.api.tps550.telpo.com.mywebviewapplication.bean.VtDateValueBean;
import demo.api.tps550.telpo.com.mywebviewapplication.wegith.MyPieChart;

/**
 * Created by xx on 2018/11/6.
 */

public class MPChartUtils {

    /**
     * 初始化柱状图表
     * @param barChart
     * @param dateValueList
     */
    public static void initBarChart(BarChart barChart, final List<VtDateValueBean> dateValueList) {
        /***图表设置***/
        //背景颜色
        barChart.setBackgroundColor(Color.WHITE);
        //不显示图表网格
        barChart.setDrawGridBackground(false);
        //背景阴影
        barChart.setDrawBarShadow(false);
        barChart.setHighlightFullBarEnabled(false);
        //显示边框
        barChart.setDrawBorders(false);
        //不显示右下角描述内容
        Description description = new Description();
        description.setEnabled(false);
        barChart.setDescription(description);
        //设置动画效果
        barChart.animateY(1000, Easing.EasingOption.Linear);
        barChart.animateX(1000, Easing.EasingOption.Linear);
        // 设置是否可以缩放图表
        barChart.setScaleEnabled(false);
        // 设置是否可以用手指移动图表
        barChart.setDragEnabled(false);
        //是否可触摸
//        barChart.setTouchEnabled(true);

//        barChart.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                if (motionEvent.getAction() == MotionEvent.ACTION_UP){
//                    isUp = true;
//                }else {
//                    isUp = false;
//                }
//                return false;
//            }
//        });
//        barChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
//            @Override
//            public void onValueSelected(Entry e, Highlight h) {
////                if (isUp){
////                e.getX();       //X轴坐标 记得转 int
//                float y = e.getY();//当前柱状图Y轴值
////                e.getIcon();    //对应 BarEntry(float x, float y, Drawable icon)
//                String data = (String) e.getData();//对应 BarEntry(float x, float y, Object data)
//
//                Log.d("xuanz",y+"  "+data);
//
//            }
//
//            @Override
//            public void onNothingSelected() {
//
//            }
//        });

        /***XY轴的设置***/
        //X轴设置显示位置在底部
        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
//        xAxis.setAxisMinimum(0f);
        //不显示X轴网格线
        xAxis.setDrawAxisLine(false);
        xAxis.setDrawGridLines(false);
        //X轴自定义值
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return dateValueList.get((int) value % dateValueList.size()).getDate();
            }
        });

        YAxis leftAxis = barChart.getAxisLeft();
        YAxis rightAxis = barChart.getAxisRight();

        //保证Y轴从0开始，不然会上移一点
        leftAxis.setAxisMinimum(0f);
        //不显示网格线
        leftAxis.setDrawAxisLine(false);
        leftAxis.setDrawGridLines(false);
        leftAxis.setEnabled(false);

//        rightAxis.setAxisMinimum(0f);
        //不显示网格线
        rightAxis.setDrawAxisLine(false);
        rightAxis.setDrawGridLines(false);
        rightAxis.setEnabled(false);

        /***图例 标签 设置***/
        Legend legend = barChart.getLegend();
        legend.setEnabled(false);//不设置图例
    }
    /**
     * 开始封装数据显示柱状图
     */
    public static void showBarChart(BarChart barChart, List<VtDateValueBean> dateValueList) {

        ArrayList<BarEntry> entries = new ArrayList<>();
        for (int i = 0; i < dateValueList.size(); i++) {
            /**
             * 此处还可传入Drawable对象 BarEntry(float x, float y, Drawable icon)
             * 即可设置柱状图顶部的 icon展示
             */
            BarEntry barEntry = new BarEntry(i, dateValueList.get(i).getMoney(),dateValueList.get(i).getDate());
            entries.add(barEntry);
        }
        // 每一个BarDataSet代表一类柱状图
        BarDataSet barDataSet = new BarDataSet(entries, "");
        barDataSet.setColor(Color.parseColor("#91B4FE"));
        barDataSet.setFormLineWidth(0.1f);
        barDataSet.setFormSize(10f);
        //是否显示柱状图顶部值
        barDataSet.setDrawValues(true);
        //点击后的透明度
        barDataSet.setHighLightAlpha(80);
        //图形上方的字体设置
        barDataSet.setValueTextSize(13f);
        barDataSet.setValueTextColor(Color.parseColor("#608EF1"));

//        // 添加多个BarDataSet时
//        ArrayList<IBarDataSet> dataSets = new ArrayList<>();
//        dataSets.add(barDataSet);
//        BarData data = new BarData(dataSets);

        BarData data = new BarData(barDataSet);
        //柱状图的宽度
        data.setBarWidth(0.5f);
        barChart.setData(data);
    }


    /**
     * 初始化环形饼状图
     * @param pieChart
     */
    public static void initPieChart(final MyPieChart pieChart) {
        //背景颜色
        pieChart.setBackgroundColor(Color.WHITE);
        // 设置饼图是否接收点击事件，默认为true
        pieChart.setTouchEnabled(true);
        //设置饼图是否使用百分比
        pieChart.setUsePercentValues(true);
        //不显示右下角描述内容
        pieChart.getDescription().setEnabled(false);

        pieChart.setExtraOffsets(0.f, 20.f, 0.f, 10.f);

        //是否显示圆盘中间文字，默认显示
        pieChart.setDrawCenterText(false);
//        pieChart.setHoleColor(Color.WHITE);//设置中间圆盘的颜色
        //设置圆盘中间文字
//        pieChart.setCenterText(generateCenterSpannableText());
//        pieChart.setTransparentCircleColor(getResources().getColor(R.color.bantouming));
//        pieChart.setTransparentCircleAlpha(100);

        pieChart.setHoleRadius(60); //设置中间圆盘的半径,值为所占饼图的百分比
        pieChart.setTransparentCircleRadius(63); //设置中间透明圈的半径,值为所占饼图的百分比

        pieChart.setDrawCenterText(false);//饼状图中间可以添加文字

        //设置圆盘是否转动，默认转动
        pieChart.setRotationEnabled(false);
        //设置初始旋转角度
//        pieChart.setRotationAngle(100);

//        //设置比例图
        Legend mLegend = pieChart.getLegend();
        mLegend.setEnabled(false);
//        //设置比例图显示在饼图的哪个位置
//        mLegend.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);
////        //设置比例图的形状，默认是方形,可为方形、圆形、线性
//        mLegend.setForm(Legend.LegendForm.SQUARE);
//        mLegend.setXEntrySpace(10f);//设置距离饼图的距离，防止与饼图重合
//        mLegend.setYEntrySpace(0f);
//        mLegend.setYOffset(2f);
////        //设置比例块换行...
//        mLegend.setWordWrapEnabled(true);

        // 设置一个选中区域监听
//        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
//
//            @Override
//            public void onValueSelected(Entry e, Highlight h) {
//                Log.d("piechart",e.getX() + " --- " + e.getY());
//            }
//
//            @Override
//            public void onNothingSelected() {
//            }
//        });
    }

    /**
     * 开始封装数据显示环形饼状图
     */
    public static void showPieChart(MyPieChart pieChart, List<PieChartBean> dateValueList, ArrayList<Integer> colors) {
        /**
         * valueList将一个饼形图分成三部分，各个区域的百分比的值
         * Entry构造函数中
         * 第一个值代表所占比例，
         * 第二个值代表区域位置
         * （可以有第三个参数，表示携带的数据object）这里没用到
         */
        ArrayList<PieEntry> valueList = new ArrayList<>();
        for (PieChartBean bean: dateValueList) {
            valueList.add(new PieEntry(bean.getMoney(), bean.getDate()));
        }

        //显示在比例图上
        PieDataSet dataSet = new PieDataSet(valueList, "");
        //设置各个饼状图之间的距离
        dataSet.setSliceSpace(0f);
        // 部分区域被选中时多出的长度
        dataSet.setSelectionShift(2f);

//数据连接线距图形片内部边界的距离，为百分数(0~100f)
        dataSet.setValueLinePart1OffsetPercentage(100f);
        dataSet.setValueLinePart1Length(0.7f);//设置连接线的长度
        dataSet.setValueLinePart2Length(0.2f);
        dataSet.setHighlightEnabled(true);
//x,y值在圆外显示(在圆外才会有连接线)
        dataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        dataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
//设置x,y在圆外显示的值为透明(transparent = 0x00000000)
        dataSet.setValueLineColor(0xff000000);  //设置指示线条颜色,必须设置成这样，才能和饼图区域颜色一致


        // 设置饼图各个区域颜色
//        ArrayList<Integer> colors = new ArrayList<>();
//        colors.add(Color.parseColor("#ff0000"));
//        colors.add(Color.parseColor("#00ff00"));
//        colors.add(Color.parseColor("#0000ff"));
//        colors.add(Color.parseColor("#ffff00"));
//        colors.add(Color.parseColor("#ff00ff"));
        dataSet.setColors(colors);

        PieData data = new PieData(dataSet);
        //设置以百分比显示
        data.setValueFormatter(new PercentFormatter());
        //是否在唉图标上显示值
        data.setDrawValues(false);
//        //区域文字的大小
//        data.setValueTextSize(11f);
//        //设置区域文字的颜色
//        data.setValueTextColor(Color.WHITE);
//        //设置区域文字的字体
//        data.setValueTypeface(Typeface.DEFAULT);

        pieChart.setData(data);

//        //设置是否显示区域文字内容
//        pieChart.setDrawSliceText(false);
//        //设置是否显示区域百分比的值
//        for (IDataSet<?> set : pieChart.getData().getDataSets()){
//            set.setDrawValues(true);
////            set.setDrawValues(!set.isDrawValuesEnabled());
//        }
        // undo all highlights
        pieChart.highlightValues(null);
        pieChart.invalidate();
    }
}
