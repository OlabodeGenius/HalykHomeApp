package com.example.halyk.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.halyk.R
import com.example.halyk.data.Datasource
import com.example.halyk.model.Bonus
import com.example.halyk.model.Currency
import com.example.halyk.model.Features
import com.example.halyk.ui.theme.corraFontFamily

@Composable
fun Home(
    modifier: Modifier = Modifier
) {
    AppLayout()
}

@Composable
fun AppLayout() {
    Column(
        verticalArrangement = Arrangement.spacedBy(18.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.light_gray))
    ) {

        FirstSection(Modifier.padding(start = 20.dp, top = 10.dp, end = 20.dp))
        BonusesSection(bonuses = Datasource().loadBonusDetails())
        Searchbar()
        FeaturesSection(features = Datasource().loadFeatures())
        BannerImageSection()
        CurrencySection(currencies = Datasource().loadCurrencies())

    }

}

@Composable
fun FirstSection(
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
    ) {

        Image(
            painter = painterResource(R.drawable.o3e_logo),
            contentDescription = "logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .size(50.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp),
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "Bonuses",
                fontSize = 12.sp,
                fontFamily = corraFontFamily,
                fontWeight = FontWeight.Bold,
                color = Color.Gray,
            )

            Text(
                text = "31.4b",
                fontSize = 20.sp,
                fontFamily = corraFontFamily,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

        }//end of inner column

        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .size(50.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.chat),
                contentDescription = "chat",
                tint = colorResource(id = R.color.primary_green),
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxSize()



            )

        }

    }// end of outer row

}

@Composable
fun BonusesSection(
    bonuses: List<Bonus>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(
            start = 20.dp,
            end = 20.dp
        )
    ) {
        items(bonuses) { item ->
            BonusesSectionItem(
                item, modifier
            )

        }
    }
}

@Composable
fun BonusesSectionItem(
    bonus: Bonus,
    modifier: Modifier = Modifier
) {

    Box(
        modifier = Modifier
    ) {

        Image(
            painter = painterResource(bonus.image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(8.dp))
        )

    }

}

@Composable
fun Searchbar() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        shape = RoundedCornerShape(13.dp),
        leadingIcon = {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.search),
                contentDescription = null,
                tint = Color.Gray,
                modifier = Modifier
            )
        },
        placeholder = {
            Text(
                text = "Search",
                fontFamily = corraFontFamily,
                fontWeight = FontWeight.Medium
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp)

    )

}


@Composable
fun FeaturesSection(
    features: List<Features>,
    modifier: Modifier = Modifier
) {

    Card(
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(Color.White),
        modifier = Modifier
            .padding(horizontal = 18.dp)
    ) {

        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            modifier = Modifier.padding(horizontal = 0.dp),
            content = {
                items(features) { item ->
                    FeaturesSectionItem(
                        item, modifier
                            .padding(vertical = 10.dp)
                    )

                }
            }
        )
    }


}

@Composable
fun FeaturesSectionItem(
    features: Features,
    modifier: Modifier = Modifier
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(features.icon),
            contentDescription = null,
            tint = colorResource(R.color.primary_green),
            modifier = Modifier
                .size(30.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = stringResource(features.title),
            color = Color.Black,
            fontSize = 12.sp,
            fontFamily = corraFontFamily,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun BannerImageSection(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(R.drawable.header_image),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .fillMaxWidth()

    )

}

@Composable
fun CurrencySection(
    currencies: List<Currency>,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = 18.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Exchange Rates",
                color = Color.Black,
                fontSize = 16.sp,
                fontFamily = corraFontFamily,
                fontWeight = FontWeight.Bold,
            )

            Text(
                text = "All courses",
                color = colorResource(R.color.primary_green),
                fontSize = 16.sp,
                fontFamily = corraFontFamily,
                fontWeight = FontWeight.Bold,
            )

        } //end of the inner row

        Spacer(modifier = Modifier.height(10.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(start = 18.dp, end = 18.dp),
            content = {
            items(currencies){ item ->
                CurrencySectionItem(currency = item, modifier)

            }
        }
        )
    } //end of the column
}


@Composable
fun CurrencySectionItem(
    currency: Currency,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(Color.White),
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .padding(15.dp)

        ) {
            Icon(
                imageVector = ImageVector.vectorResource(currency.currencyIcon),
                contentDescription = null,
                tint = Color.Gray,
                modifier = Modifier
                    .size(16.dp)
            )

            Text(
                text = stringResource(currency.currencyValue),
                fontSize = 18.sp,
                fontFamily = corraFontFamily,
                fontWeight = FontWeight.SemiBold
            )
        }

    }
    
}


@Preview(showBackground = true)
@Composable
fun HalykAppPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        AppLayout()
    }

}
