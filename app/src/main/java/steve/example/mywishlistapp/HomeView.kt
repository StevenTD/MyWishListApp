package steve.example.mywishlistapp

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import steve.example.mywishlistapp.data.DummyWatch
import steve.example.mywishlistapp.data.Wish

@Composable
fun HomeView(
    navController: NavController,
    padding:PaddingValues){
    val context = LocalContext.current
    Scaffold(
        modifier = Modifier.padding(padding),
        topBar = {
            AppBarView(title = "WishList", onBackNavClick = {

                Toast.makeText(context, "Button Clicked", Toast.LENGTH_SHORT).show()
            })
        },
        floatingActionButton = {

            FloatingActionButton(
                modifier = Modifier.padding(all = 20.dp),
                contentColor = Color.White,
                backgroundColor = Color.Black,
                onClick = {
                    // TODO Add Navgigatipn to add screen

                    navController.navigate(Screen.AddScreen.route)
                    Toast.makeText(context, "Floating Action Button Clicked", Toast.LENGTH_SHORT).show()
                }) {

                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add")

            }

        }
    ) {
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(it)) {
            items(DummyWatch.wishList){
                wish -> WishItem(wish = wish, onClick = {
                    Toast.makeText(context, "Item Clicked", Toast.LENGTH_SHORT).show()
                })
            }
        }
    }
}

@Composable
fun WishItem(wish: Wish, onClick: () -> Unit) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 8.dp, start = 8.dp, end = 8.dp)
        .clickable {
            onClick()
        },
        elevation = 10.dp, 
        backgroundColor = Color.White
        ){
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = wish.title, color = Color.Black, fontWeight = FontWeight.ExtraBold)
            Text(text = wish.description)
        }
        
    }
}