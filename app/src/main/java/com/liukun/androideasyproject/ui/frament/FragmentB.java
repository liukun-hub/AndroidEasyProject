package com.liukun.androideasyproject.ui.frament;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.hjq.toast.ToastUtils;
import com.liukun.androideasyproject.R;
import com.liukun.androideasyproject.commom.MessageWrap;
import com.liukun.androideasyproject.commom.MyFragment;
import com.liukun.androideasyproject.ui.activity.CopyActivity;
import com.liukun.androideasyproject.ui.activity.HomeActivity;
import com.liukun.androideasyproject.ui.bean.ChaptersBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 *
 */
public final class FragmentB extends MyFragment<HomeActivity> {
    TextView textView;
    TextView textView2;

    public static FragmentB newInstance() {
        return new FragmentB();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_b;
    }

    @Override
    protected void initView() {
        textView = findViewById(R.id.text);
        textView2 = findViewById(R.id.text2);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected void initData() {

    }


    @Override
    public void getStickyMessage(MessageWrap<?> messageWrap) {
        ChaptersBean message = (ChaptersBean) messageWrap.getMessage();
        Log.d("ssss", "getMessagesss: " + messageWrap.getMessage());
        switch ((int)messageWrap.getCode()){
            case 0:
                Log.d("ssss", "getMessagesss: " + messageWrap.getMessage()+message.getName());
                textView.setText("sss");
                textView.setText(message.getName()+"sss");
                break;
            case 1:
                Log.d("ssss", "getMessagesss222: " + messageWrap.getMessage());
                textView2.setText(message.getName());
                break;
        }
    }

}