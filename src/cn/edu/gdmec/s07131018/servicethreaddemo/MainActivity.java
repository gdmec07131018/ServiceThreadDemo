package cn.edu.gdmec.s07131018.servicethreaddemo;

import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	private static TextView tv;
	private Intent intent = new Intent("cn.edu.gdmec.serviceThreadDemo");
	private static Handler handler = new Handler();
	private static double random = 0; 
	private static Runnable update = new Runnable() {
		
		@Override
		public void run() {
			tv.setText(String.valueOf(random));
		}
	};
	public static void UpdateGUI(double myRandom){
		random = myRandom;
		handler.post(update);
	}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void start(View view){
    	startService(intent);
    }
    public void stop(View view){
    	stopService(intent);
    }
    
}
