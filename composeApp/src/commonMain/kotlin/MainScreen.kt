import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.kanyidev.searchable_dropdown.LargeSearchableDropdownMenu
import com.kanyidev.searchable_dropdown.SearchableExpandedDropDownMenuMaterial3

@Composable
fun MainScreen() {
    val alertMessage = remember { mutableStateOf<String?>(null) }
    val sports = mutableListOf(
        Sport("Basketball", "🏀"),
        Sport("Rugby", "🏉"),
        Sport("Football", "⚽️"),
        Sport("MMA", "🤼‍♂️"),
        Sport("Motorsport", "🏁"),
        Sport("Snooker", "🎱"),
        Sport("Tennis", "🎾"),
    )
    alertMessage.value?.let {
        DefaultAlert(
            onDismissRequest = { alertMessage.value = null },
            message = it
        )
    }
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        contentPadding = PaddingValues(16.dp)
    ) {
        item {
            Text(
                text = "Searchable Dropdown Menu",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold
                )
            )

            Spacer(modifier = Modifier.height(12.dp))
        }

        item {
            SearchableExpandedDropDownMenuMaterial3(
                listOfItems = sports,
                modifier = Modifier.fillMaxWidth(),
                onDropDownItemSelected = { item ->
                    alertMessage.value = item.name
                },
                dropdownItem = { test ->
                    DropDownItem(test = test)
                },
                defaultItem = {
                    //Log.e("DEFAULT_ITEM", it.name)
                },
            )
            Spacer(modifier = Modifier.height(12.dp))
        }

        item {
            Spacer(Modifier.height(16.dp))
        }

        item {
            Text(
                text = "Large Searchable Dropdown Menu",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold
                )
            )

            Spacer(modifier = Modifier.height(12.dp))
        }

        item {
            var selectedIndex by remember { mutableStateOf<String?>(null) }
            LargeSearchableDropdownMenu(
                title = "Sample",
                placeholder = "Select",
                options = listOf(
                    "Item 1",
                    "Item 2",
                    "tom",
                    "Item 3",
                    "Item 4",
                    "Item 5",
                    "Item 6",
                    "Item 7",
                    "joel",
                    "john",
                    "kevin",
                    "james",
                    "kiarie"
                ),
                selectedOption = selectedIndex,
                onItemSelected = {
                    selectedIndex = it
                },
                optionsTitle = {
                    Text(
                        text = "Select an item",
                        style = MaterialTheme.typography.titleSmall,
                    )
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultAlert(
    onDismissRequest: () -> Unit,
    message: String,
    modifier: Modifier = Modifier,
) {
    BasicAlertDialog(
        onDismissRequest = onDismissRequest,
        modifier = modifier,
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Card(
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = message
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Button(
                        onClick = onDismissRequest
                    ) {
                        Text(
                            text = "Dismiss"
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun DropDownItem(test: Sport) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .wrapContentSize(),
    ) {
        Text(text = test.emoji)
        Spacer(modifier = Modifier.width(12.dp))
        Text(test.name)
    }
}

data class Sport(
    val name: String,
    val emoji: String,
) {
    override fun toString(): String {
        return "$emoji $name"
    }
}