package io.adtrace.sdk;

import android.content.Context;
import android.net.Uri;

/**
 * Created by Morteza KhosraviNejad on 06/01/19.
 */
public interface IActivityHandler {
    void init(AdTraceConfig config);

    void onResume();

    void onPause();

    void trackEvent(AdTraceEvent event);

    void finishedTrackingActivity(ResponseData responseData);

    void setEnabled(boolean enabled);

    boolean isEnabled();

    void readOpenUrl(Uri url, long clickTime);

    boolean updateAttributionI(AdTraceAttribution attribution);

    void launchEventResponseTasks(EventResponseData eventResponseData);

    void launchSessionResponseTasks(SessionResponseData sessionResponseData);

    void launchSdkClickResponseTasks(SdkClickResponseData sdkClickResponseData);

    void launchAttributionResponseTasks(AttributionResponseData attributionResponseData);

    void sendReftagReferrer();

    void sendInstallReferrer(String installReferrer, long referrerClickTimestampSeconds, long installBeginTimestampSeconds);

    void setOfflineMode(boolean enabled);

    void setAskingAttribution(boolean askingAttribution);

    void sendFirstPackages();

    void addSessionCallbackParameter(String key, String value);

    void addSessionPartnerParameter(String key, String value);

    void removeSessionCallbackParameter(String key);

    void removeSessionPartnerParameter(String key);

    void resetSessionCallbackParameters();

    void resetSessionPartnerParameters();

    void teardown();

    void setPushToken(String token, boolean preSaved);

    void gdprForgetMe();

    void gotOptOutResponse();

    Context getContext();

    String getAdid();

    AdTraceAttribution getAttribution();

    AdTraceConfig getAdTraceConfig();

    DeviceInfo getDeviceInfo();

    ActivityState getActivityState();

    SessionParameters getSessionParameters();

    String getBasePath();

    String getGdprPath();
}
