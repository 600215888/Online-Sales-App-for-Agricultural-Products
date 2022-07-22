package ca.uwaterloo.cs

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.uwaterloo.cs.destinations.MainContentDestination
import ca.uwaterloo.cs.destinations.MergeFormDestination
import ca.uwaterloo.cs.destinations.ProfileContentDestination
import ca.uwaterloo.cs.destinations.PushPullUIDestination
import ca.uwaterloo.cs.ui.theme.InstagramPurple
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

sealed class NavItem(
    var title: String,
    var icon: Int,
) {
    // https://www.flaticon.com/free-icons
    object Catalogue: NavItem("Catalogue", R.drawable.catalogue_icon)
    object Request: NavItem("Request", R.drawable.logistics_icon)
    object Sync: NavItem("Sync", R.drawable.ic_baseline_cloud_queue_24)
    object Profile: NavItem("Profile", R.drawable.profile_icon)
}


@Composable
fun NavigationBar(nav: DestinationsNavigator) {
    val items = listOf(
        NavItem.Catalogue,
        NavItem.Request,
        NavItem.Sync,
        NavItem.Profile
    )
    val context = LocalContext.current

    BottomNavigation(
        backgroundColor = Color.InstagramPurple
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                selected = false,
                icon = { Icon(painterResource(id = item.icon,), contentDescription = item.title,
                    modifier= Modifier.width(25.dp).height(25.dp),
                tint = Color.White)
                },
                label = { Text(text = item.title, fontSize = 12.sp, color = Color.White
                ) },
                onClick = {
                    when (item.title) {
                        "Catalogue" -> nav.navigate(MainContentDestination)
                        "Request" -> nav.navigate(MergeFormDestination())
                        "Sync" -> nav.navigate(PushPullUIDestination)
                        "Profile" -> nav.navigate(ProfileContentDestination)
                    }
                }
            )
        }
    }
}
