package ru.smak.navigation2.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import ru.smak.navigation2.R

@Composable
fun Details(
    navController: NavHostController,
    modifier: Modifier = Modifier,
){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(stringResource(R.string.detail_text))
        Button(onClick = {
            navController.popBackStack()
        }){
            Text(stringResource(R.string.btn_back))
        }
    }
}

