package com.example.featuremoviedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class MovieDetailFragment : Fragment() {
    private val movieDetailFragmentArgs: MovieDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        navigate_to_home_btn.setOnClickListener {
//            (requireActivity() as ToFlowNavigatable).navigateToFlow(NavigationFlow.HomeFlow)
//        }
//
//        navigate_to_next_deeplink.setOnClickListener {
//            findNavController().deepLinkNavigateTo(DeepLinkDestination.Next)
//        }
//
        movieDetailFragmentArgs.msg.let {
            if (it.isNotEmpty()) {
                Toast.makeText(requireContext(), movieDetailFragmentArgs.msg, Toast.LENGTH_SHORT).show()
            }
        }
    }
}