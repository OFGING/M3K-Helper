package com.rxuglr.m3khelper.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.rxuglr.m3khelper.R
import com.rxuglr.m3khelper.util.Variables.FontSize
import com.rxuglr.m3khelper.util.Variables.LineHeight
import com.rxuglr.m3khelper.util.Variables.Warning
import com.rxuglr.m3khelper.util.sdp
import com.rxuglr.m3khelper.util.ssp

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
                            fontSize = FontSize
                        )
                    }
                )
            }
        )
    }
}

@Composable
fun NoRoot() {
    AlertDialog(
        icon = {
            Icon(
                imageVector = Icons.Filled.Warning,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(40.sdp())
            )
        },
        title = {},
        text = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.no_root),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                lineHeight = 35.ssp(),
                fontSize = 25.ssp()
            )
        },
        onDismissRequest = {},
        dismissButton = {},
        confirmButton = {}
    )
}

@Composable
fun StatusDialog(
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

@Composable
fun UnknownDevice() {
    AlertDialog(
        icon = {
            Icon(
                modifier = Modifier
                    .size(40.sdp()),
                imageVector = Icons.Filled.Warning,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
        },
        title = {},
        text = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.device_unknown),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                lineHeight = 35.ssp(),
                fontSize = 25.ssp()
            )
        },
        onDismissRequest = { Warning.value = false },
        dismissButton = {},
        confirmButton = {
            AssistChip(
                onClick = {
                    Warning.value = false
                },
                label = {
                    Text(
                        modifier = Modifier.padding(
                            top = 2.sdp(),
                            bottom = 2.sdp()
                        ),
                        text = stringResource(R.string.device_unknown_confirm),
                    )
                }
            )
        }
    )
}