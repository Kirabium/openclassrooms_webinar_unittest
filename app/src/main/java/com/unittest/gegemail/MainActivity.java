package com.unittest.gegemail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CompoundButton;

import com.google.android.material.switchmaterial.SwitchMaterial;
import com.unittest.gegemail.event.DeleteMailEvent;
import com.unittest.gegemail.model.Mail;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import static com.unittest.gegemail.Utils.NOTIFICATION;
import static com.unittest.gegemail.Utils.NOTIFICATION_PREFERENCES;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private SwitchMaterial mSwitch;
    private Mail[] mails;

    private void initData() {
        mails = Mail.getMails();
    }

    private void initUI() {
        setContentView(R.layout.activity_main);
        initRecyclerView();
        initSwitch();
    }

    private boolean getStatusNotification(){
        return Utils.getNotification(this);
    }

    private void setStatusNotification(boolean status){
        SharedPreferences prefs = getSharedPreferences(NOTIFICATION_PREFERENCES, MODE_PRIVATE);
        prefs.edit().putBoolean(NOTIFICATION, status).apply();
    }

    private void initRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.list_mail);
        // LinearLayoutManager is used here, this will layout the elements in a similar fashion
        // to the way ListView would layout elements. The RecyclerView.LayoutManager defines how
        // elements are laid out.
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        CustomAdapter mAdapter = new CustomAdapter(mails);
        // Set CustomAdapter as the adapter for RecyclerView.
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
                layoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        mRecyclerView.setAdapter(mAdapter);
        // END_INCLUDE(initializeRecyclerView)
    }

    private void initSwitch(){
        mSwitch = (SwitchMaterial) findViewById(R.id.switch_notification);
        mSwitch.setOnCheckedChangeListener((compoundButton, b) -> {
            setStatusNotification(b);
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        initUI();
    }
    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(DeleteMailEvent event) {
        mails = Utils.removeItemAtIndex(mails, event.index);
        initRecyclerView();
    };
}