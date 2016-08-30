package zhao.test.com.mytest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;

public class MainActivity extends AppCompatActivity {
    private final static String Tag = "MainActivity";
    private String requestInfo;
    private TextView tvInfo;
    private RequestQueue requestQueue;
    private ImageView ivTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(Tag, "onCreate");
        tvInfo = (TextView) findViewById(R.id.tv_info);
        ivTest = (ImageView) findViewById(R.id.iv_test);
    }
}
