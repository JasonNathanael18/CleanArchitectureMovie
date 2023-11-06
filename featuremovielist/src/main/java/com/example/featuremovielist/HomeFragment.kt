package com.example.featuremovielist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigation.NavigationFlow
import com.example.navigation.ToFlowNavigatable

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    var btnMovieList: Button? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnMovieList = view.findViewById(R.id.btnMovieList)
//        to_next_fragment_btn.setOnClickListener {
//            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToNextFragment())
//        }
//
//        to_dashboard_flow.setOnClickListener {
//            (requireActivity() as ToFlowNavigatable).navigateToFlow(NavigationFlow.DashboardFlow("From home fragment"))
//        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        btnMovieList?.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToNextFragment(
                "Dari Home Nih"
            ))
           // (requireActivity() as ToFlowNavigatable).navigateToFlow(NavigationFlow.MovieListFlow("Dari Home Nih"))
        }
    }
}