package com.example.halyk

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.halyk.data.Datasource
import com.example.halyk.model.BottomNavItem
import com.example.halyk.screens.Accounts
import com.example.halyk.screens.Home
import com.example.halyk.screens.Menu
import com.example.halyk.screens.Payments
import com.example.halyk.screens.Transfers
import com.example.halyk.ui.theme.corraFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreensHandler(
    modifier: Modifier = Modifier
) {
    var selected by remember {
        mutableIntStateOf(0)
    }
    val bottomNavItems = listOf<BottomNavItem>(
        BottomNavItem(
            title = "Main",
            selectedIcon = ImageVector.vectorResource(R.drawable.home),
            unSelectedIcon = ImageVector.vectorResource(R.drawable.home_grey),
            hasNotification = false
        ),
        BottomNavItem(
            title = "Accounts",
            selectedIcon = ImageVector.vectorResource(R.drawable.accounts),
            unSelectedIcon = ImageVector.vectorResource(R.drawable.accounts_grey),
            hasNotification = false
        ),
        BottomNavItem(
            title = "Transfers",
            selectedIcon = ImageVector.vectorResource(R.drawable.transfer),
            unSelectedIcon = ImageVector.vectorResource(R.drawable.transfers_grey),
            hasNotification = false
        ),
        BottomNavItem(
            title = "Payments",
            selectedIcon = ImageVector.vectorResource(R.drawable.payment),
            unSelectedIcon = ImageVector.vectorResource(R.drawable.payments_grey),
            hasNotification = false
        ),
        BottomNavItem(
            title = "Menu",
            selectedIcon = ImageVector.vectorResource(R.drawable.menu),
            unSelectedIcon = ImageVector.vectorResource(R.drawable.menu_grey),
            hasNotification = true
        ),
    )


    Scaffold(
        bottomBar = {
            NavigationBar(
                contentColor = Color.Black,
                containerColor = Color.White,
                tonalElevation = 8.dp,
                windowInsets = NavigationBarDefaults.windowInsets
            ) {
                bottomNavItems.forEachIndexed { index, bottomNavItem ->
                    NavigationBarItem(
                        selected = selected == index,
                        onClick = {
                            selected = index
                        },
                        icon = {
                            BadgedBox(
                                badge = {
                                    if (bottomNavItem.hasNotification)
                                        Badge()
                                }
                            ) {
                                Icon(
                                    imageVector =
                                    if (index == selected) {
                                        bottomNavItem.selectedIcon

                                    } else {
                                        bottomNavItem.unSelectedIcon
                                    },
                                    contentDescription = bottomNavItem.title
                                )
                            }
                        },
                        label = {
                            Text(
                                text = bottomNavItem.title,
                                fontFamily = corraFontFamily,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        ScreenItem(selectedIndex = selected , modifier = modifier.padding(innerPadding))
    }

}

@Composable
fun ScreenItem(
    selectedIndex: Int,
    modifier: Modifier = Modifier
) {
   when(selectedIndex) {
       0 -> Home()
       1 -> Accounts()
       2 -> Transfers()
       3 -> Payments()
       4 -> Menu()
   }


}

@Preview(showBackground = true)
@Composable
fun ScreensHandlerPreview() {
    ScreensHandler()
}