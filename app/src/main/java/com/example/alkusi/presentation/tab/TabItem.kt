package com.example.alkusi.presentation.tab

import androidx.compose.ui.graphics.vector.ImageVector

data class TabItem(val title: String,val selectedIcon:ImageVector,val unselectedIcon: ImageVector,val hasNotification: Boolean = false,val badgeCount: Int? = null )
