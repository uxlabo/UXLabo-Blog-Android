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
        
        // �^�C�g�����\���ɂ���
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        // MapView�̐���
        MapView mapView = new MapView(this, KEY);
        mapView.setClickable(true);
        
        // MapController�̐���
        MapController controller = mapView.getController();
        // �\������n�}�̍��W��ݒ肷��B�i����͓s���j
        controller.setCenter(new GeoPoint(
        		(int)(35.689185*1E6),
        		(int)(139.691648*1E6)));
        controller.setZoom(16);
        
        setContentView(mapView);
    }

    // ���[�g�\��
	@Override
	protected boolean isRouteDisplayed() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return false;
	}
}