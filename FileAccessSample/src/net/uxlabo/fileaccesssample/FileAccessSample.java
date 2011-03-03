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
	private final static String FILE_NAME = "sample.txt"; //ファイル名
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //タイトルを非表示にする
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        //線上配置レイアウトを生成する
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);

        //EditTextを生成する
        this.editText = new EditText(this);
        this.editText.setText("", EditText.BufferType.NORMAL);
        this.editText.setLayoutParams(new LinearLayout.LayoutParams(FILL, WRAP));
        layout.addView(this.editText);
        
        //ボタン用線上レイアウトを生成する
        LinearLayout buttonLayout = new LinearLayout(this);
        buttonLayout.setOrientation(LinearLayout.HORIZONTAL);
        buttonLayout.setLayoutParams(new LinearLayout.LayoutParams(FILL, WRAP));
        layout.addView(buttonLayout);
        
        //書き込みボタンを生成する
        Button writeButton = new Button(this);
        writeButton.setId(WRITE);
        writeButton.setText("書き込み");
        writeButton.setLayoutParams(new LinearLayout.LayoutParams(800, WRAP, 1));
        writeButton.setOnClickListener(this);
        buttonLayout.addView(writeButton);
        
        //読み込みボタンを生成する
        Button readButton = new Button(this);
        readButton.setId(READ);
        readButton.setText("読み込み");
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
    				showDialog(this, "Error", "ファイル書き込み時にエラーが発生しました。");
    			}
    		case READ:
    			try {
    				String text = readText();
    				this.editText.setText(text);
    			} catch (Exception e) {
    				showDialog(this, "Error", "ファイル読み込み時にエラーが発生しました。");
    			}
    	};
    }
    
    //ファイルにテキストを書き込みます。
    private void writeText(String text) throws Exception {
    	FileOutputStream stream = null;
    	try {
    		//ストリームをオープン
    		stream = this.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
    		//ファイルに書き込み
    		stream.write(text.getBytes());
    		//ストリームをクローズ
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
    
    //ファイルからテキストを読み込みます。
    private String readText() throws Exception {
    	FileInputStream stream = null;
    	try {
    		//ストリームをオープン
    		stream = this.openFileInput(FILE_NAME);
    		//テキストを読み込む
    		byte[] bytes = new byte[stream.available()];
    		stream.read(bytes);
    		//ストリームを閉じる
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
    
    //ダイアログ表示
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