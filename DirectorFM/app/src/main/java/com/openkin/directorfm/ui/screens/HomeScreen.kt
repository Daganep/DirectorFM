package com.openkin.directorfm.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.openkin.directorfm.R
import com.openkin.directorfm.constants.Constants.APPLICATIONS
import com.openkin.directorfm.constants.Constants.BOOKMARKS
import com.openkin.directorfm.constants.Constants.DOCUMENTS
import com.openkin.directorfm.constants.Constants.DOWNLOADS
import com.openkin.directorfm.constants.Constants.INTERNAL_STORAGE
import com.openkin.directorfm.constants.Constants.PHOTOS
import com.openkin.directorfm.ui.model.FileCard

@Composable
fun HomeScreen(onShortcutClicked: (String) -> Unit) {
    LazyColumn {
        item {
            FileCard(
                name = stringResource(id = R.string.home_screen_internal_storage),
                path = INTERNAL_STORAGE,
                icon = R.drawable.ic_internal_storage
            ) { onShortcutClicked(INTERNAL_STORAGE) }
        }
        item {
            FileCard(
                name = stringResource(id = R.string.home_screen_documents),
                path = DOCUMENTS,
                icon = R.drawable.ic_documents
            ) { onShortcutClicked(DOCUMENTS) }
        }
        item {
            FileCard(
                name = stringResource(id = R.string.home_screen_photos),
                path = PHOTOS,
                icon = R.drawable.ic_photos
            ) { onShortcutClicked(PHOTOS) }
        }
        item {
            FileCard(
                name = stringResource(id = R.string.home_screen_downloads),
                path = DOWNLOADS,
                icon = R.drawable.ic_downloads
            ) { onShortcutClicked(DOWNLOADS) }
        }
        item {
            FileCard(
                name = stringResource(id = R.string.home_screen_bookmarks),
                path = BOOKMARKS,
                icon = R.drawable.ic_favorites
            ) { onShortcutClicked(BOOKMARKS) }
        }
        item {
            FileCard(
                name = stringResource(id = R.string.home_screen_applications),
                path = APPLICATIONS,
                icon = R.drawable.ic_apps
            ) { onShortcutClicked(APPLICATIONS) }
        }
    }
}