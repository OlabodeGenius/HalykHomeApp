package com.example.halyk.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Menu
import com.example.halyk.R
import com.example.halyk.model.Bonus
import com.example.halyk.model.BottomNavItem
import com.example.halyk.model.Currency
import com.example.halyk.model.Features

class Datasource {
    fun loadBonusDetails(): List<Bonus> {
        return listOf(
            Bonus(R.drawable.banner_1),
            Bonus(R.drawable.banner_2),
            Bonus(R.drawable.banner_3),
            Bonus(R.drawable.banner_4),
        )
    }


    fun loadFeatures(): List<Features> {
        return listOf(
            Features(R.drawable.cards, R.string.cards),
            Features(R.drawable.deposit, R.string.deposits),
            Features(R.drawable.loans, R.string.Loans),
            Features(R.drawable.installment, R.string.installment),
            Features(R.drawable.kino_kz, R.string.kino_kz),
            Features(R.drawable.travel, R.string.travel),
            Features(R.drawable.insurance, R.string.insurance),
            Features(R.drawable.market, R.string.market),
            Features(R.drawable.info, R.string.info),
            Features(R.drawable.gov, R.string.gov_service),
            Features(R.drawable.invest, R.string.invest),
            Features(R.drawable.qr, R.string.qr_code),
        )
    }

    fun loadCurrencies(): List<Currency> {
        return listOf(
            Currency(R.drawable.baseline_currency_pound_24, R.string.currency_value1),
            Currency(R.drawable.baseline_currency_yuan_24, R.string.currency_value1),
            Currency(R.drawable.baseline_currency_rupee_24, R.string.currency_value1),
            Currency(R.drawable.baseline_currency_franc_24, R.string.currency_value1),
            Currency(R.drawable.baseline_currency_yen_24, R.string.currency_value1),
            Currency(R.drawable.baseline_currency_pound_24, R.string.currency_value1),
        )
    }

//    val bottomNavItems = listOf<BottomNavItem>(
//        BottomNavItem(
//            title = "Main",
//            selectedIcon = Icons.Filled.Home,
//            unSelectedIcon = Icons.Outlined.Home,
//            hasNotification = false
//        ),
//        BottomNavItem(
//            title = "Accounts",
//            selectedIcon = Icons.Filled.AccountBox,
//            unSelectedIcon = Icons.Outlined.AccountBox,
//            hasNotification = false
//        ),
//        BottomNavItem(
//            title = "Transfers",
//            selectedIcon = Icons.Filled.ArrowForward,
//            unSelectedIcon = Icons.Outlined.ArrowForward,
//            hasNotification = false
//        ),
//        BottomNavItem(
//            title = "Payments",
//            selectedIcon = Icons.Filled.AccountBox,
//            unSelectedIcon = Icons.Outlined.AccountBox,
//            hasNotification = false
//        ),
//        BottomNavItem(
//            title = "Menu",
//            selectedIcon = Icons.Filled.Menu,
//            unSelectedIcon = Icons.Outlined.Menu,
//            hasNotification = true
//        ),
//        )
}