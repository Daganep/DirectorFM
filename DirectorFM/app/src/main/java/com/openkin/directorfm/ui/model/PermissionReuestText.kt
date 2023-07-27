package com.openkin.directorfm.ui.model

import android.text.method.LinkMovementMethod
import android.text.util.Linkify
import android.widget.TextView
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.util.LinkifyCompat
import com.openkin.directorfm.R

@Composable
fun PermissionRequestText() {
    val context = LocalContext.current
    val text = stringResource(id = R.string.permission_dialog_all_files_text)

    AndroidView(factory = { TextView(context) }) { textView ->
        textView.text = text
        textView.textSize = 18F
        LinkifyCompat.addLinks(textView, Linkify.WEB_URLS)
        textView.movementMethod = LinkMovementMethod.getInstance()
    }
}