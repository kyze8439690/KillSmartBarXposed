package me.yugy.android.xposed.mods.killsmartbar;

/**
 * Created by yugy on 2014/6/13.
 */
public class PackageToKill {

    private String mPackageName;
    private String mActivityName;
    private boolean mKillSmartBar;
    private boolean mShowTransparentNotifyBar;

    public PackageToKill(String packageName, String activityName, boolean killSmartBar, boolean showTransparentNotifyBar){
        mPackageName = packageName;
        mActivityName = activityName;
        mKillSmartBar = killSmartBar;
        mShowTransparentNotifyBar = showTransparentNotifyBar;
    }

    public boolean isShowTransparentNotifyBar() {
        return mShowTransparentNotifyBar;
    }

    public void setShowTransparentNotifyBar(boolean showTransparentNotifyBar) {
        mShowTransparentNotifyBar = showTransparentNotifyBar;
    }

    public boolean isKillSmartBar() {
        return mKillSmartBar;
    }

    public void setKillSmartBar(boolean killSmartBar) {
        mKillSmartBar = killSmartBar;
    }

    public String getPackageName() {
        return mPackageName;
    }

    public void setPackageName(String packageName) {
        mPackageName = packageName;
    }

    public String getActivityName() {
        return mActivityName;
    }

    public void setActivityName(String activityName) {
        mActivityName = activityName;
    }
}
