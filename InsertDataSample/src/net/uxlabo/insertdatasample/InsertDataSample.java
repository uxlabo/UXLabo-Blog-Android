package net.uxlabo.insertdatasample;

import android.app.*;
import android.content.*;
import android.database.sqlite.*;
import android.os.*;
import android.view.*;
import android.widget.*;

/**
 * アクティビティ
 */
public class InsertDataSample extends Activity
	implements View.OnClickListener {

	private final static int 
		WRAP = LinearLayout.LayoutParams.WRAP_CONTENT,
		FILL = LinearLayout.LayoutParams.FILL_PARENT;
	private EditText editText;
	// データベースオブジェクト
	private SQLiteDatabase database;
	//　データベース名
	private final static String DB_NAME = "sample.db";
	//　テーブル名
	private final static String TABLE_NAME = "SampleTable";
	

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //　タイトルを非表示にする
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        // 線上配置レイアウトを生成する
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);

        // データ設定用EditTextを生成する
        this.editText = new EditText(this);
        this.editText.setText("", EditText.BufferType.NORMAL);
        this.editText.setLayoutParams(new LinearLayout.LayoutParams(FILL, WRAP));
        layout.addView(editText);
        
        //　データ挿入用ボタンを生成する
        Button button = new Button(this);
        button.setText("データを挿入");
        button.setOnClickListener(this);
        button.setLayoutParams(new LinearLayout.LayoutParams(WRAP, WRAP));
        layout.addView(button);
        
        // データベースの初期化
        DatabaseHelper helper = new DatabaseHelper(this);
    	this.database = helper.getWritableDatabase();
    }

    /**
     * ボタンがクリックされると呼び出されます。
     */
    @Override
    public void onClick(View view) {
    	ContentValues values = new ContentValues();
    	values.put("value", this.editText.getText().toString());
    	this.database.insert(TABLE_NAME, "", values);
    }

    /**
     * SQLite操作用ヘルパークラス。
     */
    private class DatabaseHelper extends SQLiteOpenHelper {
    	/**
    	 * コンストラクタ
    	 * @param context コンテキストをセット。
    	 */
    	public DatabaseHelper(Context context) {
    		super(context, DB_NAME, null, 1);
    	}

    	/**
    	 * データベース生成時に呼び出されます。
    	 */
		@Override
		public void onCreate(SQLiteDatabase database) {
			StringBuilder builder = new StringBuilder();
			builder.append("create table " + TABLE_NAME + "(");
			builder.append("id integer primary key autoincrement not null,");
			builder.append("value text");
			builder.append(")");

			database.execSQL(builder.toString());
		}

		/**
		 * データベースの更新時に呼び出されます。
		 */
		@Override
		public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
			// 今回は何もしない。
		}
    }
}