package com.liukun.androideasyproject.ui.frament;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.hjq.toast.ToastUtils;
import com.liukun.androideasyproject.R;
import com.liukun.androideasyproject.commom.MyFragment;
import com.liukun.androideasyproject.ui.activity.HomeActivity;
import com.liukun.androideasyproject.ui.dialog.PrivacyDialog;
import com.liukun.androideasyproject.ui.dialog.SelectDialog;
import com.liukun.base.BaseDialog;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

/**
 *
 */
public final class FragmentA extends MyFragment<HomeActivity> {

    @BindView(R.id.text)
    TextView mText;

    public static FragmentA newInstance() {
        return new FragmentA();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_a;
    }

    @Override
    protected void initView() {

    }


    @Override
    protected void initData() {
        mText.setOnClickListener(v -> {
//            PrivacyDialog.Builder builder  = new PrivacyDialog.Builder(getContext());
//            builder.setOnClickListener(new PrivacyDialog.Builder.OnClickListener() {
//                @Override
//                public void OnClickOkListener(View view) {
//                    ToastUtils.show("okokokok");
//                }
//
//                @Override
//                public void OnClickCancelListener(View view) {
//                    ToastUtils.show("cancelcancel");
//                }
//            });
//            builder.show();

            SelectDialog.Builder builder = new SelectDialog.Builder(getContext());
            builder.setList("星期一", "星期二", "星期三", "星期四", "星期五");
            builder.setMaxSelect(3);
            builder.setSelect(2, 3, 4);
            builder.setListener(new SelectDialog.OnListener<String>() {
                @Override
                public void onSelected(BaseDialog dialog, HashMap data) {
                    HashMap<Integer,Object> map = data;
                    for (Map.Entry<Integer, Object> entry : map.entrySet()) {
                        System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
                        Log.d("ssss", "key= " + entry.getKey() + " and value= " + entry.getValue());
                    }
                }

                @Override
                public void onCancel(BaseDialog dialog) {

                }
            });
            builder.show();
        });
    }
}