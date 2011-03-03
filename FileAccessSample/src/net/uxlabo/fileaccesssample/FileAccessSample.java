package net.uxlabo.fileaccesssample;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import java.io.*;

public class FileAccessSample extends Activity
	implements View.OnClickListener {
	private final static int 
		FILL = LinearLayout.LayoutParams.FILL_PARENT,
		WRAP = LinearLayout.LayoutParams.WRAP_CONTENT,
		WRITE = 0,
		READ = 1;
	private EditText editText;
	private final static String FILE_NAME = "sample.txt"; //�t�@�C����
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //�^�C�g�����\���ɂ���
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        //����z�u���C�A�E�g�𐶐�����
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);

        //EditText�𐶐�����
        this.editText = new EditText(this);
        this.editText.setText("", EditText.BufferType.NORMAL);
        this.editText.setLayoutParams(new LinearLayout.LayoutParams(FILL, WRAP));
        layout.addView(this.editText);
        
        //�{�^���p���ヌ�C�A�E�g�𐶐�����
        LinearLayout buttonLayout = new LinearLayout(this);
        buttonLayout.setOrientation(LinearLayout.HORIZONTAL);
        buttonLayout.setLayoutParams(new LinearLayout.LayoutParams(FILL, WRAP));
        layout.addView(buttonLayout);
        
        //�������݃{�^���𐶐�����
        Button writeButton = new Button(this);
        writeButton.setId(WRITE);
        writeButton.setText("��������");
        writeButton.setLayoutParams(new LinearLayout.LayoutParams(800, WRAP, 1));
        writeButton.setOnClickListener(this);
        buttonLayout.addView(writeButton);
        
        //�ǂݍ��݃{�^���𐶐�����
        Button readButton = new Button(this);
        readButton.setId(READ);
        readButton.setText("�ǂݍ���");
        readButton.setLayoutParams(new LinearLayout.LayoutParams(800, WRAP, 1));
        readButton.setOnClickListener(this);
        buttonLayout.addView(readButton);
    }
    
    @Override
    public void onClick(View view) {
    	switch (view.getId()) {
    		case WRITE:
    			try {
    				writeText(this.editText.getText().toString());
    			} catch (Exception e) {
    				showDialog(this, "Error", "�t�@�C���������ݎ��ɃG���[���������܂����B");
    			}
    		case READ:
    			try {
    				String text = readText();
    				this.editText.setText(text);
    			} catch (Exception e) {
    				showDialog(this, "Error", "�t�@�C���ǂݍ��ݎ��ɃG���[���������܂����B");
    			}
    	};
    }
    
    //�t�@�C���Ƀe�L�X�g���������݂܂��B
    private void writeText(String text) throws Exception {
    	FileOutputStream stream = null;
    	try {
    		//�X�g���[�����I�[�v��
    		stream = this.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
    		//�t�@�C���ɏ�������
    		stream.write(text.getBytes());
    		//�X�g���[�����N���[�Y
    	} catch (Exception e) {
    		try {
        		if (stream != null) {
        			stream.close();
        		}
    		} catch (Exception e2) {
    		}
    		throw e;
    	}
    }
    
    //�t�@�C������e�L�X�g��ǂݍ��݂܂��B
    private String readText() throws Exception {
    	FileInputStream stream = null;
    	try {
    		//�X�g���[�����I�[�v��
    		stream = this.openFileInput(FILE_NAME);
    		//�e�L�X�g��ǂݍ���
    		byte[] bytes = new byte[stream.available()];
    		stream.read(bytes);
    		//�X�g���[�������
    		stream.close();
    		return new String(bytes);
    	} catch (Exception e) {
    		try {
    			if (stream != null) {
    				stream.close();
    			}
    		} catch (Exception e2) {
    		}
    		throw e;
    	}
    }
    
    //�_�C�A���O�\��
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