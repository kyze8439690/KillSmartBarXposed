package me.yugy.android.xposed.mods.killsmartbar;

import android.app.Activity;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Created by yugy on 2014/6/13.
 */
public class KillSmartBar implements IXposedHookLoadPackage, IXposedHookZygoteInit {

    private static final String PACKAGE_NAME = KillSmartBar.class.getPackage().getName();
    private PackageToKill[] mPackageToKills;

    @Override
    public void initZygote(StartupParam startupParam) throws Throwable {
        mPackageToKills = new PackageToKill[]{
            new PackageToKill("com.teslacoilsw.launcher", "com.android.launcher2.Launcher", true, true),
            new PackageToKill("net.suckga.iLauncher2", "net.suckga.iLauncher2.LauncherActivity", true, false),
            new PackageToKill("com.ovidos.android.kitkat.launcher3", "com.ovidos.android.kitkat.launcher3.Launcher", true, false),
            new PackageToKill("com.smartisanos.launcher", "com.smartisanos.launcher.LauncherActivity", true, false),
        };
        XposedBridge.log("There is " + mPackageToKills.length + " Package to be processed.");
    }

    @Override
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable{
        for(final PackageToKill packageToKill : mPackageToKills){
           if(loadPackageParam.packageName.equals(packageToKill.getPackageName())){
               XposedBridge.log("Loaded app: " + loadPackageParam.packageName);
               XposedBridge.log("We are in!");

               XposedHelpers.findAndHookMethod(packageToKill.getActivityName(), loadPackageParam.classLoader, "onStart", new XC_MethodHook() {
                   @Override
                   protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                       super.beforeHookedMethod(param);
                   }

                   @Override
                   protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                       super.afterHookedMethod(param);
                       if (packageToKill.isKillSmartBar()) {
                           MeizuUtils.hideSmartBar((Activity) param.thisObject);
                           XposedBridge.log("Kill SmartBar!");
                       }
                       if (packageToKill.isShowTransparentNotifyBar()) {
                           MeizuUtils.transparentStatusBar((Activity) param.thisObject);
                           XposedBridge.log("Show transparentStatusBar!");
                       }
                   }
               });
           }
        }

    }

}
