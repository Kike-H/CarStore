package com.mehdev.carstore.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.mehdev.carstore.R
import io.ak1.drawbox.DrawBox
import io.ak1.drawbox.rememberDrawController

@Composable
fun DrawingBox() {
    val drawController = rememberDrawController()
    ConstraintLayout {
        DrawBox(
            drawController = drawController,
            modifier = Modifier
                .fillMaxSize()
        )
        Image(painterResource(R.drawable.car), "car")

    }

}


@Preview
@Composable
fun DefaultDrawingBoxPreview() {
    DrawingBox()
}