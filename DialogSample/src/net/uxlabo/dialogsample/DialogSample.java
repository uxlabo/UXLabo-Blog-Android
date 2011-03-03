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
        
        // タイトルを非表示にする
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        // 線上配置レイアウトを生成する
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        
        // ダイアログ起動ボタンを生成
        Button button = new Button(this);
        button.setText("ダイアログ起動");
        button.setOnClickListener(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
        		LinearLayout.LayoutParams.WRAP_CONTENT,
        		LinearLayout.LayoutParams.WRAP_CONTENT);
        button.setLayoutParams(params);
        layout.addView(button);
        
        setContentView(layout);
    }
    
    // ボタンクリックイベントの処理
    public void onClick(View view) {
    	// ダイアログを表示
    	showDialog(this, "Dialog Sample", "ボタンがクリックされました!");
    }
    
    // ダイアログ表示用
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