package zhao.test.com.mytest.Bean;

import org.litepal.crud.DataSupport;

/**
 * Created by 赵涛 on 2016/11/20.
 */

public class News extends DataSupport {
    private String title;
    private String content;

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
