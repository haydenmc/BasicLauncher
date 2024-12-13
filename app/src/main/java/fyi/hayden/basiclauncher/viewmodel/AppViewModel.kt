package fyi.hayden.basiclauncher.viewmodel

import android.content.Context
import android.content.pm.PackageManager
import androidx.lifecycle.ViewModel
import fyi.hayden.basiclauncher.model.AppListEntry

class AppViewModel : ViewModel() {
    private fun getInstalledApps(context: Context) {
        val packageManager = context.packageManager;
        val apps = mutableListOf<AppListEntry>()
        val packages = packageManager.getInstalledApplications(PackageManager.GET_META_DATA)
        for (packageInfo in packages) {
            val appName = packageManager.getApplicationLabel(packageInfo).toString()
            val packageName = packageInfo.packageName
            val icon = packageManager.getApplicationIcon(packageInfo)
            apps.add(AppListEntry(appName, packageName, icon))
        }
    }
}