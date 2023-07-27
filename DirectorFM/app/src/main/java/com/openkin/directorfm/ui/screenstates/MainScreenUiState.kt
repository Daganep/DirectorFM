package com.openkin.directorfm.ui.screenstates

import com.openkin.directorfm.ui.model.UiFile

sealed interface MainScreenUiState {
    data class HomeScreen(val screenTitle: String) : MainScreenUiState
    class CurrentDirectoryScreen(
        val screenTitle: String,
        val filesList: List<UiFile>,
        val hasParent: Boolean,
        onShortcutClicked: (String) -> Unit,
        onBackPressed: () -> Unit
    ) : MainScreenUiState
}