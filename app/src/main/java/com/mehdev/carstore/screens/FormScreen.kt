@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.mehdev.carstore.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mehdev.carstore.ui.theme.BlueDarkness
import com.mehdev.carstore.ui.theme.WhiteSmoke

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormScreen(navController: NavController) {
    val focusManager = LocalFocusManager.current
    Scaffold(
        modifier = Modifier.clickable { focusManager.clearFocus() },
        topBar = {
            TopAppBar(title = {})
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Arrow Back",
                tint = WhiteSmoke,
                modifier = Modifier
                    .padding(30.dp)
                    .clickable { navController.popBackStack() }
            )
        }
    ) {
        FormBody()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormBody() {
    var licensePlate by remember { mutableStateOf("") }
    var model by remember { mutableStateOf("") }
    var color by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 110.dp, horizontal = 20.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = licensePlate,
            onValueChange = { licensePlate = it },
            label = { Text("License Plate") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MaterialTheme.colorScheme.tertiary,
                focusedLabelColor = MaterialTheme.colorScheme.tertiary
            ),
            modifier = Modifier
                .padding(vertical = 10.dp)
        )
        OutlinedTextField(
            value = model,
            onValueChange = { model = it },
            label = { Text("Model") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MaterialTheme.colorScheme.tertiary,
                focusedLabelColor = MaterialTheme.colorScheme.tertiary
            ),
            modifier = Modifier
                .padding(vertical = 10.dp)
        )
        OutlinedTextField(
            value = "",
            onValueChange = { color = it },
            label = { Text("Color") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MaterialTheme.colorScheme.tertiary,
                focusedLabelColor = MaterialTheme.colorScheme.tertiary
            ),
            modifier = Modifier
                .padding(vertical = 10.dp)
        )
        ElevatedButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(horizontal = 30.dp, vertical = 10.dp)
                .width(2000.dp)
            ,
            colors = ButtonDefaults.buttonColors(containerColor = BlueDarkness)
        ) {
            Text(
                text = "ADD CAR",
                fontSize = 22.sp,
                color = WhiteSmoke
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultFormPreview() {
    FormScreen(navController = rememberNavController())
}
