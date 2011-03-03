package net.uxlabo.imagebuttonsample;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class ImageButtonSample extends Activity 
	implements OnClickListener{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // �^�C�g�����\���ɂ���
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        // ���\�[�X���擾��Bitmap�𐶐�����
        Resources resource = this.getResources();
        Bitmap bitmap = BitmapFactory.decodeResource(resource, R.drawable.sample);
        
        // ImageButton�𐶐�����
        ImageButton button = new ImageButton(this);
        button.setImageBitmap(bitmap);
        button.setOnClickListener(this);
        
        setContentView(button, new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT, 
				LinearLayout.LayoutParams.WRAP_CONTENT));
    }
    
    // �{�^���N���b�N���̃n���h���[
    public void onClick(View view) {
    	showDialog(this, "ImageButton Sample", "�{�^�����N���b�N����܂����I");
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