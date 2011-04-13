package net.uxlabo.linearlayoutsample;

import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

/**
 * �A�N�e�B�r�e�B
 */
public class LinearLayoutSample extends Activity {
	private final int
		// �R���e���c���ɍ��킹��
		WRAP = LinearLayout.LayoutParams.WRAP_CONTENT,
		// ��ʕ��ɍ��킹��
		FILL = LinearLayout.LayoutParams.FILL_PARENT;
    /**
     * �������������s���܂��B
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // �^�C�g�����\���ɂ���
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        // �e����z�u���C�A�E�g�𐶐�����
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);
        
        // �c���їp���C�A�E�g�𐶐�����
        LinearLayout verticalLayout = new LinearLayout(this);
        verticalLayout.setOrientation(LinearLayout.VERTICAL);
        verticalLayout.setLayoutParams(new LinearLayout.LayoutParams(FILL, WRAP));
        layout.addView(verticalLayout);
        
        // �c���їp���C�A�E�g��Button��ǉ�
        verticalLayout.addView(this.createButton("�c����", WRAP, FILL));
        // �c���їp���C�A�E�g��RadioButon��ǉ�
        verticalLayout.addView(this.createRadioButton("�c����", WRAP, WRAP));
        // �c���їp���C�A�E�g��EditText��ǉ�
        verticalLayout.addView(this.createEditText("�c����", WRAP, WRAP));
        
        // �����їp���C�A�E�g�𐶐�����
        LinearLayout horizontalLayout = new LinearLayout(this);
        horizontalLayout.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(FILL, WRAP);
        params.setMargins(0, 50, 0, 0);
        horizontalLayout.setLayoutParams(params);
        layout.addView(horizontalLayout);
        
        // �����їp���C�A�E�g��Button��ǉ�
        horizontalLayout.addView(this.createButton("������", WRAP, WRAP));
        // �����їp���C�A�E�g��RadioButton��ǉ�
        horizontalLayout.addView(this.createRadioButton("������", WRAP, WRAP));
        // �����їp���C�A�E�g��EditText��ǉ�
        horizontalLayout.addView(this.createEditText("������", WRAP, WRAP));
    }
    
    /**
     * Button�𐶐����܂��B
     * @param text Button��Text
     * @param layoutWidth �����C�A�E�g
     * @param layoutHeight �c���C�A�E�g
     * @return Button�C���X�^���X
     */
    private Button createButton(String text, int layoutWidth, int layoutHeight) {
    	Button button = new Button(this);
    	button.setText(text);
    	button.setLayoutParams(new LinearLayout.LayoutParams(layoutWidth, layoutHeight));
    	return button;
    }
    
    /**
     * RadioButton�𐶐����܂��B
     * @param text RadioButton��Text
     * @param layoutWidth �����C�A�E�g
     * @param layoutHeight �c���C�A�E�g
     * @return
     */
    private RadioButton createRadioButton(String text, int layoutWidth, int layoutHeight) {
    	RadioButton radioButton = new RadioButton(this);
    	radioButton.setText(text);
    	radioButton.setChecked(true);
    	radioButton.setLayoutParams(new LinearLayout.LayoutParams(layoutWidth, layoutHeight));
    	return radioButton;
    }
    
    /**
     * EditText�𐶐����܂��B
     * @param text EditText��Text
     * @param layoutWidth �����C�A�E�g
     * @param layoutHeight �c���C�A�E�g
     * @return
     */
    private EditText createEditText(String text, int layoutWidth, int layoutHeight) {
    	EditText editText = new EditText(this);
    	editText.setText(text, EditText.BufferType.NORMAL);
    	editText.setLayoutParams(new LinearLayout.LayoutParams(layoutWidth, layoutHeight));
    	return editText;
    }
}