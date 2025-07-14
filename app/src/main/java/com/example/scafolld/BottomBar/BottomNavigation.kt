package com.example.scafolld.BottomBar

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.example.bottombar.AnimatedBottomBar
import com.example.bottombar.components.BottomBarItem
import com.example.bottombar.model.IndicatorDirection
import com.example.bottombar.model.IndicatorStyle

data class BottomNavItem(
    val name: String,
    val icon: ImageVector,val unselectedIcon: ImageVector
)

@Composable
fun BottomNavigationAnimated() {
    var selectedItem by remember { mutableStateOf(0) }

    val bottomNavItems = listOf(
        BottomNavItem(
            "Home", Icons.Default.Home,
            unselectedIcon = Icons.Default.Home
        ),
        BottomNavItem(
            "Wishlist", Icons.Default.Favorite,
            unselectedIcon =Icons.Default.Favorite
        ),
        BottomNavItem(
            "Cart", Icons.Default.ShoppingCart,
            unselectedIcon =  Icons.Default.ShoppingCart
        ),
        BottomNavItem(
            "Profile", Icons.Default.Person,
            unselectedIcon = Icons.Default.Person
        )
    )

    Scaffold(
        bottomBar = {
            Surface(
                modifier = Modifier.fillMaxSize().padding(
                  bottom =WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()
                )

            ){
               AnimatedBottomBar(
                selectedItem = selectedItem,
                itemSize = bottomNavItems.size,
                modifier = Modifier.fillMaxWidth(),
                containerColor = Color.White,
                indicatorColor = MaterialTheme.colorScheme.primary,
                indicatorDirection = IndicatorDirection.TOP,
                indicatorStyle = IndicatorStyle.LINE
            ) {
                   bottomNavItems.forEachIndexed { index, navigationItem ->
                       BottomBarItem(
                           modifier = Modifier.align(alignment = Alignment.Top),
                           selected = selectedItem == index,
                           onClick = {
                               selectedItem = index
                               when (index) {
                                 //Screen call
                               }
                           },
                           imageVector = navigationItem.icon,
                           label = navigationItem.name,
                           containerColor = Color.Transparent
                       )
                   }
               }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Selected: ${bottomNavItems[selectedItem].name}")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AnimatedBottomBarPreview() {
    BottomNavigationAnimated()
}
