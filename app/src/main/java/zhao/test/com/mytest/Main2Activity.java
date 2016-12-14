package zhao.test.com.mytest;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import zhao.test.com.mytest.Bean.News;

public class Main2Activity extends AppCompatActivity {

	private long start_time;
	private CountService.MyBinder binder;
	//	创建服务连接（重写两个方法Activity连接service时执行，）
	private ServiceConnection connection = new ServiceConnection() {

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			binder = (CountService.MyBinder) service;
			binder.startDownload();
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {

		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);
		start_time = System.currentTimeMillis();


		Button start = (Button) findViewById(R.id.start_service);
		Button stop = (Button) findViewById(R.id.destroy_service);
		final Button binder = (Button) findViewById(R.id.binder_service);
		final Button unbinder = (Button) findViewById(R.id.unbinder_service);

		start.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Main2Activity.this, CountService.class);
				startService(intent);
			}
		});

		stop.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Main2Activity.this, CountService.class);
				stopService(intent);
			}
		});

		binder.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Main2Activity.this, CountService.class);
				bindService(intent, connection, BIND_AUTO_CREATE);
			}
		});

		unbinder.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				unbindService(connection);
			}
		});


	}

	@Override
	protected void onStop() {
		super.onStop();
		News news = new News();
		news.setTitle("secondActivity");
		news.setContent("第二个页面内容");
		news.setTime(start_time);
		news.setStay_time(System.currentTimeMillis() - start_time);
		news.save();
	}
}
