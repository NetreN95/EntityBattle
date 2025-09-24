package ru.maxtere.sdk.ui.compose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.maxtere.sdk.ui.compose.constants.Colors
import ru.maxtere.sdk.ui.compose.constants.Strings

@Composable
fun NetworkErrorScreen(
    onClickTryAgain: (() -> Unit)
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Colors.networkErrorBackground)
                .padding(15.dp)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(0.7f),
                text = Strings.NETWORK_ERROR_TEXT,
                color = Colors.networkErrorText
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(onClick = onClickTryAgain),
                text = Strings.TRY_AGAIN_TEXT,
                color = Colors.tryAgainText
            )
        }
    }
}