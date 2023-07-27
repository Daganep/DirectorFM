package com.openkin.directorfm.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.openkin.data.utils.TextUtil
import com.openkin.directorfm.R
import com.openkin.directorfm.constants.Constants.LIST_ELEMENT_BACK_BUTTON
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
        item {
            FileCard(
                name = LIST_ELEMENT_BACK_BUTTON,
                path = TextUtil.EMPTY,
                icon = R.drawable.ic_list_elemrnt_back_button
            ) { onBackPressed() }
        }
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