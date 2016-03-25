package zhao.test.com.mytest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private final static String Tag = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(Tag, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(Tag, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(Tag, "onReStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(Tag, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(Tag, "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(Tag, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(Tag, "onDestroy");
    }
}
