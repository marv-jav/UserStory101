package com.org.userstory101.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.org.userstory101.R
import com.org.userstory101.data.Q1
import com.org.userstory101.data.Q2
import com.org.userstory101.data.Q3
import com.org.userstory101.data.updateFilters
import com.org.userstory101.ui.components.Benefits
import com.org.userstory101.ui.components.BottomNavBar
import com.org.userstory101.ui.components.Button
import com.org.userstory101.ui.components.Chart
import com.org.userstory101.ui.components.Chip
import com.org.userstory101.ui.components.ChipFilter
import com.org.userstory101.ui.components.CustomTopBar
import com.org.userstory101.ui.components.PackageButton
import com.org.userstory101.ui.navigation.NavigationRoute
import com.org.userstory101.ui.theme.GreenA
import com.org.userstory101.ui.theme.h4_bold
import com.org.userstory101.ui.theme.h6_black
import com.org.userstory101.ui.theme.h7_black
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LockerScreen(modifier: Modifier = Modifier, navController: NavController) {
    var openDialog by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()
    var isButtonClicked by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    var isVisible by remember { mutableStateOf(true) }
    var selectedFilters by remember { mutableStateOf(emptyList<String>()) }
    var showPending by remember { mutableStateOf(true) }
    var showDelivered by remember { mutableStateOf(true) }

    var filteredItems: List<Triple<Float, Float, String>>? = Q1 + Q2 + Q3

    if (isButtonClicked) {
        filteredItems = remember(selectedFilters) {
            when {
                selectedFilters.contains("Q1") -> Q1
                selectedFilters.contains("Q2") -> Q2
                selectedFilters.contains("Q3") -> Q3
                else -> emptyList()
            }
        }
    }

    LaunchedEffect(Unit) {
        delay(6000)
        isVisible = false
    }

    Scaffold(
        topBar = {
            CustomTopBar(onClick = { openDialog = true }, title = "Locker Service")
        },
        content = { paddingValues ->
            if (openDialog) {
                ModalBottomSheet(
                    onDismissRequest = { openDialog = false },
                    sheetState = sheetState
                ) {
                    Column(
                        modifier = modifier
                            .padding(start = 24.dp, end = 24.dp)
                            .verticalScroll(
                                rememberScrollState()
                            )
                    ) {
                        Spacer(modifier = modifier.height(16.dp))
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.cross_small),
                                contentDescription = "Close",
                                modifier = modifier.clickable {
                                    openDialog = false
                                }
                            )
                            Spacer(modifier = modifier.height(70.dp))
                            Text(text = "Filter By", style = h4_bold)
                        }
                        Spacer(modifier = modifier.height(20.dp))
                        Text(text = "Year")
                        Spacer(modifier = modifier.height(20.dp))
                        Row {
                            ChipFilter(text = "2024") {}
                            Spacer(modifier = modifier.width(20.dp))
                            ChipFilter(text = "2023") {}
                        }
                        Spacer(modifier = modifier.height(20.dp))
                        Text(text = "Quarterly")
                        Spacer(modifier = modifier.height(20.dp))
                        Row(modifier = modifier.horizontalScroll(rememberScrollState())) {
                            ChipFilter(text = "Q1") { selected ->
                                updateFilters("Q1", selected, selectedFilters) {
                                    selectedFilters = it
                                }
                            }
                            Spacer(modifier = modifier.width(20.dp))
                            ChipFilter(text = "Q2") { selected ->
                                updateFilters("Q2", selected, selectedFilters) {
                                    selectedFilters = it
                                }
                            }
                            Spacer(modifier = modifier.width(20.dp))
                            ChipFilter(text = "Q3") { selected ->
                                updateFilters("Q3", selected, selectedFilters) {
                                    selectedFilters = it
                                }
                            }
                            Spacer(modifier = modifier.width(20.dp))
                            ChipFilter(text = "Q4") { selected ->
                                updateFilters("Q4", selected, selectedFilters) {
                                    selectedFilters = it
                                }
                            }
                        }
                        Spacer(modifier = modifier.height(20.dp))
                        Text(text = "Package Summary")
                        Spacer(modifier = modifier.height(20.dp))
                        Row(modifier = modifier.horizontalScroll(rememberScrollState())) {
                            ChipFilter(text = "Delivered packages") { selected ->
                                showPending = selected
                            }
                            Spacer(modifier = modifier.width(20.dp))
                            ChipFilter(text = "Pending packages") { selected ->
                                showDelivered = selected
                            }
                            Spacer(modifier = modifier.width(20.dp))
                        }
                        Spacer(modifier = modifier.height(40.dp))
                        Button(text = "Save") {
                            isButtonClicked = true
                            scope.launch { sheetState.hide() }.invokeOnCompletion {
                                if (!sheetState.isVisible) {
                                    openDialog = false
                                }
                            }
                        }
                        Spacer(modifier = modifier.height(30.dp))
                    }
                }
            }
            if (isVisible) {
                Dialog(
                    onDismissRequest = { isVisible = false },
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
                                    modifier = modifier.clickable { isVisible = false }
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
            Column(
                modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, top = 24.dp)
                    .verticalScroll(
                        rememberScrollState()
                    )
            ) {
                Spacer(modifier = modifier.height(50.dp))
                Box(
                    modifier = modifier
                        .clip(shape = RoundedCornerShape(10.dp))
                ) {
                    Card(
                        modifier
                            .height(200.dp)
                            .fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.interior_photo),
                            contentDescription = null,
                            modifier = modifier.fillMaxWidth(),
                            contentScale = ContentScale.FillBounds
                        )
                    }
                    Column(
                        modifier = modifier
                            .height(30.dp)
                            .fillMaxWidth()
                            .background(color = Color(0x80000000))
                            .align(Alignment.BottomCenter),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Town Place Apartments", style = h4_bold, color = Color.White)
                    }
                }
                Spacer(modifier = modifier.height(30.dp))
                Text(text = "Package Summary", style = h4_bold)
                Spacer(modifier = modifier.height(10.dp))
                Text(text = "Q1-Q3", style = h7_black)
                Spacer(modifier = modifier.height(16.dp))
                Row {
                    if (showDelivered) {
                        Chip(text = "Delivered packages")
                        Spacer(modifier = modifier.width(16.dp))
                    }
                    Spacer(modifier = modifier.width(16.dp))
                    if (showPending) {
                        Chip(text = "Pending packages", isDelivered = false)
                    }
                }
                Spacer(modifier = modifier.height(30.dp))
                Row(modifier = modifier.horizontalScroll(rememberScrollState())) {
                    if (filteredItems != null) {
                        Chart(
                            data = filteredItems, max_value = 6000,
                            delivered = showDelivered,
                            pending = showPending
                        )
                    }
                }
                Spacer(modifier = modifier.height(20.dp))
                PackageButton(
                    icon = R.drawable.box_open,
                    trail = R.drawable.angle_small_right,
                    isDelivered = true
                )
                Spacer(modifier = modifier.height(16.dp))
                PackageButton(
                    icon = R.drawable.box_open,
                    trail = R.drawable.angle_small_right,
                    isDelivered = false
                )
                Spacer(modifier = modifier.height(100.dp))
            }
        },
        bottomBar = { BottomNavBar(navController = navController) })
}

@Composable
fun RentScreen(modifier: Modifier = Modifier, navController: NavController) {
    Scaffold(
        content = {
            Column(modifier = modifier.padding(it)) {
            }
        },
        bottomBar = { BottomNavBar(navController = navController) }
    )
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier, navController: NavController) {
    Scaffold(
        content = {
            Column(modifier = modifier.padding(it)) {
            }
        },
        bottomBar = { BottomNavBar(navController = navController) }
    )
}

@Composable
fun AdvertScreen(modifier: Modifier = Modifier, navController: NavController) {
    Scaffold(
        content = {
            Column(modifier = modifier.padding(it)) {
            }
        },
        bottomBar = { BottomNavBar(navController = navController) }
    )
}

@Composable
fun AccountScreen(modifier: Modifier = Modifier, navController: NavController) {
    Scaffold(
        content = {
            Column(modifier = modifier.padding(it)) {
            }
        },
        bottomBar = { BottomNavBar(navController = navController) }
    )
}

@Composable
fun ProductScreen(modifier: Modifier = Modifier, navController: NavController) {
    Column {
        Box(contentAlignment = Alignment.TopStart) {
            Image(
                painter = painterResource(id = R.drawable.interior_photo),
                contentDescription = "",
                modifier = modifier
                    .fillMaxWidth()
                    .height(250.dp),
                contentScale = ContentScale.FillBounds
            )
            Box(
                modifier = modifier
                    .padding(start = 24.dp, top = 24.dp)
                    .clip(CircleShape)
                    .background(color = Color.White.copy(alpha = 0.5f))
                    .size(50.dp)
                    .clickable {
                        navController.navigate(NavigationRoute.LockerScreen.name)
                    },
                contentAlignment = Alignment.Center
            ) {
                Icon(imageVector = Icons.Default.Close, contentDescription = "")
            }
        }
        Column(
            modifier = modifier
                .padding(start = 24.dp, end = 24.dp)
                .verticalScroll(
                    rememberScrollState()
                )
        ) {
            Spacer(modifier = modifier.height(20.dp))
            Text(text = "Introduction", style = h4_bold)
            Spacer(modifier = modifier.height(16.dp))
            Text(
                text = "Welcome to HubLocker, your gateway to hassle-free parcel management. Our locker services redefine convenience, providing a seamless experience for sending, receiving, and picking up your packages",
                style = h6_black,
                textAlign = TextAlign.Justify
            )
            Spacer(modifier = modifier.height(20.dp))
            Text(text = "Key Benefits", style = h4_bold)
            Spacer(modifier = modifier.height(16.dp))
            Benefits(main = "Secure and Convenient: Our lockers prioritize the safety of your parcels")
            Spacer(modifier = modifier.height(16.dp))
            Benefits(main = "24/7 Contactless Transactions: Embrace contactless transactions for a safer experience")
            Spacer(modifier = modifier.height(16.dp))
            Benefits(main = "Vacation: Schedule periods when you won't be available to pick your packages. Your parcels are surely stored until your return, ensuring stress-free parcel management during your absence")
            Spacer(modifier = modifier.height(16.dp))
            Benefits(main = "Family-Friendly Convenience: Easily add household members to your HubLocker")
            Spacer(modifier = modifier.height(40.dp))

        }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun Previewed() {
    val navController = rememberNavController()
    ProductScreen(navController = navController)
}