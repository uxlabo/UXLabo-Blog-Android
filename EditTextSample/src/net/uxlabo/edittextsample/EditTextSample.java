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
	
	// エディットテキスト
	private EditText text;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // タイトルを非表示にする
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        // 線上配置レイアウトを生成する
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        
        // エディットテキストを生成する
        this.text = new EditText(this);
        this.text.setText("文字を入力して下さい。");
        setLayoutParams(text, 
        		LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layout.addView(this.text);
        
        // エディットテキスト文字確認ボタンを生成する
        Button button = new Button(this);
        button.setText("入力テキストを確認", EditText.BufferType.NORMAL);
        button.setOnClickListener(this);
        setLayoutParams(button,
        		LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layout.addView(button);
        
        setContentView(layout);
    }
    
    @Override
    public void onClick(View view) {
    	showDialog(this, "入力文字確認", 
    			"「" + this.text.getText().toString() + "」と入力されています。");
    }
    
    // レイアウト設定
    private static void setLayoutParams(View view, int width, int height) {
    	view.setLayoutParams(new LinearLayout.LayoutParams(width, height));
    }
    
    // ダイアログ表示
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