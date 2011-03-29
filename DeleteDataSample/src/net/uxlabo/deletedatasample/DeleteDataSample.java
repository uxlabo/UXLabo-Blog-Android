package net.uxlabo.deletedatasample;

import android.app.*;
import android.content.*;
import android.database.sqlite.*;
import android.os.*;
import android.view.*;
import android.widget.*;

/**
 * �A�N�e�B�r�e�B
 */
public class DeleteDataSample extends Activity
	implements View.OnClickListener {

	private final static int 
		WRAP = LinearLayout.LayoutParams.WRAP_CONTENT;
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
        
        //�@�f�[�^�폜�p�{�^���𐶐�����
        Button button = new Button(this);
        button.setText("�f�[�^���폜");
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
    	this.database.delete(TABLE_NAME, "id=1", null);
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
			
			// �X�V�p�����f�[�^��o�^
			ContentValues values = new ContentValues();
			values.put("value", "�폜�f�[�^");
			database.insert(TABLE_NAME, null, values);
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