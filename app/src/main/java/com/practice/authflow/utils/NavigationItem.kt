package com.practice.authflow.utils

import com.practice.authflow.R


sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    data object Home : NavigationItem("home", R.drawable.ic_home, "Home")
    data object Orders : NavigationItem("music", R.drawable.ic_orders, "Orders")
    data object Deals : NavigationItem("movies", R.drawable.ic_deals, "Deals")
    data object Account : NavigationItem("books", R.drawable.ic_account, "Account")

}