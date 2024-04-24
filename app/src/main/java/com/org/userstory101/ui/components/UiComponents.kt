package com.org.userstory101.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.org.userstory101.R
import com.org.userstory101.ui.navigation.NavigationRoute
import com.org.userstory101.ui.theme.GreenA
import com.org.userstory101.ui.theme.h3_black
import com.org.userstory101.ui.theme.h4_bold
import com.org.userstory101.ui.theme.h6_black
import com.org.userstory101.ui.theme.h6_bold
import com.org.userstory101.ui.theme.h7_bold
import com.org.userstory101.ui.theme.h8_black
import com.org.userstory101.utils.Constants


@Composable
fun BottomNavBar(modifier: Modifier = Modifier, navController: NavController) {
    NavigationBar(containerColor = Color.White) {
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry.value?.destination?.route

        NavigationBarItem(
            selected = currentRoute == NavigationRoute.HomeScreen.name,
            onClick = {
                navController.navigate(NavigationRoute.HomeScreen.name) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            label = { Text(text = Constants.HOME) },
            icon = {
                if (currentRoute == NavigationRoute.HomeScreen.name) {
                    Icon(
                        painter = painterResource(id = R.drawable.home_filled),
                        contentDescription = Constants.HOME,
                        tint = Color(0xFF043c18),
                        modifier = modifier.size(20.dp)
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.home),
                        contentDescription = Constants.HOME,
                        tint = Color(0xFF6b6b6b),
                        modifier = modifier.size(20.dp)
                    )
                }
            })

        NavigationBarItem(
            selected = currentRoute == NavigationRoute.LockerScreen.name,
            onClick = {
                navController.navigate(NavigationRoute.LockerScreen.name) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            label = { Text(text = Constants.LOCKER) },
            icon = {
                if (currentRoute == NavigationRoute.LockerScreen.name) {
                    Icon(
                        painter = painterResource(id = R.drawable.vault_filled),
                        contentDescription = Constants.LOCKER,
                        tint = Color(0xFF043c18),
                        modifier = modifier.size(20.dp)
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.vault),
                        contentDescription = Constants.LOCKER,
                        tint = Color(0xFF6b6b6b),
                        modifier = modifier.size(20.dp)
                    )
                }
            })

        NavigationBarItem(
            selected = currentRoute == NavigationRoute.RentScreen.name,
            onClick = {
                navController.navigate(NavigationRoute.RentScreen.name) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            label = { Text(text = Constants.RENT) },
            icon = {
                if (currentRoute == NavigationRoute.RentScreen.name) {
                    Icon(
                        painter = painterResource(id = R.drawable.lock_filled),
                        contentDescription = Constants.RENT,
                        tint = Color(0xFF043c18),
                        modifier = modifier.size(20.dp)
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.lock),
                        contentDescription = Constants.LOCKER,
                        tint = Color(0xFF6b6b6b),
                        modifier = modifier.size(20.dp)
                    )
                }
            })

        NavigationBarItem(
            selected = currentRoute == NavigationRoute.AdvertScreen.name,
            onClick = {
                navController.navigate(NavigationRoute.AdvertScreen.name) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            label = { Text(text = Constants.ADVERT) },
            icon = {
                if (currentRoute == NavigationRoute.AdvertScreen.name) {
                    Icon(
                        painter = painterResource(id = R.drawable.newspaper_filled),
                        contentDescription = Constants.ADVERT,
                        tint = Color(0xFF043c18),
                        modifier = modifier.size(20.dp)
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.newspaper),
                        contentDescription = Constants.ADVERT,
                        tint = Color(0xFF6b6b6b),
                        modifier = modifier.size(20.dp)
                    )
                }
            })

        NavigationBarItem(
            selected = currentRoute == NavigationRoute.AccountScreen.name,
            onClick = {
                navController.navigate(NavigationRoute.AccountScreen.name) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            label = { Text(text = Constants.ACCOUNT) },
            icon = {
                if (currentRoute == NavigationRoute.AccountScreen.name) {
                    Icon(
                        painter = painterResource(id = R.drawable.user_filled),
                        contentDescription = Constants.ADVERT,
                        tint = Color(0xFF043c18),
                        modifier = modifier.size(20.dp)
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.user),
                        contentDescription = Constants.ADVERT,
                        tint = Color(0xFF6b6b6b),
                        modifier = modifier.size(20.dp)
                    )
                }
            })
    }
}

@Composable
fun PopUpDialog(modifier: Modifier = Modifier, onClick: () -> Unit = {}) {
    Column(
        modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(shape = RoundedCornerShape(12.dp))
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = modifier.height(16.dp))
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
        ) {
            Text(
                text = "Your Gateway to Convenience!",
                style = h4_bold,
                color = GreenA
            )
            Spacer(modifier = modifier.width(70.dp))
            Icon(
                painter = painterResource(id = R.drawable.cross_small),
                contentDescription = "Cancel",
                modifier = modifier.clickable { }
            )
        }
        Spacer(modifier = modifier.height(16.dp))
        Card(
            modifier
                .height(200.dp)
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.interior_photo),
                contentDescription = null,
                modifier = modifier.fillMaxWidth(),
                contentScale = ContentScale.FillBounds
            )
        }
        Spacer(modifier = modifier.height(16.dp))
        Text(
            text = "Explore the world of locker services with HubLocker",
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 20.dp),
            style = h4_bold
        )
        Spacer(modifier = modifier.height(16.dp))
        Text(
            text = "Learn how locker services work",
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 20.dp),
            style = h6_black
        )
        Spacer(modifier = modifier.height(16.dp))
    }
}

@Composable
fun PackageButton(
    modifier: Modifier = Modifier,
    icon: Int,
    trail: Int,
    isDelivered: Boolean = true
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color.White),
    ) {
        Row(
            modifier
                .fillMaxSize()
                .background(Color.White),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Spacer(modifier = modifier.width(16.dp))
            Box(
                modifier = modifier
                    .size(40.dp)
                    .clip(shape = RoundedCornerShape(40.dp))
                    .background(color = if (isDelivered) Color(0xFFe7f0ea) else Color(0xFFffebea)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = "",
                    modifier = modifier.size(16.dp),
                    tint = if (isDelivered) Color(0xFF043c18) else Color(0xFFf24a47)
                )
            }
            Spacer(modifier = modifier.width(16.dp))
            Column(modifier = modifier.width(149.dp)) {
                Text(
                    text = if (isDelivered) "Delivered Packages" else "Pending Packages",
                    style = h6_bold
                )
                Text(text = if (isDelivered) "5" else "6", style = h4_bold)
            }
            Spacer(modifier = modifier.width(98.dp))
            Icon(painter = painterResource(id = trail), contentDescription = "")
            Spacer(modifier = modifier.width(16.dp))
        }
    }
}

@Composable
fun Chip(modifier: Modifier = Modifier, isDelivered: Boolean = true, text: String) {
    Card(shape = RoundedCornerShape(40.dp)) {
        Row(
            modifier = modifier
                .height(40.dp)
                .wrapContentWidth()
                .background(color = Color(0xFFf3f4f6))
                .clip(shape = RoundedCornerShape(40.dp)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = modifier.width(10.dp))
            Box(
                modifier
                    .size(10.dp)
                    .clip(shape = RoundedCornerShape(10.dp))
                    .background(if (isDelivered) Color(0xFF043c18) else Color(0xFFf24a47))
            )
            Spacer(modifier = modifier.width(10.dp))
            Text(text = text, style = h8_black)
            Spacer(modifier = modifier.width(10.dp))
        }
    }
}

@Composable
fun ChipFilter(modifier: Modifier = Modifier, text: String, onSelectedChange: (Boolean) -> Unit) {
    var selected by remember {
        mutableStateOf(false)
    }
    Card(
        shape = CircleShape,
        border = BorderStroke(width = 1.dp, color = Color.Gray),
        modifier = modifier
            .wrapContentWidth()
            .height(40.dp)
            .clickable {
                selected = !selected
            }
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .clip(CircleShape)
                .background(color = if (selected) GreenA else Color.White)
        ) {
            Spacer(modifier = modifier.width(20.dp))
            Text(
                text = text,
                modifier = modifier.padding(10.dp),
                style = h7_bold,
                color = if (selected) Color.White else GreenA
            )
            Spacer(modifier = modifier.width(20.dp))
        }
    }
    onSelectedChange(selected)
}

@Composable
fun Button(modifier: Modifier = Modifier, text: String, onClick: () -> Unit) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color(0xFF043c18)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = text,
                style = h4_bold,
                color = Color.White,
            )
        }
    }
}

@Composable
fun CustomTopBar(modifier: Modifier = Modifier, onClick: () -> Unit, title: String) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(color = GreenA), verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = modifier.width(16.dp))
        Text(text = title, style = h3_black, color = Color.White)
        Spacer(modifier = modifier.width(200.dp))
        Icon(
            painter = painterResource(id = R.drawable.bars_filter),
            contentDescription = "",
            modifier = modifier
                .size(20.dp)
                .clickable {
                    onClick()
                },
            tint = Color.White
        )
    }
}

@Composable
fun Benefits(main: String) {
    Row() {
        Icon(imageVector = Icons.Default.Check, contentDescription = "")
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = main, style = h6_bold)
    }
}

@Composable
fun CustomDialogDemo(modifier: Modifier = Modifier, showDialog: Boolean) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showDialog) {
            Dialog(
                onDismissRequest = { !showDialog },
                content = {
                    Column(
                        modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .clip(shape = RoundedCornerShape(12.dp))
                            .background(Color.White),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = modifier.height(16.dp))
                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            modifier = modifier
                                .fillMaxWidth()
                                .padding(start = 20.dp, end = 20.dp)
                        ) {
                            Text(
                                text = "Your Gateway to Convenience!",
                                style = h4_bold,
                                color = GreenA
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.cross_small),
                                contentDescription = "Cancel",
                                modifier = modifier.clickable { !showDialog }
                            )
                        }
                        Spacer(modifier = modifier.height(16.dp))
                        Card(
                            modifier
                                .height(200.dp)
                                .fillMaxWidth()
                                .padding(start = 20.dp, end = 20.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.interior_photo),
                                contentDescription = null,
                                modifier = modifier.fillMaxWidth(),
                                contentScale = ContentScale.FillBounds
                            )
                        }
                        Spacer(modifier = modifier.height(16.dp))
                        Text(
                            text = "Explore the world of locker services with HubLocker",
                            modifier = modifier
                                .fillMaxWidth()
                                .padding(start = 20.dp),
                            style = h4_bold
                        )
                        Spacer(modifier = modifier.height(16.dp))
                        Text(
                            text = "Learn how locker services work",
                            modifier = modifier
                                .fillMaxWidth()
                                .padding(start = 20.dp),
                            style = h6_black
                        )
                        Spacer(modifier = modifier.height(16.dp))
                    }
                }
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun Check() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        PopUpDialog()
    }
}