KillSmartBarXposed
==================

A Xposed module which works on Flyme, provide hide smartbar and transparent notification bar on launcher apps.

- Tested on Flyme 2.X and Flyme 3.X devices
- Now support Nova Launcher, iLauncher, Smartisan Launcher, if you want to support more launcher, you can fork it and add support to it.
- In some launcher, transparent notification bar will cause the notification bar cover the launcher, if so don't make notification bar to be transparent.
- Transparent notification bar is not supported on Flyme 2.X devices.

![ScreenShot](https://raw.githubusercontent.com/kyze8439690/KillSmartBarXposed/master/art/screenshot.jpg)

**Add more launcher support:**
KillSmartBar.java

    ...
    @Override
    public void initZygote(StartupParam startupParam) throws Throwable {
        mPackageToKills = new PackageToKill[]{
            new PackageToKill("com.teslacoilsw.launcher", "com.android.launcher2.Launcher", true, true),
            new PackageToKill("net.suckga.iLauncher2", "net.suckga.iLauncher2.LauncherActivity", true, false),
            new PackageToKill("com.ovidos.android.kitkat.launcher3", "com.ovidos.android.kitkat.launcher3.Launcher", true, false),
            new PackageToKill("com.smartisanos.launcher", "com.smartisanos.launcher.LauncherActivity", true, false),
            /**
             *  add launcher info here
             *  new PackageToKill("launcher package name", "launcher activity name", killSmartbar?, transparent notification bar?)
             */
        };
        XposedBridge.log("There is " + mPackageToKills.length + " Package to be processed.");
    }
    ...
    
You can get the package info from AndroidManifest.xml in apk file.