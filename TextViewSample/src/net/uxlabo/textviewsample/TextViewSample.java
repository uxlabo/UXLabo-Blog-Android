package net.uxlabo.textviewsample;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TextViewSample extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // �^�C�g�����\��
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        // ����z�u���C�A�E�g�̐���
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setBackgroundColor(Color.WHITE);
        this.setContentView(layout);
        
        // TextView�𐶐�
        TextView textView1 = new TextView(this);
        textView1.setText("�f�t�H���g��TextView�ł��B");
        layout.addView(textView1);
        
        TextView textView2 = new TextView(this);
        textView2.setTextSize(16.0f);
        textView2.setText("�t�H���g�T�C�Y��ύX���Ă��܂��B");
        layout.addView(textView2);
        
        TextView textView3 = new TextView(this);
        textView3.setTextColor(Color.BLUE);
        textView3.setText("�O�i�F��ύX���Ă��܂��B");
        layout.addView(textView3);
        
        TextView textView4 = new TextView(this);
        textView4.setBackgroundColor(Color.CYAN);
        textView4.setText("�w�i�F��ύX���Ă��܂��B");
        layout.addView(textView4);
        
        TextView textView5 = new TextView(this);
        textView5.setTypeface(Typeface.create(Typeface.SERIF, Typeface.BOLD));
        textView5.setText("�����Ńt�H���g��ύX���Ă܂��B");
        layout.addView(textView5);
        
        setContentView(layout);
    }
}