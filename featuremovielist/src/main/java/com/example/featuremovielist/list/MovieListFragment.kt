package com.example.featuremovielist.list

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.commonui.BaseFragment
import com.example.domain.model.TestingPassData
import com.example.featuremovielist.R
import com.example.featuremovielist.databinding.FragmentMovieListBinding
import com.example.navigation.DataConvert
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MovieListFragment : BaseFragment(R.layout.fragment_movie_list) {

    private val movieListFragmentArgs: MovieListFragmentArgs by navArgs()

    @Inject
    lateinit var adapter: MovieListAdapter

    @Inject
    lateinit var dataConvert: DataConvert

    private lateinit var test: TestingPassData

    private lateinit var binding: FragmentMovieListBinding
    private val viewModel: MoviesViewModel by viewModels()

    override fun initComponent() {
        super.initComponent()
        binding = FragmentMovieListBinding.bind(requireView())

        test = dataConvert.toData(movieListFragmentArgs.movieListData)!!

        val layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvMovieList.setLayoutManager(layoutManager)
        binding.rvMovieList.setAdapter(adapter)
        binding.rvMovieList.initialHideList()

        viewModel.getMovies()

        movieListFragmentArgs.movieListData.let {
            if (it.isNotEmpty()) {
                Toast.makeText(
                    requireContext(),
                    test.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun initObserver() {
        super.initObserver()
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    when {
                        it.isLoading -> {
                            Log.d("MainActivity", "Loading")
                            binding.rvMovieList.showWait()
                        }

                        it is MoviesUiState.HasRepoList -> {
                            Log.d("MainActivity", "Sukses")

                            adapter.addData(it.repoList)
                            binding.rvMovieList.apply {
                                hideWait()
                                showData()
                            }
                        }

                        it is MoviesUiState.RepoListEmpty -> {
                            Log.d("MainActivity", "Kosong")
                            if (it.error.isNotEmpty()) {
                                binding.rvMovieList.apply {
                                    hideWait()
                                    showEmpty("No Data Found")
                                }
                                Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT)
                                    .show()
                            } else {
                                binding.rvMovieList.apply {
                                    if (!it.isLoading) {
                                        hideWait()
                                        if (!it.isPreviousPageLoaded) showEmpty("No Data Found")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.fragment_movie_list, container, false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
////        to_dash_fragment_deeplink_btn.setOnClickListener {
////            it.post {
////                findNavController().deepLinkNavigateTo(DeepLinkDestination.Dashboard("From next fragment deeplink"))
////            }
////        }
//
//        movieListFragmentArgs.movieListData.let {
//            if (it.isNotEmpty()) {
//                Toast.makeText(requireContext(), movieListFragmentArgs.movieListData, Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
//    }