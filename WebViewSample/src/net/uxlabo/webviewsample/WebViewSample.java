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
        
        // �^�C�g�����\��
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        // WebView�̐���
        WebView webView = new WebView(this);
        // assets�t�H���_����HTML��\���ꍇ
        webView.loadUrl("file:///android_asset/sample.html");
        // �l�b�g��HTML��\������ꍇ
        //webView.loadUrl("http://www.google.com");
        
        setContentView(webView);
    }
}