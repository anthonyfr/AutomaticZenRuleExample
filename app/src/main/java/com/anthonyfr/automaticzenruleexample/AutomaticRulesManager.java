package com.anthonyfr.automaticzenruleexample;

import android.util.Log;
import android.app.AutomaticZenRule;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.service.notification.Condition;

public class AutomaticRulesManager {
    private Context mContext;
    private NotificationManager mNotificationManager;

    AutomaticRulesManager(final Context context) {
        mContext = context;
        mNotificationManager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);
    }

    String createAutomaticRule() {
        ComponentName componentName = new ComponentName(mContext,
                MyConditionProviderService.class.getName());

        Uri uri = Condition.newId(mContext)
                .appendPath("schedule")
                .appendQueryParameter("days", "1.2.3.4.5.6.7")
                .appendQueryParameter("start", "23.51")
                .appendQueryParameter("end", "00.30")
                .appendQueryParameter("exitAtAlarm", "false")
                .build();

        Condition condition = new Condition(uri, "test", 2);
        AutomaticZenRule automaticZenRule = new AutomaticZenRule("MyAutomaticRule", componentName,
                condition.id, NotificationManager.INTERRUPTION_FILTER_ALARMS, true);
        return mNotificationManager.addAutomaticZenRule(automaticZenRule);
    }

    void deleteAutomaticRule(final String id) {

    }
}
