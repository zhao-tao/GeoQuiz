package zhao.test.com.mytest.Bean;

/**
 * Created by 赵涛 on 2016/8/30.
 */
public class TrueFalse {
    private int mQuestiton;
    private boolean mTrueQuestiton;

    public TrueFalse(int mQuestiton, boolean mTrueQuestiton) {
        this.mQuestiton = mQuestiton;
        this.mTrueQuestiton = mTrueQuestiton;
    }

    public int getmQuestiton() {
        return mQuestiton;
    }

    public void setmQuestiton(int mQuestiton) {
        this.mQuestiton = mQuestiton;
    }

    public boolean ismTrueQuestiton() {
        return mTrueQuestiton;
    }

    public void setmTrueQuestiton(boolean mTrueQuestiton) {
        this.mTrueQuestiton = mTrueQuestiton;
    }
}
