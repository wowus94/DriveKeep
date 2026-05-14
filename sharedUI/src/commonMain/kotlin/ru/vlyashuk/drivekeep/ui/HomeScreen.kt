package ru.vlyashuk.drivekeep.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import drivekeep.sharedui.generated.resources.Res
import drivekeep.sharedui.generated.resources.ic_home
import org.jetbrains.compose.resources.vectorResource
import ru.vlyashuk.drivekeep.ui.ui_item.ItemHomeScreen
import ru.vlyashuk.drivekeep.ui.ui_item.TopAppBarHomeScreen

@Preview
@Composable
fun HomeScreen() {

    Scaffold(
        topBar = {
            TopAppBarHomeScreen()
        }
    ) {

        Column {

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .padding(top = it.calculateTopPadding()),
                horizontalArrangement = Arrangement.Center
            ) {
                item {
                    ItemHomeScreen(
                        vectorResource(Res.drawable.ic_home),
                        "Title 1",
                        "1"
                    )
                }
                item {
                    ItemHomeScreen(
                        vectorResource(Res.drawable.ic_home),
                        "Title 2",
                        "2"
                    )
                }
                item {
                    ItemHomeScreen(
                        vectorResource(Res.drawable.ic_home),
                        "Title 3",
                        "3"
                    )
                }
                item {
                    ItemHomeScreen(
                        vectorResource(Res.drawable.ic_home),
                        "Title 4",
                        "4"
                    )
                }
            }

            QuickActionItem()
        }
    }
}

@Composable
fun QuickActionItem() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.2f)
        )
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text("Quick Actions")
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Title 1")
                Text("Title 2")
                Text("Title 3")
                Text("Title 4")
            }
        }
    }
}