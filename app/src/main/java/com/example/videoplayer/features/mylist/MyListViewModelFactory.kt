package com.example.videoplayer.features.mylist


//object MyListViewModelFactory {
//    private class Factory: ViewModelProvider.Factory {
//        override fun <T: ViewModel?> create(modelClass: Class<T>): T {
//            val service = RetrofitClient.buildService(MovieService::class.java)
//            val movieRepo = MovieRepositoryImpl(service)
//            val movieUseCase = GetMovieUseCaseImpl(movieRepo)
//            return MyListViewModel(movieUseCase) as T
//        }
//    }
//
//    fun Fragment.make(): MyListViewModel {
//        return ViewModelProvider(this, Factory()).get(MyListViewModel::class.java)
//    }
//}

