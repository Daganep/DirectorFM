package com.openkin.directorfm.ui.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FileCard(name: String, path: String, icon: Int, onClick: () -> Unit) {

    Row(
        Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Image(
            modifier = Modifier
                .size(40.dp)
                .fillMaxHeight()
                .align(Alignment.CenterVertically),
            painter = painterResource(id = icon),
            contentDescription = name
        )
        Column(
            modifier = Modifier.align(Alignment.CenterVertically)
                .padding(start = 16.dp)
        ) {
            Text(text = name, maxLines = 1)
            if (path.isNotBlank()) {
                Text(text = path, fontSize = 12.sp, maxLines = 1)
            }
        }
    }
}