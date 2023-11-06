package com.example.featuremovielist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class MovieListFragment : Fragment() {

    //private val movieListFragmentArgs: MovieListFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        to_dash_fragment_deeplink_btn.setOnClickListener {
//            it.post {
//                findNavController().deepLinkNavigateTo(DeepLinkDestination.Dashboard("From next fragment deeplink"))
//            }
//        }

//        movieListFragmentArgs.movieListData.let {
//            if (it.isNotEmpty()) {
//                Toast.makeText(requireContext(), movieListFragmentArgs.movieListData, Toast.LENGTH_SHORT).show()
//            }
//        }
    }
}