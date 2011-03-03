package net.uxlabo.checkboxsample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class CheckBoxSample extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // タイトルバーを非表示にする
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        // 線上配置レイアウトを生成する
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        
        // CheckBoxを生成する
        CheckBox checkBox1 = new CheckBox(this);
        checkBox1.setText("定期メールを受け取る");
        checkBox1.setChecked(true);
        layout.addView(checkBox1);
        
        CheckBox checkBox2 = new CheckBox(this);
        checkBox2.setText("迷惑メールを受け取る");
        checkBox2.setChecked(false);
        layout.addView(checkBox2);
        
        CheckBox checkBox3 = new CheckBox(this);
        checkBox3.setText("メルマガを受け取る");
        checkBox3.setChecked(true);
        layout.addView(checkBox3);
        
        setContentView(layout);
    }
}