package com.openkin.directorfm.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.openkin.directorfm.viewmodels.MainScreenViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartScreen(viewModel: MainScreenViewModel = koinViewModel()) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopAppBar(
            screenState = viewModel.screenState,
            currentFile = viewModel.currentFile,
            onSearchClicked = { viewModel.openSearch() },
            onHomeClicked = { viewModel.toHomeScreen() }
        )}
    ) {
        Surface(modifier = Modifier
            .fillMaxSize()
            .padding(it)
        ) {
            MainScreen(
                viewModel.screenState,
                viewModel::getFilesList,
                viewModel::returnToPreviousDirectory
            )
        }
    }
}