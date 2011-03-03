package net.uxlabo.buttonsample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.*;

public class ButtonSample extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // タイトルを非表示
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        // Buttonを生成
        Button button = new Button(this);
        button.setText("クリックして下さい");
        // ボタンがクリックされた時に呼び出されるコールバックリスナーと登録
        button.setOnClickListener(this);
        
        setContentView(button, 
        		new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
    }
    
    @Override
    public void onClick(View view)
    {
    	Button button = (Button)view;
    	button.setText("クリックされました！");
    }
}