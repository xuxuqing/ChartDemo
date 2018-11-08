package demo.api.tps550.telpo.com.mywebviewapplication;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WebView web;
    private String data = "<p>\r\n\t　　生鲜超市可以购买到很多新鲜的蔬菜，受到广大消费者的青睐。可是<a name=\"创业致富网\">生鲜超市加盟</a>哪家好?其中乐家生鲜超市以提高人们生活品质为依归，坚持为客户提供高品质的生鲜产品和优质的生鲜服务，吸引了不少投资者的关注。那么加盟乐家生鲜超市怎么样?下面，随小编一起去了解一下吧。</p>\r\n<p style=\"text-align: center;\">\r\n\t<img alt=\"加盟乐家生鲜超市\" src=\"http://img.959.cn/7/2018/1017/20181017034025702.jpg\" style=\"border-width: 0px; border-style: solid;\" title=\"加盟乐家生鲜超市\" /></p>\r\n<p>\r\n\t　　乐家生鲜立足社区、服务全城、放眼全国，以&ldquo;安全、新鲜、便利、实惠&rdquo;为宗旨，公司大力开拓社区生鲜O2O模式和B2C生鲜电商业务，倾力打造中国人首选的社区生鲜品牌。经营的主产品有：蔬菜类、猪肉类、海鲜类、禽类、豆制品类、腌制品类、粉面类、烧腊类、水果类、调味品类等餐桌上的商品。加盟乐家生鲜超市公司自建有完善的物流系统，所有的产品全部统一配送，完全保证了产品质量的可控性，实现线上、线下的融合，做到真正的实体零售、电商平台、物流配送一体化。</p>\r\n<p>\r\n\t　　乐家生鲜&rdquo;的目标就是打造中国社区生鲜连锁第一品牌，扶持5000个千万级老板，解决40000个就业问题，为1000万户解决一站式厨房食材供应问题。加盟乐家生鲜超市零附加费，阳光加盟费用，打击隐形附加费用现象。60天动销模式，天天特价、月月活动、节日大促销，全面加大竞争力。加盟乐家生鲜超市1200SKU直供生鲜、水果、百货全方位满足家庭厨房需求，打造&ldquo;未来生鲜厨房模式&rdquo;。</p>\r\n<p style=\"text-align: center;\">\r\n\t<img alt=\"加盟乐家生鲜超市\" src=\"http://img.959.cn/7/2018/1017/20181017034158434.jpg\" style=\"border-width: 0px; border-style: solid;\" title=\"加盟乐家生鲜超市\" /></p>\r\n<p>\r\n\t　　以上就是小编给大家介绍的加盟乐家生鲜超市的相关信息，相信大家都有了一定的了解。加盟乐家生鲜超市门槛低、减少运营费用，用最少的钱开店。如果大家对乐家生鲜超市<a href=\"http://www.959.cn/\" target=\"_blank\"><strong>投资连锁项目</strong></a>感兴趣，想了解更多乐家生鲜超市相关信息，在下方留言即可面获取详细资料。<a href=\"http://www.959.cn/959kf.html\" target=\"_blank\"><strong>【免费领取成功创业秘诀请点击】</strong></a></p>\r\n";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        web = (WebView) findViewById(R.id.web);
        web.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.e("uuuuuuuuu","=="+url);
                if (!TextUtils.isEmpty(url) && data.contains(url)){
                    Toast.makeText(MainActivity.this,"跳转",Toast.LENGTH_SHORT).show();
                }
                view.loadUrl(url);
                return true;
            }


        });
        initWebViewSettings();

        data = data.replace("<img", "<img height=\"250px\"; width=\"100%\"");
        web.loadDataWithBaseURL(null,data, "text/html", "UTF-8",null);

        startActivity(new Intent(this,BarChartActivity.class));
    }

    private void initWebViewSettings() {
        WebSettings webSetting = web.getSettings();
        webSetting.setJavaScriptEnabled(true);
        webSetting.setJavaScriptCanOpenWindowsAutomatically(true);
        webSetting.setAllowFileAccess(true);
//        webSetting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSetting.setSupportZoom(false);
        webSetting.setBuiltInZoomControls(false);
        webSetting.setUseWideViewPort(true);
        webSetting.setSupportMultipleWindows(true);
        webSetting.setJavaScriptEnabled(true);
         webSetting.setLoadWithOverviewMode(true);
        webSetting.setAppCacheEnabled(true);
        // webSetting.setDatabaseEnabled(true);
        webSetting.setDomStorageEnabled(true);
        webSetting.setGeolocationEnabled(true);
        webSetting.setAppCacheMaxSize(Long.MAX_VALUE);
        // webSetting.setPageCacheCapacity(IX5WebSettings.DEFAULT_CACHE_CAPACITY);
        webSetting.setPluginState(WebSettings.PluginState.ON_DEMAND);
//         webSetting.setRenderPriority(WebSettings.RenderPriority.HIGH);
        webSetting.setCacheMode(WebSettings.LOAD_NO_CACHE);
//        webSetting.setBlockNetworkImage(true);

//		 this.getSettingsExtension().setPageCacheCapacity(IX5WebSettings.DEFAULT_CACHE_CAPACITY);//extension
        // settings 的设计
    }
}
