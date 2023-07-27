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
import com.openkin.data.utils.TextUtil
import com.openkin.directorfm.R

@Composable
fun BaseAlertDialog(
    dialogTitle: String = TextUtil.EMPTY,
    dialogText: String,
    confirmButtonText: String = stringResource(id = R.string.dialog_button_confirm),
    dismissButtonText: String = stringResource(id = R.string.dialog_button_dismiss),
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
                    title = { Text(text = dialogTitle) },
                    text = { Text(text = dialogText) },
                    confirmButton = {
                        Button(onClick = {
                            openDialog.value = false
                            onConfirm.invoke()
                        }) {
                            Text(confirmButtonText)
                        }
                    },
                    dismissButton = {
                        Button(onClick = {
                            openDialog.value = false
                            onDismiss.invoke()
                        }) {
                            Text(dismissButtonText)
                        }
                    }
                )
            }
        }

    }
}
