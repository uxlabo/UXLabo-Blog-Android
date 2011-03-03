package net.uxlabo.imageviewsample;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ImageViewSample extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // タイトルを非表示にする
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        // リソースを取得するしてBitmapを生成する
        Resources resource = this.getResources();
        Bitmap bitmap = BitmapFactory.decodeResource(resource, R.drawable.sample);
        
        // ImageViewを生成する
        ImageView image = new ImageView(this);
        image.setImageBitmap(bitmap);
        
        setContentView(image, 
        		new LinearLayout.LayoutParams(
        				LinearLayout.LayoutParams.WRAP_CONTENT, 
        				LinearLayout.LayoutParams.WRAP_CONTENT));
    }
}