package com.example.alkusi.presentation.tab

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountTree
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Feed
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LiveTv
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.More
import androidx.compose.material.icons.filled.Note
import androidx.compose.material.icons.outlined.AccountTree
import androidx.compose.material.icons.outlined.Feed
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LiveTv
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.More
import androidx.compose.material.icons.outlined.Note
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import com.example.alkusi.presentation.alkusi.AlkusiScreen
import com.example.alkusi.presentation.feed.FeedScreen
import com.example.alkusi.presentation.home.HomeScreen
import com.example.alkusi.presentation.more.MoreScreen
import com.example.alkusi.presentation.navgraph.Route
import com.example.alkusi.util.Constants.ZERO_INT

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TabScreen() {
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(ZERO_INT)
    }
    val items = listOf(
        TabItem(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasNotification = false
        ),
        TabItem(
            title = "Feed",
            selectedIcon = Icons.Filled.Feed,
            unselectedIcon = Icons.Outlined.Feed,
            hasNotification = false
        ),
        TabItem(
            title = "Alkusi",
            selectedIcon = Icons.Filled.AccountTree,
            unselectedIcon = Icons.Outlined.AccountTree,
            hasNotification = false
        ),
        TabItem(
            title = "More",
            selectedIcon = Icons.Filled.More,
            unselectedIcon = Icons.Outlined.More,
            hasNotification = false
        )
    )
    Scaffold(bottomBar = {
        NavigationBar {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = selectedItemIndex == index,
                    onClick = { selectedItemIndex = index },
                    label = {
                        Text(
                            text = item.title
                        )
                    },
                    alwaysShowLabel = true,
                    icon = {
                        BadgedBox(badge = {
                            if (item.badgeCount != null) {
                                Badge{Text(text = item.badgeCount.toString())}
                            } else if (item.hasNotification) {
                                Badge()
                            }
                        })
                        {
                            Icon(imageVector = if(index == selectedItemIndex) item.selectedIcon else item.unselectedIcon, contentDescription = item.title )
                        }
                    })
            }
        }
    }) {
        when (selectedItemIndex) {
            0 -> HomeScreen()
            1 -> FeedScreen()
            2 -> AlkusiScreen()
            3 -> MoreScreen()
            else -> HomeScreen()
        }

    }


}