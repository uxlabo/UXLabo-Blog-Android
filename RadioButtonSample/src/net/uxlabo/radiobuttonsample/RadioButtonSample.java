package net.uxlabo.radiobuttonsample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class RadioButtonSample extends Activity {
	// �z�u�v�f�ɍ��킹�ăT�C�W���O����B
	static final int FP = LinearLayout.LayoutParams.WRAP_CONTENT;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // �^�C�g�����\���ɂ���B
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        // ����z�u���C�A�E�g�𐶐�����B
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        
        // �z�u�p�����[�^�𐶐�
        LinearLayout.LayoutParams params = 
        	new LinearLayout.LayoutParams(FP, FP);
        params.setMargins(0, 0, 0, 20);
        
        // RadioGroup(Group1)�𐶐�����B
        RadioGroup group1 = new RadioGroup(this);
        group1.setLayoutParams(params);
        layout.addView(group1);
        
        // Group1��RadioButton�𐶐�����B
        RadioButton radioButton1 = new RadioButton(this);
        radioButton1.setText("�j");
        radioButton1.setId(1);
        radioButton1.setChecked(true);
        group1.addView(radioButton1);
        
        RadioButton radioButton2 = new RadioButton(this);
        radioButton2.setText("��");
        radioButton2.setId(2);
        group1.addView(radioButton2);
        
        // RadioGroup(Group2)�𐶐�����
        RadioGroup group2 = new RadioGroup(this);
        group2.setLayoutParams(params);
        layout.addView(group2);
        
        // Group2��RadioButton�𐶐�����
        RadioButton radioButton3 = new RadioButton(this);
        radioButton3.setText("�I�v�V��������]����");
        radioButton3.setId(1);
        group2.addView(radioButton3);
        group2.getCheckedRadioButtonId()
        
        RadioButton radioButton4 = new RadioButton(this);
        radioButton4.setText("�I�v�V��������]���Ȃ�");
        radioButton4.setId(2);
        radioButton4.setChecked(true);
        group2.addView(radioButton4);
        
        setContentView(layout);
    }
}