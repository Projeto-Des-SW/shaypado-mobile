package com.ufape.shaypado.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import com.ufape.shaypado.R
import com.ufape.shaypado.ui.theme.textPrimary

enum class TextType {
    TITLE_LARGE,
    TITLE_MEDIUM,
    TITLE_SMALL,
    LABEL_MEDIUM,
    LABEL_SMALL,
}

@Composable
@Preview
fun AppText(
    textType: TextType = TextType.TITLE_LARGE,
    @StringRes text: Int = R.string.label,
    color: Color = textPrimary,
    size : TextUnit? = null,
    onPress: (() -> Unit)? = null,
    textAlignment: TextAlign = TextAlign.Start,
    fillWidth: Boolean = false,
) {
    var style = when (textType) {
        TextType.TITLE_LARGE -> MaterialTheme.typography.titleLarge
        TextType.TITLE_MEDIUM -> MaterialTheme.typography.titleMedium
        TextType.TITLE_SMALL -> MaterialTheme.typography.titleSmall
        TextType.LABEL_MEDIUM -> MaterialTheme.typography.labelMedium
        TextType.LABEL_SMALL -> MaterialTheme.typography.labelSmall
    }

    style = style.copy(
        textAlign = textAlignment,
        fontSize = size ?: style.fontSize,
    )

    val modifier = if (fillWidth) Modifier.fillMaxWidth() else Modifier

    Text(
        text = stringResource(id = text),
        style = style,
        color = color,
        modifier = if (onPress != null) modifier.clickable { onPress() } else modifier
    )
}