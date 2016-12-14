package zhao.test.com.mytest.Bean;

import org.litepal.crud.DataSupport;

/**
 * Created by 赵涛 on 2016/11/20.
 * 
 */

public class News extends DataSupport {
	private String title;
	private String content;
	private long time;
	private long stay_time;

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public long getStay_time() {
		return stay_time;
	}

	public void setStay_time(long stay_time) {
		this.stay_time = stay_time;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
