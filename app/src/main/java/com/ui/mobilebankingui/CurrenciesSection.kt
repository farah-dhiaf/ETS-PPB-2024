package com.ui.mobilebankingui

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.Coffee
import androidx.compose.material.icons.rounded.CurrencyPound
import androidx.compose.material.icons.rounded.CurrencyRupee
import androidx.compose.material.icons.rounded.CurrencyYen
import androidx.compose.material.icons.rounded.CurrencyYuan
import androidx.compose.material.icons.rounded.Euro
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.IceSkating
import androidx.compose.material.icons.rounded.Icecream
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material.icons.rounded.LocalPizza
import androidx.compose.material.icons.rounded.PhoneAndroid
import androidx.compose.material.icons.rounded.RamenDining
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ui.mobilebankingui.data.Currency
import com.ui.mobilebankingui.ui.theme.GreenStart

val currencies = listOf(
    Currency(
        name = "House",
        price = 37.89f,
        date = "12/04/24",
        icon = Icons.Rounded.Home
    ),
    Currency(
        name = "Smartphone",
        price = 32.89f,
        date = "13/04/24",
        icon = Icons.Rounded.PhoneAndroid
    ),
    Currency(
        name = "Food",
        price = 32.89f,
        date = "13/04/24",
        icon = Icons.Rounded.LocalPizza
    ),
    Currency(
        name = "Food",
        price = 37.89f,
        date = "13/04/24",
        icon = Icons.Rounded.RamenDining
    ),
    Currency(
        name = "Food",
        price = 37.89f,
        date = "13/04/24",
        icon = Icons.Rounded.Coffee
    ),
    Currency(
        name = "Sport",
        price = 37.89f,
        date = "13/04/24",
        icon = Icons.Rounded.IceSkating
    )
)

@Preview
@Composable
fun CurrenciesSection() {
    var isVisible by remember {
        mutableStateOf(false)
    }
    var iconState by remember {
        mutableStateOf(Icons.Rounded.KeyboardArrowUp)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 32.dp),
        contentAlignment = Alignment.BottomCenter
    )
    {

    Column (
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(Color(0xFF1A2B2E))
            .animateContentSize()
    ) {
        Row (
            modifier = Modifier
                .padding(16.dp)
                .animateContentSize()
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(modifier = Modifier
                .clip(CircleShape)
                .background(Color(0xFF1A2B2E))
                .clickable {
                    isVisible = !isVisible
                    iconState = if (isVisible) {
                        Icons.Rounded.KeyboardArrowDown
                    } else {
                        Icons.Rounded.KeyboardArrowUp
                    }
                }
            ){
                Icon(
                    modifier = Modifier.size(25.dp),
                    imageVector = iconState,
                    contentDescription = "Currencies",
                    tint = MaterialTheme.colorScheme.onSecondary
                )
            }

            Spacer(modifier = Modifier.width(20.dp))

            Text(
                text = "Transactions",
                fontSize = 20.sp,
                color = Color(0xFFFFFFFF),
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier
            .height(1.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.secondaryContainer)
        )

        if(isVisible) {
            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .padding(top = 10.dp)
                    .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                    .background(Color(0xFFFFFFFF))
            ) {
                val boxWithConstraintsScope = this
                val width = boxWithConstraintsScope.maxWidth / 3

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            modifier = Modifier.width(width),
                            text = "Details",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            color = MaterialTheme.colorScheme.onBackground
                        )

                        Text(
                            modifier = Modifier.width(width),
                            text = "Price",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            color = MaterialTheme.colorScheme.onBackground,
                            textAlign = TextAlign.End
                        )

                        Text(
                            modifier = Modifier.width(width),
                            text = "Date",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            color = MaterialTheme.colorScheme.onBackground,
                            textAlign = TextAlign.End
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    LazyColumn {
                        items(currencies.size) { index ->
                            CurrencyItem(
                                index = index,
                                width = width
                            )
                        }
                    }
                }
            }
        }
        }
    }
}

@Composable
fun CurrencyItem(
    index:Int,
    width : Dp
) {
    val currency = currencies[index]

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ){

        Row (
            modifier = Modifier.width(width),
            verticalAlignment = Alignment.CenterVertically
        ) {


            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFF1A2B2E))
                    .padding(4.dp)
            ) {
                Icon(
                    modifier = Modifier.size(18.dp),
                    imageVector = currency.icon,
                    contentDescription = currency.name,
                    tint = Color.White
                )
            }

            Text(
                modifier = Modifier
                    .padding(start = 10.dp),
                text = currency.name,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onBackground,
            )
        }

        Text(
            modifier = Modifier
                .width(width)
                .padding(start = 10.dp),
            text = "-$ ${currency.price}",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.End
        )

        Text(
            modifier = Modifier
                .width(width)
                .padding(start = 10.dp),
            text =  " ${currency.date}",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.End
        )


    }
}






















