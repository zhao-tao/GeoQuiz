package zhao.test.com.mytest;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONObject;

import zhao.test.com.mytest.bean.Contants;

public class MainActivity extends AppCompatActivity {
    private String requestInfo;

    private final static String Tag = "MainActivity";
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
        requestQueue = Volley.newRequestQueue(this);
//        getStringRequest();
//        getJsonObjRequest();
//        getImageRequest();
        Glide.with(this).load(Contants.IMG_TEST).into(ivTest);
    }

    private void getImageRequest() {
        ImageRequest imageRequest = new ImageRequest(Contants.IMG_TEST, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                ivTest.setImageBitmap(response);
            }
        }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(imageRequest);
    }

    /**
     * 因为单纯的jsonObj中如果有嵌套的结构toString会出错，因此会报错
     */
    private void getJsonObjRequest() {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Contants.UP_DATA, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                requestInfo = response.toString();
                setText();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                requestInfo = error.getMessage();
            }
        });
        requestQueue.add(jsonObjectRequest);
    }

    private void setText() {
        if (requestInfo == null || !requestInfo.equals("")) {
            tvInfo.setText(requestInfo);
        }
    }

    private void getStringRequest() {

        StringRequest stringRequest = new StringRequest(Contants.UP_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                requestInfo = response;
                setText();
//                Toast.makeText(MainActivity.this, response, Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                requestInfo = error.getMessage().toString();
//                Toast.makeText(MainActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(stringRequest);
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
