package uk.co.villainrom.pulser.scrollinglauncherwallpaper;

import de.robv.android.xposed.IXposedHookInitPackageResources;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_InitPackageResources.InitPackageResourcesParam;

public class ScrollingLauncherWallpaper implements IXposedHookInitPackageResources{

	@Override
	public void handleInitPackageResources(InitPackageResourcesParam resparam) throws Throwable {
		try {
			if (resparam.packageName.equals("com.sec.android.app.launcher"))
			{
				XposedBridge.log("setting no fixed wallpaper offset");
				resparam.res.setReplacement("com.sec.android.app.launcher", "bool", "config_fixedWallpaperOffset", false);
			}

		}
		catch (Throwable t) { XposedBridge.log(t); }
	}
}
