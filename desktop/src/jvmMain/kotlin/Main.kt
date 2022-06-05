import androidx.compose.desktop.DesktopMaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*
import com.example.organize.Platform
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.max
import kotlin.math.min

fun main()= application {
    val state= rememberWindowState(width = 500.dp, height = 700.dp)
    val items=makeItems()
    Window(
        onCloseRequest = ::exitApplication,
        title = "Compose for Desktop",
        state = state
    ) {

        MaterialTheme {

            LazyColumn(modifier = Modifier.fillMaxSize()
                .padding(10.dp)){
                items(items) { row ->
                    RowView(title = row.first, subtitle = row.second)
                }
            }
        }
    }
}

@Composable
private fun RowView(
    title: String,
    subtitle: String,
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.caption,
                color = androidx.compose.ui.graphics.Color.Gray,
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.body1,
            )
        }
        Divider()
    }
}

private fun makeItems(): List<Pair<String, String>> {
//1
    val platform = Platform()
//2
    val items = mutableListOf(
        Pair("Operating System", "${platform.osName} ${platform.osVersion}"),
        Pair("Device", platform.deviceModel),
        Pair("CPU", platform.cpuType)
    )
//3
    platform.screen?.let {
        val max = max(it.width, it.height)
        val min = min(it.width, it.height)
        items.add(Pair("Display", "${max}×${min} @${it.density}x"))
    }
    return items
}



