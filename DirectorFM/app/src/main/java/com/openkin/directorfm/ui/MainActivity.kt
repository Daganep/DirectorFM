package com.openkin.directorfm.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.ui.res.stringResource
import com.openkin.directorfm.R
import com.openkin.directorfm.ui.screens.BaseAlertDialog
import com.openkin.directorfm.ui.screens.StartScreen
import com.openkin.directorfm.ui.theme.DirectorFMTheme
import kotlin.system.exitProcess

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            if (!Environment.isExternalStorageManager()) {
                BaseAlertDialog(
                    dialogTitle = stringResource(id = R.string.permission_dialog_all_files_title),
                    dialogText = stringResource(id = R.string.permission_dialog_all_files_text),
                    onConfirm = { requestPermissions() },
                    onDismiss = {
                        exitProcess(0)
                    }
                )
            }
            DirectorFMTheme {
                StartScreen()
            }
        }
    }

    private fun requestPermissions() {
        val intent = Intent()
        try {
            intent.action = Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION
            val uri: Uri = Uri.fromParts("package", this.packageName, null)
            intent.data = uri
            storageActivityResultLauncher.launch(intent)
        } catch (exception: Exception) {
            intent.action = Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION
            storageActivityResultLauncher.launch(intent)
        }
    }

    private val storageActivityResultLauncher : ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (!Environment.isExternalStorageManager()) {
                Toast.makeText(
                    this,
                    R.string.permission_toas_not_granted,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
}