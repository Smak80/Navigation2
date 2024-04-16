package ru.smak.navigation2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ru.smak.navigation2.navigation.NavContent
import ru.smak.navigation2.navigation.Page
import ru.smak.navigation2.ui.theme.Navigation2Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController: NavHostController = rememberNavController()
            val position by navController.currentBackStackEntryAsState()
            Navigation2Theme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(when(position?.destination?.route){
                                Page.DETAILS.route -> stringResource(R.string.title_details)
                                Page.SETTINGS.route -> stringResource(R.string.title_settings)
                                else -> stringResource(R.string.title_main)
                            })},
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primary,
                                titleContentColor = MaterialTheme.colorScheme.onPrimary,
                                navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                            ),
                            navigationIcon = {
                                if(position?.destination?.route != Page.MAIN.route)IconButton(onClick = {navController.popBackStack()}) {
                                    Icon(painter = painterResource(id = R.drawable.baseline_arrow_back_24), contentDescription = null)
                                }
                            }
                        )
                    }
                ) {
                    NavContent(
                        navController = navController,
                        modifier = Modifier.padding(it)
                    )
                }
            }
        }
    }
}