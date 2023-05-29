
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.ColorRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hauntedhaven.ui.theme.HauntedHavenTheme
import com.example.hauntedhaven.ui.data.listing
import com.example.hauntedhaven.ui.data.listingCategory


@Composable
fun ListingsPage(modifier: Modifier = Modifier){
    val hauntedHaven = painterResource(id =R.drawable.screenshot_2023_05_28_at_20_30_06)
    val listings = listOf(
        Listing("Eastern State Penitentiary", "Pennsylvania, USA", image = R.drawable.eastern_state_penitentiary__philadelphia__pennsylvania_lccn2011632222_tif, listingCategory.PENITENTARY_PHANTOMS),
        Listing("The Tower of London", "England", image = R.drawable.keep_white_tower_jpg, listingCategory.PENITENTARY_PHANTOMS),
        Listing("St. Albans Sanatorium", "Virginia, USA", category = listingCategory.SCHOOLS_HOSPITALS, image= R.drawable._77_0046_stalbanshospital_2019_exterior_front_elevation_vlr_online),
        Listing("Old Changi Hospital", "Singapore", category = listingCategory.SCHOOLS_HOSPITALS, image = R.drawable.hauntedchangi_main),
        Listing("Stanley Hotel", "Colorado, USA", category = listingCategory.HOTELS, image = R.drawable.stanleyhotel0915_maze_92ef1d5afd9445208830d68702895817),
        Listing("Hotel Burchianti", "Florence, Italy", category = listingCategory.HOTELS, image = R.drawable._7940556),
        Listing("Winchester Mystery House", "California, USA", category = listingCategory.HOUSES, image = R.drawable.dji_0136_scaled_1),
        Listing("The House of the Seven Gables", "Massachusetts, USA", category = listingCategory.HOUSES, image = R.drawable.llhouseof7gables_jpg),
        Listing("Chillingham Castle", "Northumberland, England", category = listingCategory.CASTLES_MANSIONS, image = R.drawable.chillingham_castle_stormy_external_1442x760),
        Listing("Leap Castle", "Offaly, Ireland", category = listingCategory.CASTLES_MANSIONS, image = R.drawable.leap_website)
    )

    LazyColumn(modifier = Modifier.padding(horizontal = 17.dp)){
        items(listings) {
                listing -> ListingItem(listing)
        }

    }

}

@Composable
fun ListingItem(listing: Listing, modifier: Modifier = Modifier) {
    val painter = painterResource(id = listing.image)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        Row(
            modifier = Modifier.padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painter, contentDescription = null, modifier = Modifier.size(96.dp),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier.padding(top = 20.dp)
            ) {
                Row {
                    Column(modifier = Modifier.fillMaxSize()) {
                        Text(
                            text = listing.title,
                            style = MaterialTheme.typography.subtitle1,
                            modifier = Modifier.padding(16.dp, bottom = 30.dp),
                            color = Color.White
                        )
                        Text(
                            text = listing.location,
                            style = MaterialTheme.typography.body2,
                            modifier = Modifier.padding(16.dp),
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}

