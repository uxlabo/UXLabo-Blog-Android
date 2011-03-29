package net.uxlabo.deletedatasample;

import android.app.*;
import android.content.*;
import android.database.sqlite.*;
import android.os.*;
import android.view.*;
import android.widget.*;

/**
 * アクティビティ
 */
public class DeleteDataSample extends Activity
	implements View.OnClickListener {

	private final static int 
		WRAP = LinearLayout.LayoutParams.WRAP_CONTENT;
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
        
        //　データ削除用ボタンを生成する
        Button button = new Button(this);
        button.setText("データを削除");
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
    	this.database.delete(TABLE_NAME, "id=1", null);
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
			
			// 更新用初期データを登録
			ContentValues values = new ContentValues();
			values.put("value", "削除データ");
			database.insert(TABLE_NAME, null, values);
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