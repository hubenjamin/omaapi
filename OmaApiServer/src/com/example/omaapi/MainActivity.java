package com.example.omaapi;

import com.example.omaapi.OmaApiService.HttpListener;
import com.example.omaapi.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static HttpListener httpd = null;
	private static Intent service = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Context context = getBaseContext();

    	if (httpd == null) {
    		service = new Intent(context, OmaApiService.class);
      		context.startService(service); 
    	}

    	setContentView(R.layout.activity_main);
        Toast toast = Toast.makeText(getBaseContext(), 
        		"OMA API server is started,\n listening on http://localhost:4035", Toast.LENGTH_LONG);
        toast.show();
	}
	
	@Override
	protected void onResume() {
         super.onResume();
		 moveTaskToBack(true);
	}

	@Override
	protected void onDestroy() {
		if (httpd != null) stopService(service);
        super.onDestroy();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
