package steve.example.mywishlistapp

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun HomeView(padding:PaddingValues){
    val context = LocalContext.current
    Scaffold(
        modifier = Modifier.padding(padding),
        topBar = {
            AppBarView(title = "WishList", onBackNavClick = {

                Toast.makeText(context, "Button Clicked", Toast.LENGTH_SHORT).show()
            })
        }
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize().padding(it)) {

        }
    }
}