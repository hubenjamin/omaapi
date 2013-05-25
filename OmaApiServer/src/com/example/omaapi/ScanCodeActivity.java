package com.example.omaapi;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

import com.example.omaapi.R;
import com.google.zxing.integration.android.*;

public class ScanCodeActivity extends Activity {
	
	private OmaApiService apiService;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
    	IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.initiateScan();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanResult != null) {
          // handle scan result
//          apiService.httpd.scanResult(scanResult.toString());
          apiService.httpd.scanResult(scanResult.getContents());
        }
        moveTaskToBack(true);
        finish();
    }

	@Override
	protected void onDestroy() {
        super.onDestroy();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
