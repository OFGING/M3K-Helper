package com.rxuglr.m3khelper.ui.templates

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AssistChip
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import com.rxuglr.m3khelper.R
import com.rxuglr.m3khelper.util.Variables.FontSize
import com.rxuglr.m3khelper.util.Variables.LineHeight
import com.rxuglr.m3khelper.util.sdp

object PopupDialogs {

    @Composable
    fun Dialog(
        icon: Painter,
        title: String?,
        description: String?,
        showDialog: Boolean,
        onDismiss: () -> Unit,
        onConfirm: () -> Unit,
    ) {
        if (showDialog) {
            AlertDialog(
                icon = {
                    Icon(
                        icon,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(40.sdp())
                    )
                },
                title = {
                    if (title != null) {
                        Text(
                            text = title,
                            textAlign = TextAlign.Center,
                            fontSize = FontSize,
                            lineHeight = LineHeight,
                        )
                    }
                },
                text = {
                    if (description != null) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = description,
                            textAlign = TextAlign.Center,
                            lineHeight = LineHeight,
                            fontSize = FontSize
                        )
                    }
                },
                onDismissRequest = onDismiss,
                dismissButton = {
                    AssistChip(
                        onClick = onConfirm,
                        label = {
                            Text(
                                modifier = Modifier.padding(top = 2.sdp(), bottom = 2.sdp()),
                                text = LocalContext.current.getString(R.string.yes),
                                color = MaterialTheme.colorScheme.inverseSurface,
                                fontSize = FontSize
                            )
                        }
                    )
                },
                confirmButton = {
                    AssistChip(
                        onClick = onDismiss,
                        label = {
                            Text(
                                modifier = Modifier.padding(top = 2.sdp(), bottom = 2.sdp()),
                                text = LocalContext.current.getString(R.string.no),
                                color = MaterialTheme.colorScheme.inverseSurface,
                                fontSize = FontSize
                            )
                        }
                    )
                }
            )
        }
    }

    @Composable
    fun SpinnerDialog(
        icon: Painter,
        title: Int,
        showDialog: Boolean,
    ) {
        if (showDialog) {
            AlertDialog(
                icon = {
                    Icon(
                        icon,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(40.sdp())
                    )
                },
                title = {
                    Text(
                        text = LocalContext.current.getString(title),
                        textAlign = TextAlign.Center,
                        fontSize = FontSize,
                        lineHeight = LineHeight
                    )
                },
                text = {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier.width(32.sdp()),
                            color = MaterialTheme.colorScheme.secondary,
                            trackColor = MaterialTheme.colorScheme.surfaceVariant,
                        )
                    }
                },
                onDismissRequest = {},
                dismissButton = {},
                confirmButton = {}
            )
        }
    }
}