package com.alexilinskiy.nytimescomposeapp

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.alexilinskiy.nytimescomposeapp.model.ItemType
import com.alexilinskiy.nytimescomposeapp.model.Result
import com.alexilinskiy.nytimescomposeapp.presentation.details.NewsItemScreen
import com.alexilinskiy.nytimescomposeapp.presentation.list.NewsListScreen
import com.alexilinskiy.nytimescomposeapp.presentation.list.NewsListViewModel
import com.alexilinskiy.nytimescomposeapp.ui.theme.NYTimesComposeAppTheme
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NYTimesComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NewsApp()
                }
            }
        }
    }
}


@Composable
fun NewsApp() {
    val navController = rememberNavController()
    val viewModel: NewsListViewModel = hiltViewModel()
    val newsList = viewModel.news.value
    NavHost(navController = navController, startDestination = "newsList") {
        composable(route = "newsList") {
            NewsListScreen(
                onItemCLick = { newsItem ->
                    val json = Uri.encode(Gson().toJson(newsItem))
                    navController.navigate("newsList/$json")
                },
                newsList = newsList,
                onItemDrawerClick = { section ->
                    viewModel.getSectionNews(section)
                }
            )
        }

        composable(
            route = "newsList/{newsItem}",
            arguments = listOf(navArgument("newsItem") {
                type = ItemType()
            })
        ) { navBackStackEntry ->
            val item = navBackStackEntry.arguments?.getParcelable<Result>("newsItem")
            NewsItemScreen(item!!)
        }
    }
}