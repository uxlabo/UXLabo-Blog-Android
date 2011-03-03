package net.uxlabo.webviewsample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebView;

public class WebViewSample extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // タイトルを非表示
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        // WebViewの生成
        WebView webView = new WebView(this);
        // assetsフォルダ内のHTMLを表示場合
        webView.loadUrl("file:///android_asset/sample.html");
        // ネットのHTMLを表示する場合
        //webView.loadUrl("http://www.google.com");
        
        setContentView(webView);
    }
}