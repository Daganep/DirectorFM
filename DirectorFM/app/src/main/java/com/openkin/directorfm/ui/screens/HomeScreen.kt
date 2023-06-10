package com.openkin.directorfm.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.openkin.directorfm.ui.model.FileCard
import com.openkin.directorfm.ui.model.UiFile
import com.openkin.directorfm.viewmodels.MainScreenViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: MainScreenViewModel = koinViewModel()){

    val filesList: List<UiFile> by
        viewModel.currentDirectoryFilesList.observeAsState(
            viewModel.homeScreenShortcuts.homeScreenList
        )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopAppBar(
            currentFile = viewModel.currentFile,
            onSearchClicked = { viewModel.openSearch() }
        )}
    ) {
        Surface(modifier = Modifier
            .fillMaxSize()
            .padding(it)
        ) {
            LazyColumn {
                for (file in filesList) {
                    item {
                        FileCard(
                            name = file.name,
                            path = file.path,
                            icon = file.icon
                        ) { viewModel.getFilesList(file.path) }
                    }
                }
            }
        }
    }

    BackHandler(enabled = viewModel.getCurrentFileParent() == null) {
        viewModel.returnToPreviousDirectory()
    }

}