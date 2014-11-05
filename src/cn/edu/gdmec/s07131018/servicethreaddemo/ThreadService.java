package cn.edu.gdmec.s07131018.servicethreaddemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class ThreadService extends Service {
	
	private Runnable Random = new Runnable() {
		public void run() {
			try{
				while(true){
			double random = Math.random();
			MainActivity.UpdateGUI(random);
			Thread.sleep(1000);
			}
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	};
	private Thread myThread;
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		myThread = new Thread(null,Random,"random");
		Toast.makeText(this, "service has create", 1000).show();
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		myThread.interrupt();
		Toast.makeText(this, "service has destroy", 1000).show();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "service has start", 1000).show();
		if(!myThread.isAlive()){
			myThread.start();
		}
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
