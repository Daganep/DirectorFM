package com.openkin.directorfm.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.*
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.openkin.data.utils.TextUtil
import com.openkin.directorfm.R
import com.openkin.directorfm.constants.Constants.INTERNAL_STORAGE
import com.openkin.directorfm.ui.screenstates.MainScreenUiState
import java.io.File

@Composable
fun TopAppBar(
    screenState: MainScreenUiState,
    currentFile: File?,
    onSearchClicked: () -> Unit,
    onHomeClicked: () -> Unit
){
    //убрать после реализации поиска
    val searchIsDone = false

    //var screenTitle = stringResource(id = R.string.home_screen_app_bar_title)
    val screenTitle: String = when(screenState) {
        is MainScreenUiState.HomeScreen ->
            stringResource(id = R.string.home_screen_app_bar_title)
        is MainScreenUiState.CurrentDirectoryScreen -> {
            when (screenState.screenTitle) {
                INTERNAL_STORAGE -> stringResource(id = R.string.home_screen_internal_storage)
                else -> File(screenState.screenTitle).name ?: TextUtil.EMPTY
            }
        }
    }

    TopAppBar(
        modifier = Modifier.height(80.dp),
        backgroundColor = Color.Blue,
        title = {
            Column {
                Text(text = screenTitle, color = Color.White)
                Text(
                    fontSize = 12.sp,
                    text = currentFile?.absolutePath ?: TextUtil.EMPTY,
                    color = Color.White
                )
            }
        },
        actions = {
            Row {
                IconButton(onClick = { onHomeClicked() }) {
                    Icon(
                        imageVector = Icons.Filled.Home,
                        contentDescription = "К основному меню",
                        tint = Color.White
                    )
                }
                if (searchIsDone) {
                    IconButton(onClick = { onSearchClicked() }) {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Поиск",
                            tint = Color.White
                        )
                    }
                }
            }
        }
    )
}