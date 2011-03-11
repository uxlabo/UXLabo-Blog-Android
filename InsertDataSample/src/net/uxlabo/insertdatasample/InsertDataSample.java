package net.uxlabo.insertdatasample;

import android.app.*;
import android.content.*;
import android.database.sqlite.*;
import android.os.*;
import android.view.*;
import android.widget.*;

/**
 * �A�N�e�B�r�e�B
 */
public class InsertDataSample extends Activity
	implements View.OnClickListener {

	private final static int 
		WRAP = LinearLayout.LayoutParams.WRAP_CONTENT,
		FILL = LinearLayout.LayoutParams.FILL_PARENT;
	private EditText editText;
	// �f�[�^�x�[�X�I�u�W�F�N�g
	private SQLiteDatabase database;
	//�@�f�[�^�x�[�X��
	private final static String DB_NAME = "sample.db";
	//�@�e�[�u����
	private final static String TABLE_NAME = "SampleTable";
	

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //�@�^�C�g�����\���ɂ���
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        // ����z�u���C�A�E�g�𐶐�����
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);

        // �f�[�^�ݒ�pEditText�𐶐�����
        this.editText = new EditText(this);
        this.editText.setText("", EditText.BufferType.NORMAL);
        this.editText.setLayoutParams(new LinearLayout.LayoutParams(FILL, WRAP));
        layout.addView(editText);
        
        //�@�f�[�^�}���p�{�^���𐶐�����
        Button button = new Button(this);
        button.setText("�f�[�^��}��");
        button.setOnClickListener(this);
        button.setLayoutParams(new LinearLayout.LayoutParams(WRAP, WRAP));
        layout.addView(button);
        
        // �f�[�^�x�[�X�̏�����
        DatabaseHelper helper = new DatabaseHelper(this);
    	this.database = helper.getWritableDatabase();
    }

    /**
     * �{�^�����N���b�N�����ƌĂяo����܂��B
     */
    @Override
    public void onClick(View view) {
    	ContentValues values = new ContentValues();
    	values.put("value", this.editText.getText().toString());
    	this.database.insert(TABLE_NAME, "", values);
    }

    /**
     * SQLite����p�w���p�[�N���X�B
     */
    private class DatabaseHelper extends SQLiteOpenHelper {
    	/**
    	 * �R���X�g���N�^
    	 * @param context �R���e�L�X�g���Z�b�g�B
    	 */
    	public DatabaseHelper(Context context) {
    		super(context, DB_NAME, null, 1);
    	}

    	/**
    	 * �f�[�^�x�[�X�������ɌĂяo����܂��B
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
		 * �f�[�^�x�[�X�̍X�V���ɌĂяo����܂��B
		 */
		@Override
		public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
			// ����͉������Ȃ��B
		}
    }
}