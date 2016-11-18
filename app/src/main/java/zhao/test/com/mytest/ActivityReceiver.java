package zhao.test.com.mytest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import static zhao.test.com.mytest.TestApplication.getInstance;

/**
 * Created by 赵涛 on 2016/11/18.
 * 
 * 飞行模式开关监听
 */

public class ActivityReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		Bundle extras = intent.getExtras();
		if(extras!=null){
			switch (extras.getInt("state")){
				case 0:
					//关闭成功
					getInstance().toast("关闭成功");
					break;
				case 1:
					//开启过程
					break;
				
				case 3:
					//开启成功
					getInstance().toast("开启成功");
					break;
			}
		}

	}
}
