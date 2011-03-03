package net.uxlabo.dialogsample;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;

public class DialogSample extends Activity
	implements OnClickListener
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // �^�C�g�����\���ɂ���
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        // ����z�u���C�A�E�g�𐶐�����
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        
        // �_�C�A���O�N���{�^���𐶐�
        Button button = new Button(this);
        button.setText("�_�C�A���O�N��");
        button.setOnClickListener(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
        		LinearLayout.LayoutParams.WRAP_CONTENT,
        		LinearLayout.LayoutParams.WRAP_CONTENT);
        button.setLayoutParams(params);
        layout.addView(button);
        
        setContentView(layout);
    }
    
    // �{�^���N���b�N�C�x���g�̏���
    public void onClick(View view) {
    	// �_�C�A���O��\��
    	showDialog(this, "Dialog Sample", "�{�^�����N���b�N����܂���!");
    }
    
    // �_�C�A���O�\���p
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