package ru.maxtere.sdk.ui.compose.views

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import ru.maxtere.sdk.ui.compose.constants.Strings

@Composable
fun BackIconButton(
    onClickBack: (() -> Unit)
) {
    IconButton(
        onClick = onClickBack
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = Strings.BACK_CONTENT_DESCRIPTION,
            tint = Color.White
        )
    }
}