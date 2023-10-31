package com.example.cleanarchitecturemovie.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.cleanarchitecturemovie.R
import com.example.cleanarchitecturemovie.presentation.viewmodel.MoviesUiState
import com.example.cleanarchitecturemovie.presentation.viewmodel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MoviesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initObserver()
        viewModel.getMovies()
    }

    fun initObserver() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    when {
                        it.isLoading -> {
                            Log.d("MainActivity","Loading")
                            //binding.rvRepoList.showWait()
                        }

                        it is MoviesUiState.HasRepoList -> {
                            Log.d("MainActivity","Sukses")

//                            adapter.addData(it.repoList)
//                            binding.rvRepoList.apply {
//                                hideWait()
//                                showData()
//                            }
                            for (data in it.repoList){
                                Log.d("MainActivity","Isinya ${data.title}")
                            }
                        }

                        it is MoviesUiState.RepoListEmpty -> {
                            Log.d("MainActivity","Kosong")
//                            if (it.error.isNotEmpty()) {
//                                binding.rvRepoList.apply {
//                                    hideWait()
//                                    showEmpty("No Data Found")
//                                }
//                                Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
//                            } else {
//                                binding.rvRepoList.apply {
//                                    if (!it.isLoading){
//                                        hideWait()
//                                        if (!it.isPreviousPageLoaded) showEmpty("No Data Found")
//                                    }
//                                }
//                            }
                        }
                    }
                }
            }
        }
    }
}