package net.uxlabo.preferencesample;

import android.app.Activity;
import android.content.*;
import android.graphics.Color;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

/**
 * �A�N�e�B�r�e�B
 */
public class PreferenceSample extends Activity 
	implements View.OnClickListener {
	
	private final int 
		WRAP = LinearLayout.LayoutParams.WRAP_CONTENT,
		FILL = LinearLayout.LayoutParams.FILL_PARENT;
	// �A�N�e�B�r�e�B��
	private final String FILE_NAME = "Sample";
	
	// �������ݗpEditText
	private EditText writeEditText;
	// �������ݗpButton
	private Button writeButton;
	// �ǂݍ��ݗpTextView
	private EditText readEditText;
	// �ǂݍ��ݗpButton
	private Button readButton;
	// �폜�pButton
	private Button removeButton;
						
    /**
     * �������������s���܂��B
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // �^�C�g�����\���ɂ���
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        // ����z�u���C�A�E�g�𐶐�
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);
        
        // �������ݗpEditText�𐶐�
        this.writeEditText = new EditText(this);
        this.writeEditText.setText("", EditText.BufferType.NORMAL);
        this.writeEditText.setLayoutParams(new LinearLayout.LayoutParams(FILL, WRAP));
        layout.addView(this.writeEditText);
        
        // �������ݎ��sButton�𐶐�
        this.writeButton = new Button(this);
        this.writeButton.setText("�������ݎ��s");
        this.writeButton.setLayoutParams(new LinearLayout.LayoutParams(WRAP, WRAP));
        this.writeButton.setOnClickListener(this);
        layout.addView(this.writeButton);
        
        // �ǂݍ��ݗpEditText�𐶐�
        this.readEditText = new EditText(this);
        this.readEditText.setLayoutParams(new LinearLayout.LayoutParams(FILL, WRAP));
        this.readEditText.setText("", EditText.BufferType.NORMAL);
        this.readEditText.setEnabled(false);
        this.readEditText.setTextColor(Color.WHITE);
        layout.addView(this.readEditText);
        
        // �ǂݍ��ݗpButton�𐶐�
        this.readButton = new Button(this);
        this.readButton.setText("�ǂݍ��ݎ��s");
        this.readButton.setLayoutParams(new LinearLayout.LayoutParams(WRAP, WRAP));
        this.readButton.setOnClickListener(this);
        layout.addView(this.readButton);
        
        // �폜�pButton�𐶐�
        this.removeButton = new Button(this);
        this.removeButton.setText("�폜");
        this.removeButton.setLayoutParams(new LinearLayout.LayoutParams(FILL, WRAP));
        this.removeButton.setOnClickListener(this);
        layout.addView(this.removeButton);
    }
    
    /**
     * �{�^�����N���b�N�����ƌĂяo����܂��B
     */
    @Override
    public void onClick(View view) {
    	if (view == this.writeButton) {
    		this.writePreferenceText("text", this.writeEditText.getText().toString());
    	} else if (view == this.readButton) {
    		this.readEditText.setText(this.readPreferenceText("text"), EditText.BufferType.NORMAL);
    	} else if (view == this.removeButton) {
    		this.removePreferenceText("text");
    	}
    }
    
    /**
     * �v���t�@�����X�ւ̏������݂��s���܂��B
     * @param key �v���t�@�����X�������݃L�[
     * @param text �v���t�@�����X�������ݕ�����
     */
    private void writePreferenceText(String key, String text) {
    	// �v���t�@�����X����I�u�W�F�N�g���擾
    	SharedPreferences preferences = this.getSharedPreferences(FILE_NAME, MODE_PRIVATE);
    	// �v���t�@�����X����G�f�B�^�̎擾
    	SharedPreferences.Editor editor = preferences.edit();
    	// �v���t�@�����X�ւ̏�������
    	editor.putString(key, text);
    	editor.commit();
    }
    
    /**
     * �v���t�@�����X����ǂݍ��݂��s���܂��B
     * @param key �v���t�@�����X�ǂݍ��݃L�[
     * @return key�ƍ��v�����v���t�@�����X�ɏ������܂�Ă��镶����
     */
    private String readPreferenceText(String key) {
    	// �v���t�@�����X����I�u�W�F�N�g���擾
    	SharedPreferences preferences = this.getSharedPreferences(FILE_NAME, MODE_PRIVATE);
    	// �v���t�@�����X����ǂݍ���
    	return preferences.getString(key, "");
    }
    
    /**
     * �v���t�@�����X����l���폜���܂��B
     * @param key �v���t�@�����X�폜�L�[
     */
    private void removePreferenceText(String key) {
    	// �v���t�@�����X����I�u�W�F�N�g���擾
    	SharedPreferences preferences = this.getSharedPreferences(FILE_NAME, MODE_PRIVATE);
    	// �v���t�@�����X����G�f�B�^�̎擾
    	SharedPreferences.Editor editor = preferences.edit();
    	// �v���t�@�����X����폜
    	editor.remove(key);
    	editor.commit();
    }
}