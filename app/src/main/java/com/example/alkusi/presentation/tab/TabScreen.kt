package com.example.alkusi.presentation.tab

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Update
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Chat
import androidx.compose.material.icons.outlined.People
import androidx.compose.material.icons.outlined.Update
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.example.alkusi.presentation.calls.Calls
import com.example.alkusi.presentation.chats.Chats
import com.example.alkusi.presentation.communities.Communities
import com.example.alkusi.presentation.updates.Updates
import com.example.alkusi.util.Constants.ZERO_INT

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TabScreen() {
    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(ZERO_INT)
    }
    val items = listOf(
        TabItem(
            title = "Chats",
            selectedIcon = Icons.Filled.Chat,
            unselectedIcon = Icons.Outlined.Chat,
            hasNotification = false
        ),
        TabItem(
            title = "Updates",
            selectedIcon = Icons.Filled.Update,
            unselectedIcon = Icons.Outlined.Update,
            hasNotification = false
        ),
        TabItem(
            title = "Communities",
            selectedIcon = Icons.Filled.People,
            unselectedIcon = Icons.Outlined.People,
            hasNotification = false
        ),
        TabItem(
            title = "Calls",
            selectedIcon = Icons.Filled.Call,
            unselectedIcon = Icons.Outlined.Call,
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
                                Badge { Text(text = item.badgeCount.toString()) }
                            } else if (item.hasNotification) {
                                Badge()
                            }
                        })
                        {
                            Icon(
                                imageVector = if (index == selectedItemIndex) item.selectedIcon else item.unselectedIcon,
                                contentDescription = item.title
                            )
                        }
                    })
            }
        }
    }) {
        when (selectedItemIndex) {
            0 -> Chats()
            1 -> Updates()
            2 -> Communities()
            3 -> Calls()
            else -> Chats()
        }

    }


}