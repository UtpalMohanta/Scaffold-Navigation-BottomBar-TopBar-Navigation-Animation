package com.example.scafolld.Animation

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AnimationExample() {
    var expended by remember {
        mutableStateOf(false)
    }
    val size by animateDpAsState(
        targetValue = if (expended) 200.dp else 100.dp,
        animationSpec = tween(

            durationMillis = 500,
            easing = FastOutSlowInEasing
        ),
        label = "BoxSizeAnimation"
    )
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    )
    {
        Box(
            modifier = Modifier
                .size(size)
                .background(_root_ide_package_.androidx.compose.ui.graphics.Color.Blue)
                .clickable {
                    expended = !expended
                },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Top Me",
                color = _root_ide_package_.androidx.compose.ui.graphics.Color.White,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
@Preview(showSystemUi = true)
@Composable
fun AnimatedBottomBarPreview() {
    AnimationExample()
}