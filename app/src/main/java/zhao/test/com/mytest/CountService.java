package zhao.test.com.mytest;

import android.app.Service;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.IBinder;
import android.support.annotation.Nullable;

import org.litepal.tablemanager.Connector;

/**
 * Created by 赵涛 on 2016/11/18.
 */

public class CountService extends Service {

	@Nullable
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		SQLiteDatabase db = Connector.getDatabase();

	}

}
