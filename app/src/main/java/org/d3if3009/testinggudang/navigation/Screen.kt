package org.d3if3009.testinggudang.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import org.d3if3009.testinggudang.ui.screen.KEY_ID_motor


sealed class Screen (val route: String) {
    data object  Home: Screen("mainScreen")
    data object FormBaru: Screen("detailScreen")

    data object  About: Screen ("aboutScreen")
    data object  Person: Screen ("personScreen")


    data object FormUbah: Screen("detailScreen/{$KEY_ID_motor}") {
        fun withId(id: Long) = "detailScreen/$id"
    }
}