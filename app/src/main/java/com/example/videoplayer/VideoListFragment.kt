package com.example.videoplayer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController

class VideoListFragment : Fragment() {

    private lateinit var navController: NavController
    private lateinit var repository: VideoRepository

    @ExperimentalMaterialApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Change this to dependency injection using ViewModel
        repository = VideoRepository()
        navController =  findNavController();
        return ComposeView(requireContext()).apply {
            setContent {
                Page()
            }
        }
    }

    @ExperimentalMaterialApi
    @Composable
    fun Page() {
        val videos = repository.getVideos()
        Scaffold (
            topBar = { TopAppBar(title = { Text("Video Fragment") }) }
        ){
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                VideoList(videoList = videos)
            }
        }
    }

    @ExperimentalMaterialApi
    @Composable
    fun VideoList(
        videoList: List<Video>
    ) {
        LazyColumn {
            items(videoList.size) { data ->
                VideoItem(video = videoList[data])
            }
        }
    }

    @ExperimentalMaterialApi
    @Composable
    fun VideoItem(video: Video) {
        Card(
            onClick = { navController.navigate(R.id.viewVideoPlayer) },
            modifier = Modifier.padding(16.dp),
            elevation = 4.dp
        ){
            Text(text = video.title)
        }
    }
}

