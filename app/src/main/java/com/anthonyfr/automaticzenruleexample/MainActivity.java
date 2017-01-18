package com.anthonyfr.automaticzenruleexample;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private String mAutomaticRuleCreatedId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkNotificationPolicyAccess();

        final Button createButton = (Button) findViewById(R.id.create_btn);
        final Button deleteButton = (Button) findViewById(R.id.delete_btn);
        final AutomaticRulesManager manager = new AutomaticRulesManager(this);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAutomaticRuleCreatedId = manager.createAutomaticRule();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.deleteAutomaticRule(mAutomaticRuleCreatedId);
            }
        });
    }

    private void checkNotificationPolicyAccess() {
        NotificationManager notificationManager = (NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE);
        if (!notificationManager.isNotificationPolicyAccessGranted()) {
            startActivityForResult(
                    new Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS), 0);
        }
    }
}
