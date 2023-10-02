package com.example.jetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DesignPreview()
        }
    }
}

data class User(var name: String, var age: Int)

val list = listOf(
    User("B", 2),
    User("A", 1),
    User("C", 3),
    User("D", 4),
    User("E", 5),
    User("F", 6),
    User("G", 7),
    User("I", 8),
    User("I", 8),
    User("I", 8),
    User("I", 8),
    User("I", 8)
)

@Composable
fun RecyclerView() {
    LazyColumn() {
        items(list) { user ->
            UserCard()
        }
    }
}

@Composable
fun UserCard() {
    Card(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(12.dp)
                .padding(12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Column {
                Text(text = stringResource(id = R.string.dummy_text))
                Button(onClick = {}) {
                    Text(text = stringResource(id = R.string.profile))

                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DesignPreview() {
    Surface(Modifier.fillMaxSize()) {
        //RecyclerView()
        InputTextField()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputTextField() {
    val state= remember { mutableStateOf("Hello") }
    TextField(
        value = state.value,
        onValueChange = {
            state.value=it
            Log.e("TAG", "InputTextField: $it", )
        },
        label = { Text(text = "Enter Message") })
}