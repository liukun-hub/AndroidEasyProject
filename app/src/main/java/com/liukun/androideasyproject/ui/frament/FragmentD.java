package com.liukun.androideasyproject.ui.frament;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.widget.TextView;

import com.liukun.androideasyproject.R;
import com.liukun.androideasyproject.commom.MyFragment;
import com.liukun.androideasyproject.ui.activity.HomeActivity;

import butterknife.BindView;

import static com.liukun.androideasyproject.helper.AppConfig.getPackageName;

/**
 *
 */
public final class FragmentD extends MyFragment<HomeActivity> {

    @BindView(R.id.text)
    TextView mText;

    public static FragmentD newInstance() {
        return new FragmentD();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_d;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        mText.setOnClickListener(v -> {
            if (!Settings.canDrawOverlays(getContext())) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                ComponentName cmp = new ComponentName("com.tencent.mm","com.tencent.mm.ui.LauncherUI");
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setComponent(cmp);
                startActivity(intent);
            }
        });
    }
}