package ru.smak.navigation2.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import ru.smak.navigation2.R
import ru.smak.navigation2.navigation.Page
import ru.smak.navigation2.ui.theme.Navigation2Theme

@Composable
fun Main(
    navController: NavHostController,
    modifier: Modifier = Modifier,
){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(stringResource(R.string.main_text))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(onClick = {
                navController.navigate(Page.DETAILS.route)
            }) {
                Text(stringResource(R.string.btn_detail))
            }
            Button(onClick = {
                navController.navigate(Page.SETTINGS.route)
            }) {
                Text(stringResource(R.string.btn_settings))
            }
        }
    }
}

//@Preview
//@Composable
//fun MainPreview(){
//    Navigation2Theme {
//        Main(modifier = Modifier.fillMaxSize())
//    }
//}