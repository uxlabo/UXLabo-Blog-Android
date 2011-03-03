package net.uxlabo.optionmenusample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;

public class OptionMenuSample extends Activity {
	// ����z�u���C�A�E�g
	private LinearLayout layout;
	// �I�v�V�������j���[�A�C�e�����ʗp
	private static final int
		MENU_ADD = 0,
		MENU_DELETE = 1;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // �^�C�g�����\���ɂ���
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
       
        this.layout = new LinearLayout(this);
        this.layout.setOrientation(LinearLayout.VERTICAL);
        
        setContentView(layout);
    }
    
    // �I�v�V�������j���[�A�C�e���𐶐����܂��B
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	super.onCreateOptionsMenu(menu);
    	
    	// MenuItem�̐���
    	MenuItem addItem = menu.add(0, MENU_ADD, 0, "�ǉ�");
    	addItem.setIcon(android.R.drawable.ic_menu_add);
    	
    	MenuItem deleteItem = menu.add(0, MENU_DELETE, 0, "�폜");
    	deleteItem.setIcon(android.R.drawable.ic_menu_delete);
    	
    	return true;
    }
    
    // �I�v�V�������j���[���I�������ƌĂяo����܂��B
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
    	case MENU_ADD:
    		if (this.layout.getChildCount() == 0) {
    			Button button = new Button(this);
    			button.setText("Button");
    			button.setLayoutParams(
    					new LinearLayout.LayoutParams(
    							LinearLayout.LayoutParams.WRAP_CONTENT,
    							LinearLayout.LayoutParams.WRAP_CONTENT));
    			this.layout.addView(button);
    		}
    		return true;
    	case MENU_DELETE:
    		if (this.layout.getChildCount() == 1) {
    			this.layout.removeViewAt(0);
    		}
    		return true;
    	}
    	return true;
    }
}