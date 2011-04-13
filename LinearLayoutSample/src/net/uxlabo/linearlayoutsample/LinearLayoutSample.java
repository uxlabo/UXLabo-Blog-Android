package net.uxlabo.linearlayoutsample;

import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

/**
 * アクティビティ
 */
public class LinearLayoutSample extends Activity {
	private final int
		// コンテンツ幅に合わせる
		WRAP = LinearLayout.LayoutParams.WRAP_CONTENT,
		// 画面幅に合わせる
		FILL = LinearLayout.LayoutParams.FILL_PARENT;
    /**
     * 初期化処理を行います。
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // タイトルを非表示にする
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        // 親線上配置レイアウトを生成する
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);
        
        // 縦並び用レイアウトを生成する
        LinearLayout verticalLayout = new LinearLayout(this);
        verticalLayout.setOrientation(LinearLayout.VERTICAL);
        verticalLayout.setLayoutParams(new LinearLayout.LayoutParams(FILL, WRAP));
        layout.addView(verticalLayout);
        
        // 縦並び用レイアウトにButtonを追加
        verticalLayout.addView(this.createButton("縦方向", WRAP, FILL));
        // 縦並び用レイアウトにRadioButonを追加
        verticalLayout.addView(this.createRadioButton("縦方向", WRAP, WRAP));
        // 縦並び用レイアウトにEditTextを追加
        verticalLayout.addView(this.createEditText("縦方向", WRAP, WRAP));
        
        // 横並び用レイアウトを生成する
        LinearLayout horizontalLayout = new LinearLayout(this);
        horizontalLayout.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(FILL, WRAP);
        params.setMargins(0, 50, 0, 0);
        horizontalLayout.setLayoutParams(params);
        layout.addView(horizontalLayout);
        
        // 横並び用レイアウトにButtonを追加
        horizontalLayout.addView(this.createButton("横方向", WRAP, WRAP));
        // 横並び用レイアウトにRadioButtonを追加
        horizontalLayout.addView(this.createRadioButton("横方向", WRAP, WRAP));
        // 横並び用レイアウトにEditTextを追加
        horizontalLayout.addView(this.createEditText("横方向", WRAP, WRAP));
    }
    
    /**
     * Buttonを生成します。
     * @param text ButtonのText
     * @param layoutWidth 横レイアウト
     * @param layoutHeight 縦レイアウト
     * @return Buttonインスタンス
     */
    private Button createButton(String text, int layoutWidth, int layoutHeight) {
    	Button button = new Button(this);
    	button.setText(text);
    	button.setLayoutParams(new LinearLayout.LayoutParams(layoutWidth, layoutHeight));
    	return button;
    }
    
    /**
     * RadioButtonを生成します。
     * @param text RadioButtonのText
     * @param layoutWidth 横レイアウト
     * @param layoutHeight 縦レイアウト
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
     * EditTextを生成します。
     * @param text EditTextのText
     * @param layoutWidth 横レイアウト
     * @param layoutHeight 縦レイアウト
     * @return
     */
    private EditText createEditText(String text, int layoutWidth, int layoutHeight) {
    	EditText editText = new EditText(this);
    	editText.setText(text, EditText.BufferType.NORMAL);
    	editText.setLayoutParams(new LinearLayout.LayoutParams(layoutWidth, layoutHeight));
    	return editText;
    }
}