package com.openkin.directorfm.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.openkin.data.utils.TextUtil
import com.openkin.directorfm.R
import com.openkin.directorfm.constants.Constants.APP_NAME
import com.openkin.directorfm.constants.Constants.HOME
import com.openkin.directorfm.ui.model.UiFile
import com.openkin.directorfm.ui.screenstates.MainScreenUiState
import java.io.File

class MainScreenViewModel : ViewModel() {

    var screenState: MainScreenUiState by mutableStateOf(MainScreenUiState.HomeScreen(APP_NAME))
        private set
    var currentDirectoryPath: String = HOME
    var currentFile: File? = File(currentDirectoryPath)

    fun returnToPreviousDirectory() {
        val previousDirectoryPath = File(currentDirectoryPath).parentFile?.path ?: TextUtil.EMPTY
        if (previousDirectoryPath.isNotBlank()) {
            getFilesList(previousDirectoryPath)
        }
    }

    fun openSearch() {

    }

    fun toHomeScreen() {
        getFilesList(HOME)
    }

    fun getFilesList(path: String) {
        currentDirectoryPath = path
        Log.d("MyFilter", "path: $path")
        if (path == HOME) {
            screenState = MainScreenUiState.HomeScreen(APP_NAME)
        } else {
            val filesList: List<File> = File(path).listFiles()?.toMutableList() ?: mutableListOf()
            val uiFilesList: MutableList<UiFile> = mutableListOf()
            for (file in filesList) {
                val fileIcon = if (file.isDirectory) {
                    R.drawable.ic_directory
                } else {
                    R.drawable.ic_file
                }
                uiFilesList.add(UiFile(name = file.name, path = file.absolutePath, fileIcon))
            }

            screenState = MainScreenUiState.CurrentDirectoryScreen(
                screenTitle = File(path).absolutePath,
                filesList = uiFilesList,
                hasParent = currentDirectoryPath != HOME,
                ::getFilesList,
                ::returnToPreviousDirectory
            )
        }
    }
}