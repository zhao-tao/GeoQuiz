package zhao.test.com.mytest;

import android.app.Service;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import org.litepal.tablemanager.Connector;

/**
 * Created by 赵涛 on 2016/11/18.
 */

public class CountService extends Service {

	public static SQLiteDatabase db;
	public static String TAG = "ServiceTest";
	public MyBinder myBinder = new MyBinder();
	
	/**
	 * 与Activity建立关联
	 *
	 * @param intent
	 * @return
	 */
	@Nullable
	@Override
	public IBinder onBind(Intent intent) {
		return myBinder;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		db = Connector.getDatabase();
		Log.d(TAG, "onCreate Service");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d(TAG, "onStartCommand Service");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d(TAG, "onDestroy Service");
	}

	class MyBinder extends Binder {
		public void startDownload() {
			Log.d(TAG, "startDownload Service");
		}
	}
}
