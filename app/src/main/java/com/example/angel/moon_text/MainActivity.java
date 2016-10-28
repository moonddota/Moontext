package com.example.angel.moon_text;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.angel.moon_text.voller.HttpUtil;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private TextView tv1,tv2,tv3;
    private ViewPager pager;
    //参数列表需要获取一个Fragment管理器 getSupportFragmentManager
    private FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new One();
                case 1:
                    return new Two();
                case 2:
                    return new Three();
                default:
                    throw  new RuntimeException("数据异常");//最后这里需要抛一个运行时异常runException
            }
        }

        @Override
        public int getCount() {
            return 3;//这里返回的值是我们已知的Fragment数量
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initData();
        new Thread(new Runnable() {
            @Override
            public void run() {
                String s = HttpUtil.getUrlcontent();
                Log.d("debug",s);
            }
        }).start();
    }

    private void initData() {
        pager.addOnPageChangeListener(this);//给ViewPager设置滑动监听，目的是为了显示Fragment
        tv1.setSelected(true);//首次进入默认选中第一个
        //下方btn设置监听，点击时切换页面
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
    }

    private void initViews() {
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);
    }
    /**页面滑动时的监听*/
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }
    /**页面选择时的监听*/
    @Override
    public void onPageSelected(int position) {
        //当选择Fragment时，同步设置下方按钮的旋转状态
        tv1.setSelected(position==0);
        tv2.setSelected(position==1);
        tv3.setSelected(position==2);
    }
    /**页面滑动状态变化时的监听*/
    @Override
    public void onPageScrollStateChanged(int state) {

    }
    /**点击btn设置ViewPager当前视图*/
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv1:
                pager.setCurrentItem(0,true);//参数一是ViewPager的position,参数二为是否有滑动效果
                break;
            case R.id.tv2:
                pager.setCurrentItem(1,true);
                break;
            case R.id.tv3:
                pager.setCurrentItem(2,true);
                break;
        }
    }
}
