package net.uxlabo.edittextsample;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class EditTextSample extends Activity 
	implements View.OnClickListener {
	
	// �G�f�B�b�g�e�L�X�g
	private EditText text;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // �^�C�g�����\���ɂ���
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        // ����z�u���C�A�E�g�𐶐�����
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        
        // �G�f�B�b�g�e�L�X�g�𐶐�����
        this.text = new EditText(this);
        this.text.setText("��������͂��ĉ������B");
        setLayoutParams(text, 
        		LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layout.addView(this.text);
        
        // �G�f�B�b�g�e�L�X�g�����m�F�{�^���𐶐�����
        Button button = new Button(this);
        button.setText("���̓e�L�X�g���m�F", EditText.BufferType.NORMAL);
        button.setOnClickListener(this);
        setLayoutParams(button,
        		LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layout.addView(button);
        
        setContentView(layout);
    }
    
    @Override
    public void onClick(View view) {
    	showDialog(this, "���͕����m�F", 
    			"�u" + this.text.getText().toString() + "�v�Ɠ��͂���Ă��܂��B");
    }
    
    // ���C�A�E�g�ݒ�
    private static void setLayoutParams(View view, int width, int height) {
    	view.setLayoutParams(new LinearLayout.LayoutParams(width, height));
    }
    
    // �_�C�A���O�\��
    private static void showDialog(final Activity activity, String title, String text) {
    	AlertDialog.Builder builder = new AlertDialog.Builder(activity);
    	builder.setTitle(title);
    	builder.setMessage(text);
    	builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				activity.setResult(Activity.RESULT_OK);
			}
		});
    	builder.create();
    	builder.show();
    }
}