package com.openkin.directorfm.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import com.openkin.directorfm.R
import com.openkin.directorfm.ui.model.PermissionRequestText

@Composable
fun PermissionDialog(
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
    onDismissRequest: (() -> Unit)? = null
) {
    MaterialTheme {
        Column {
            val openDialog = remember { mutableStateOf(true)  }
            if (openDialog.value) {
                AlertDialog(
                    onDismissRequest = { onDismissRequest?.invoke() },
                    title = {
                        Text(text = stringResource(id = R.string.permission_dialog_all_files_title))
                    },
                    text = { PermissionRequestText() },
                    confirmButton = {
                        Button(onClick = {
                            openDialog.value = false
                            onConfirm.invoke()
                        }) {
                            Text(stringResource(id = R.string.dialog_button_confirm))
                        }
                    },
                    dismissButton = {
                        Button(onClick = {
                            openDialog.value = false
                            onDismiss.invoke()
                        }) {
                            Text(stringResource(id = R.string.dialog_button_dismiss))
                        }
                    }
                )
            }
        }

    }
}
