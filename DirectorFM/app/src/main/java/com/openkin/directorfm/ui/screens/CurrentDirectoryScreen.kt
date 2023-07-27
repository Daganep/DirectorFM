package com.openkin.directorfm.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.openkin.directorfm.ui.model.FileCard
import com.openkin.directorfm.ui.model.UiFile

@Composable
fun CurrentDirectoryScreen(
    filesList: List<UiFile>,
    hasParent: Boolean,
    onShortcutClicked: (String) -> Unit,
    onBackPressed: () -> Unit
) {
    LazyColumn {
        for(file in filesList) {
            item {
                FileCard(
                    name = file.name,
                    path = file.path,
                    icon = file.icon
                ) { onShortcutClicked(file.path) }
            }
        }
    }

    BackHandler(enabled = hasParent) {
        onBackPressed()
    }
}