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
        
        // �^�C�g���o�[���\���ɂ���
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        // ����z�u���C�A�E�g�𐶐�����
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        
        // CheckBox�𐶐�����
        CheckBox checkBox1 = new CheckBox(this);
        checkBox1.setText("������[�����󂯎��");
        checkBox1.setChecked(true);
        layout.addView(checkBox1);
        
        CheckBox checkBox2 = new CheckBox(this);
        checkBox2.setText("���f���[�����󂯎��");
        checkBox2.setChecked(false);
        layout.addView(checkBox2);
        
        CheckBox checkBox3 = new CheckBox(this);
        checkBox3.setText("�����}�K���󂯎��");
        checkBox3.setChecked(true);
        layout.addView(checkBox3);
        
        setContentView(layout);
    }
}