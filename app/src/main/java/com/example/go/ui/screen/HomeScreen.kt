package com.example.go.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.go.R
import com.example.go.ui.theme.GoTheme


/** Scaffold */
/** TopAppBar */
/** BottomAppBar */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfoAppScaffold() {
    Scaffold(modifier = Modifier,
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colorScheme.background),
                title = {},
                actions = {
                    IconButton({ }) {
                        Icon(
                            painterResource(R.mipmap.ic_launcher_foreground),
                            modifier = Modifier.size(24.dp),
                            contentDescription = "QR"
                        )
                    }
                },
                navigationIcon = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "Moscow")
                        IconButton(onClick = {}) {
                            Icon(Icons.Filled.ArrowDropDown, contentDescription = "Choosing a city")
                        }
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    IconButton(onClick = {}, modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)) {
                        Icon(
                            painter = painterResource(R.mipmap.ic_menu),
                            modifier = Modifier,
                            contentDescription = "Menu"
                        )
                    }
                    IconButton(onClick = {}, modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)) {
                        Icon(
                            painter = painterResource(R.mipmap.ic_profile_foreground),
                            modifier = Modifier,
                            contentDescription = "Profile"
                        )
                    }
                    IconButton(onClick = {}, modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)) {
                        Icon(
                            painter = painterResource(R.mipmap.ic_trash_foreground),
                            modifier = Modifier,
                            contentDescription = "Trash"
                        )
                    }

                }
            }
        }
    ) { innerPaddingValues ->
        HomeScreen(innerPaddingValues)
    }
}


/** Итоговый экран */
@Composable
fun HomeScreen(
    innerPaddingValues: PaddingValues,
    modifier: Modifier = Modifier,
) {
    Column(modifier = Modifier.padding(innerPaddingValues)) {
        Banners()
        BodyCategories()
        BodyMenu()
    }
}


/** Банеры */
@Composable
fun Banners(modifier: Modifier = Modifier.fillMaxWidth()) {
    LazyRow(
        modifier = modifier
            .height(112.dp)
            .width(300.dp)
    ) {
        items(1) {
            Image(painter = painterResource(R.drawable.banner_1), contentDescription = "Banner1")
            Image(painter = painterResource(R.drawable.banner_2), contentDescription = "Banner2")
        }
    }
}


/** Основное тело rатегорий товара */
@Composable
fun BodyCategories(modifier: Modifier = Modifier) {
    LazyRow(
        modifier
            .height(40.dp)
            .background(Color.White)
    ) {
        item {
            Box(
                modifier.background(colorResource(R.color.h))
            ) {
                Category(color = colorResource(R.color.hex))
            }
        }
        items(20) {
            Category(color = Color.Gray)
        }
    }
}

/** Ячейка категории, удалить тестовый текст*/
@Composable
fun Category(color: Color) {
    Box(
        modifier = Modifier
            .height(40.dp)
            .width(88.dp), contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Пицца", fontSize = 13.sp, color = color
        )
    }
}

/** Основное тело меню, удалить тестовый текст */
@Composable
fun BodyMenu(modifier: Modifier = Modifier.fillMaxWidth()) {
    LazyColumn {
        items(20) { Product() }
    }
}

/** Ячейка продукта, удалить background и тестовый текст*/
@Composable
fun Product(
    modifier: Modifier = Modifier.background(Color.White)

) {
    Row(modifier) {
        Image(
            painter = painterResource(R.drawable.buff),
            contentDescription = "",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .weight(1f)
                .height(135.dp)
                .width(135.dp)
                .padding(start = 20.dp)
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .height(135.dp)
                .width(171.dp)
                .padding(start = 20.dp, end = 20.dp)
        ) {
            Text(
                modifier = Modifier,
                text = "FOOD mmmmmmm",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Froikj fror ikkjmokrvm jokjmork jmvor kjvorkj movkirjm " + "orekjm orkvmo rkvmro knmo",
                color = Color.Gray,
                fontSize = 10.sp,
                modifier = Modifier
            )

            Box(
                modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.BottomEnd
            ) {
                Box(
                    modifier = Modifier
                        .shadow(
                            elevation = 10.dp, shape = RoundedCornerShape(8.dp)
                        )
                        .background(Color.Red)
                ) {
                    Text(
                        text = "12354 руб",
                        color = Color.White,
                        textAlign = TextAlign.End,
                        fontSize = 10.sp,
                        modifier = Modifier
                    )
                }
            }
        }
    }
}

/** Превьюха */
@Preview
@Composable
fun Preview() {
    GoTheme {
    }
}