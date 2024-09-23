package steve.example.mywishlistapp

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(
    padding: PaddingValues,
    viewModel: WishViewModel = viewModel(),
    navController: NavHostController = rememberNavController())
{

    NavHost(navController = navController,
        startDestination = Screen.HomeScreen.route
    ){
        composable(route = Screen.HomeScreen.route){
            HomeView(navController = navController,padding = padding)
        }
        composable(route = Screen.AddScreen.route){
            AddEditDetailView(id = 0L, viewModel = viewModel, navController = navController)

        }
    }
}