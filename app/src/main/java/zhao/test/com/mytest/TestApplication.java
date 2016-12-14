package zhao.test.com.mytest;

import android.app.Application;
import android.content.Intent;
import android.widget.Toast;

import org.litepal.LitePalApplication;

/**
 * Created by 赵涛 on 2016/11/18.
 */

public class TestApplication extends LitePalApplication {

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
	}

	public void toast(String text) {
		Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
	}
}
