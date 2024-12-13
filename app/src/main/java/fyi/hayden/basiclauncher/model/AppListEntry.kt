package fyi.hayden.basiclauncher.model

import android.graphics.drawable.Drawable

data class AppListEntry(
    val name: String,
    val packageName: String,
    val icon: Drawable
)
