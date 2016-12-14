package zhao.test.com.mytest;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

import zhao.test.com.mytest.Bean.News;
import zhao.test.com.mytest.Bean.TrueFalse;

public class MainActivity extends AppCompatActivity {
	private TextView tvQuestion;
	private Button btnTrue;
	private Button btnFalse;
	private int mCurrentIndex = 0;

	private TrueFalse[] mQuestionBank = new TrueFalse[]{
			new TrueFalse(R.string.question_text1, true),
			new TrueFalse(R.string.question_text2, false),
			new TrueFalse(R.string.question_text3, false),
			new TrueFalse(R.string.question_text4, true),
			new TrueFalse(R.string.question_text5, false),
	};
	private Button btnPre;
	private Button btnNext;
	private int mCurrentQuestion;
	private Button activity2;
	private long start_time;
	private Button delDB;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (savedInstanceState != null) {
			mCurrentIndex = savedInstanceState.getInt("index");
		}

		start_time = System.currentTimeMillis();
		initView();
		setListener();
		setQuestion();
		Runtime.getRuntime().maxMemory();
	}

	@Override
	protected void onStop() {
		super.onStop();
		News news = new News();
		news.setTitle("MainActivity");
		news.setContent("第一个页面内容");
		news.setTime(start_time);
		news.setStay_time(System.currentTimeMillis() - start_time);
		news.save();
	}

	@Override
	public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
		super.onSaveInstanceState(outState, outPersistentState);
		//页面状态改变后暂存状态
		outState.putInt("index", mCurrentIndex);
	}

	private void setQuestion() {
		mCurrentQuestion = mQuestionBank[mCurrentIndex].getmQuestiton();
		tvQuestion.setText(mCurrentQuestion);
	}

	private void setListener() {
		btnTrue.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
//                Toast.makeText(MainActivity.this, R.string.correct_text, Toast.LENGTH_SHORT).show();
				checkAnswer(true);
			}
		});

		btnFalse.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
//                Toast.makeText(MainActivity.this, R.string.incorrect_text, Toast.LENGTH_SHORT).show();
				checkAnswer(false);
			}
		});

		btnPre.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mCurrentIndex != 0) {
					mCurrentIndex = (mCurrentIndex - 1) % mQuestionBank.length;
				} else {
					mCurrentIndex = mQuestionBank.length - 1;
				}
				setQuestion();
			}
		});

		btnNext.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
				setQuestion();
			}
		});

		activity2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, Main2Activity.class));
			}
		});

		delDB.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				DataSupport.deleteAll(News.class);
			}
		});

	}

	private void checkAnswer(boolean b) {
		if (b == mQuestionBank[mCurrentIndex].ismTrueQuestiton()) {
			Toast.makeText(this, "选择正确", Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(this, "选择错误", Toast.LENGTH_SHORT).show();
		}
	}

	private void initView() {
		tvQuestion = (TextView) findViewById(R.id.tv_question_info);
		btnTrue = (Button) findViewById(R.id.btn_true);
		btnFalse = (Button) findViewById(R.id.btn_false);
		btnNext = (Button) findViewById(R.id.btn_next);
		btnPre = (Button) findViewById(R.id.btn_previous);
		activity2 = (Button) findViewById(R.id.btn_next_activity);
		delDB = (Button) findViewById(R.id.btn_del_db);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return super.onCreateOptionsMenu(menu);
	}
}
