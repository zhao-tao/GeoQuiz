package zhao.test.com.mytest;

import android.app.Application;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by 赵涛 on 2016/11/18.
 */

public class TestApplication extends Application {

	public static TestApplication mInstence = null;

	public static TestApplication getInstance() {
		if (mInstence == null) {
			mInstence = new TestApplication();
		}
		return mInstence;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		mInstence = this;
		Intent intent = new Intent(this, CountService.class);
		startService(intent);
	}

	public void toast(String text) {
		Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
	}
}
