package com.example.musicplayer.controller.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import com.example.musicplayer.R;
import com.example.musicplayer.controller.fragment.AlbumFragment;
import com.example.musicplayer.controller.fragment.MusicFragment;
import com.example.musicplayer.controller.fragment.SingerFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ViewPagerActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 1;
    private ViewPager2 mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        findViews();
        permission();
        viewPagerAdaptor adaptor=new viewPagerAdaptor(this);
        mViewPager.setAdapter(adaptor);
        new TabLayoutMediator(mTabLayout, mViewPager,
                (tab, position) ->{
                    switch (position){
                        case 0:
                            tab.setText("Music");
                            break;
                        case 1:
                            tab.setText("Album");
                            break;
                        case 2:
                            tab.setText("Singer");
                            break;
                    }
                }
        ).attach();
    }

    private void permission() {
        if (ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_CODE);

        }
        else {
            Toast.makeText(this, "permission granted", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode==REQUEST_CODE){
            if (grantResults[0] ==PackageManager.PERMISSION_GRANTED){
                //todo
            }
            else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        REQUEST_CODE);
            }
        }
    }

    private void findViews() {
        mViewPager=findViewById(R.id.view_pager_state);
        mTabLayout=findViewById(R.id.tab_layout);
    }

    public class viewPagerAdaptor extends FragmentStateAdapter {

        public viewPagerAdaptor(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position){
                case 0:
                    return MusicFragment.newInstance();

                case 1:
                    return AlbumFragment.newInstance();

                case 2:
                    return SingerFragment.newInstance();


                default:
                    return null;
            }
        }

        @Override
        public int getItemCount() {
            return 3;
        }
    }
}