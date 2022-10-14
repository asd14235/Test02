package com.example.test02

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.test02.ui.theme.Test02Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Test02Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Conversation(SampleData.conversationSample)
                }
            }
        }
    }
}
data class Message(val author: String, val body: String);

@Composable
fun MessageCard(msg: com.example.test02.Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.dji_fpv), contentDescription = "fpv drone",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.dp, MaterialTheme.colors.secondary, CircleShape)
                )

        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = msg.author, color = MaterialTheme.colors.secondaryVariant, style = MaterialTheme.typography.subtitle2)
            Spacer(modifier = Modifier.height(3.0.dp))
            Surface(shape = MaterialTheme.shapes.medium, elevation = 2.dp) {
                Text(text = msg.body, modifier = Modifier.padding(4.dp), style = MaterialTheme.typography.subtitle2)
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}
@Composable
fun Conversation(messages : List<Message>) {
    LazyColumn { items(messages){ message -> MessageCard(message)
    }
    }
}

@Preview("Light Mode")
@Preview( uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark Mode")
@Composable
fun PreviewMessageCard() {
    Test02Theme {
        Surface {
            MessageCard(msg = Message("whwkdghks", "asd"))
        }

    }
}
@Preview
@Composable
fun PreviewConversation() {
    Test02Theme {
        Conversation(SampleData.conversationSample)

    }
}




