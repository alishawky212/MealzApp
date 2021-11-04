package com.example.mealzapp.screens

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.mealzapp.model.response.MealResponse

@Composable
fun MealDetailScreen(mealResponse: MealResponse) {
    var pictureState by remember { mutableStateOf(MealDetailPictureState.NORMAL) }
    val transition = updateTransition(targetState = pictureState, label = "")
    val imageSizeDp by transition.animateDp(targetValueByState = { it.siz }, label = "")
    val color by transition.animateColor(targetValueByState = { it.color }, label = "")
    val borderWidth by transition.animateDp(targetValueByState = { it.borderSize }, label = "")
    Column {
        Row {
            Card(
                modifier = Modifier.padding(16.dp),
                shape = CircleShape,
                border = BorderStroke(
                    width = borderWidth,
                    color = color
                )
            ) {
                Image(
                    painter = rememberImagePainter(data = mealResponse.imageUrl,
                        builder = {
                            transformations(CircleCropTransformation())
                        }),
                    contentDescription = null,
                    modifier = Modifier
                        .size(imageSizeDp)
                        .padding(8.dp)
                )
            }
            Text(
                text = mealResponse.name,
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterVertically)
            )
        }

        Button(modifier = Modifier.padding(16.dp), onClick = {
            pictureState =
                if (pictureState == MealDetailPictureState.NORMAL) MealDetailPictureState.EXPANDED else MealDetailPictureState.NORMAL
        }) {
            Text(text = "Change state of meal profile picture")
        }

    }
}

enum class MealDetailPictureState(val color: Color, val siz: Dp, val borderSize: Dp) {
    NORMAL(Color.Magenta, 120.dp, 8.dp),
    EXPANDED(Color.Green, 200.dp, 24.dp)
}