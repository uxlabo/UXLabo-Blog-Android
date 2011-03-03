package net.uxlabo.mapviewsample;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import android.os.Bundle;
import android.view.Window;

public class MapViewSample extends MapActivity {
	// Android Maps API
	private final static String KEY = "";
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // タイトルを非表示にする
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        // MapViewの生成
        MapView mapView = new MapView(this, KEY);
        mapView.setClickable(true);
        
        // MapControllerの生成
        MapController controller = mapView.getController();
        // 表示する地図の座標を設定する。（今回は都庁）
        controller.setCenter(new GeoPoint(
        		(int)(35.689185*1E6),
        		(int)(139.691648*1E6)));
        controller.setZoom(16);
        
        setContentView(mapView);
    }

    // ルート表示
	@Override
	protected boolean isRouteDisplayed() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}
}