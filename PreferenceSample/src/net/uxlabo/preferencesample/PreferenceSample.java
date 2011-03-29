package net.uxlabo.preferencesample;

import android.app.Activity;
import android.content.*;
import android.graphics.Color;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

/**
 * アクティビティ
 */
public class PreferenceSample extends Activity 
	implements View.OnClickListener {
	
	private final int 
		WRAP = LinearLayout.LayoutParams.WRAP_CONTENT,
		FILL = LinearLayout.LayoutParams.FILL_PARENT;
	// アクティビティ名
	private final String FILE_NAME = "Sample";
	
	// 書き込み用EditText
	private EditText writeEditText;
	// 書き込み用Button
	private Button writeButton;
	// 読み込み用TextView
	private EditText readEditText;
	// 読み込み用Button
	private Button readButton;
	// 削除用Button
	private Button removeButton;
						
    /**
     * 初期化処理を行います。
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // タイトルを非表示にする
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        // 線上配置レイアウトを生成
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);
        
        // 書き込み用EditTextを生成
        this.writeEditText = new EditText(this);
        this.writeEditText.setText("", EditText.BufferType.NORMAL);
        this.writeEditText.setLayoutParams(new LinearLayout.LayoutParams(FILL, WRAP));
        layout.addView(this.writeEditText);
        
        // 書き込み実行Buttonを生成
        this.writeButton = new Button(this);
        this.writeButton.setText("書き込み実行");
        this.writeButton.setLayoutParams(new LinearLayout.LayoutParams(WRAP, WRAP));
        this.writeButton.setOnClickListener(this);
        layout.addView(this.writeButton);
        
        // 読み込み用EditTextを生成
        this.readEditText = new EditText(this);
        this.readEditText.setLayoutParams(new LinearLayout.LayoutParams(FILL, WRAP));
        this.readEditText.setText("", EditText.BufferType.NORMAL);
        this.readEditText.setEnabled(false);
        this.readEditText.setTextColor(Color.WHITE);
        layout.addView(this.readEditText);
        
        // 読み込み用Buttonを生成
        this.readButton = new Button(this);
        this.readButton.setText("読み込み実行");
        this.readButton.setLayoutParams(new LinearLayout.LayoutParams(WRAP, WRAP));
        this.readButton.setOnClickListener(this);
        layout.addView(this.readButton);
        
        // 削除用Buttonを生成
        this.removeButton = new Button(this);
        this.removeButton.setText("削除");
        this.removeButton.setLayoutParams(new LinearLayout.LayoutParams(FILL, WRAP));
        this.removeButton.setOnClickListener(this);
        layout.addView(this.removeButton);
    }
    
    /**
     * ボタンがクリックされると呼び出されます。
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
     * プリファレンスへの書き込みを行います。
     * @param key プリファレンス書き込みキー
     * @param text プリファレンス書き込み文字列
     */
    private void writePreferenceText(String key, String text) {
    	// プリファレンス操作オブジェクトを取得
    	SharedPreferences preferences = this.getSharedPreferences(FILE_NAME, MODE_PRIVATE);
    	// プリファレンス操作エディタの取得
    	SharedPreferences.Editor editor = preferences.edit();
    	// プリファレンスへの書き込み
    	editor.putString(key, text);
    	editor.commit();
    }
    
    /**
     * プリファレンスから読み込みを行います。
     * @param key プリファレンス読み込みキー
     * @return keyと合致したプリファレンスに書き込まれている文字列
     */
    private String readPreferenceText(String key) {
    	// プリファレンス操作オブジェクトを取得
    	SharedPreferences preferences = this.getSharedPreferences(FILE_NAME, MODE_PRIVATE);
    	// プリファレンスから読み込み
    	return preferences.getString(key, "");
    }
    
    /**
     * プリファレンスから値を削除します。
     * @param key プリファレンス削除キー
     */
    private void removePreferenceText(String key) {
    	// プリファレンス操作オブジェクトを取得
    	SharedPreferences preferences = this.getSharedPreferences(FILE_NAME, MODE_PRIVATE);
    	// プリファレンス操作エディタの取得
    	SharedPreferences.Editor editor = preferences.edit();
    	// プリファレンスから削除
    	editor.remove(key);
    	editor.commit();
    }
}