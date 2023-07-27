package com.openkin.directorfm.ui.screens

import androidx.compose.runtime.Composable
import com.openkin.directorfm.ui.screenstates.MainScreenUiState

@Composable
fun MainScreen(
    screenState: MainScreenUiState,
    onShortcutClicked: (String) -> Unit,
    onBackPressed: () -> Unit
){
    when(screenState) {
        is MainScreenUiState.HomeScreen ->
            HomeScreen(onShortcutClicked = onShortcutClicked)
        is MainScreenUiState.CurrentDirectoryScreen -> {
            CurrentDirectoryScreen(
                filesList = screenState.filesList,
                hasParent = screenState.hasParent,
                onShortcutClicked,
                onBackPressed
            )
        }
    }

}