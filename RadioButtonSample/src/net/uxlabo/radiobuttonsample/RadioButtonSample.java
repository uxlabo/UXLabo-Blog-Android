package net.uxlabo.radiobuttonsample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class RadioButtonSample extends Activity {
	// 配置要素に合わせてサイジングする。
	static final int FP = LinearLayout.LayoutParams.WRAP_CONTENT;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // タイトルを非表示にする。
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        // 線上配置レイアウトを生成する。
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        
        // 配置パラメータを生成
        LinearLayout.LayoutParams params = 
        	new LinearLayout.LayoutParams(FP, FP);
        params.setMargins(0, 0, 0, 20);
        
        // RadioGroup(Group1)を生成する。
        RadioGroup group1 = new RadioGroup(this);
        group1.setLayoutParams(params);
        layout.addView(group1);
        
        // Group1のRadioButtonを生成する。
        RadioButton radioButton1 = new RadioButton(this);
        radioButton1.setText("男");
        radioButton1.setId(1);
        radioButton1.setChecked(true);
        group1.addView(radioButton1);
        
        RadioButton radioButton2 = new RadioButton(this);
        radioButton2.setText("女");
        radioButton2.setId(2);
        group1.addView(radioButton2);
        
        // RadioGroup(Group2)を生成する
        RadioGroup group2 = new RadioGroup(this);
        group2.setLayoutParams(params);
        layout.addView(group2);
        
        // Group2のRadioButtonを生成する
        RadioButton radioButton3 = new RadioButton(this);
        radioButton3.setText("オプションを希望する");
        radioButton3.setId(1);
        group2.addView(radioButton3);
        group2.getCheckedRadioButtonId()
        
        RadioButton radioButton4 = new RadioButton(this);
        radioButton4.setText("オプションを希望しない");
        radioButton4.setId(2);
        radioButton4.setChecked(true);
        group2.addView(radioButton4);
        
        setContentView(layout);
    }
}