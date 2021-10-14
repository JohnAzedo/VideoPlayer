package com.example.videoplayer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController

class VideoListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val navController = findNavController()
        return ComposeView(requireContext()).apply {
            setContent {
                Page(navController = navController)
            }
        }
    }
}

@Composable
fun Page(navController: NavController) {
    Scaffold (
        topBar = { TopAppBar(title = { Text("Video Fragment") }) }
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Video Fragment")
            Button(
                onClick = {
                    navController.navigate(R.id.viewVideoPlayer)
                },

                ){
                Text (text = "To new Fragment")
            }
        }
    }
}