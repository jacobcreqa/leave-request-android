package vn.thinhphat.leave

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import vn.thinhphat.leave.ui.theme.LeaveRequestAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LeaveRequestAppTheme {
                var showLeaveForm by remember { mutableStateOf(false) }

                if (showLeaveForm) {
                    LeaveRequestForm(
                        onBackClick = { showLeaveForm = false },
                        onSaveClick = { /* Handle save action */ }
                    )
                } else {
                    Greeting(
                        name = "Android",
                        onSubmitLeaveClick = { showLeaveForm = true }
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, onSubmitLeaveClick: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Hello $name!",
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Button(onClick = onSubmitLeaveClick) {
            Text("Submit Leave Request")
        }
    }
}

@Composable
fun LeaveRequestForm(onBackClick: () -> Unit, onSaveClick: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = onBackClick) {
                Text("Back")
            }
            Text(text = "Request Leave", style = MaterialTheme.typography.displayMedium)
            Button(onClick = onSaveClick) {
                Text("SAVE")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        var startDate by remember { mutableStateOf(TextFieldValue("")) }
        var endDate by remember { mutableStateOf(TextFieldValue("")) }
        var leaveType by remember { mutableStateOf(TextFieldValue("")) }
        var reason by remember { mutableStateOf(TextFieldValue("")) }

        TextField(
            value = startDate,
            onValueChange = { startDate = it },
            label = { Text("Start Date") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = endDate,
            onValueChange = { endDate = it },
            label = { Text("End Date") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = leaveType,
            onValueChange = { leaveType = it },
            label = { Text("Leave Type") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = reason,
            onValueChange = { reason = it },
            label = { Text("Reason") },
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LeaveRequestAppTheme {
        Greeting("Android", onSubmitLeaveClick = {})
    }
}

@Preview(showBackground = true)
@Composable
fun LeaveRequestFormPreview() {
    LeaveRequestAppTheme {
        LeaveRequestForm(onBackClick = {}, onSaveClick = {})
    }
}
