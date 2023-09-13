package com.example.bottomnavigationwithnav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.bottomnavigationwithnav.databinding.FragmentHomeBinding


/**
 * ${HomeFragment}
 * Created by Atiq Ur Rehman on ${9/13/2023}.
 * Email: atiqurrehman90@gmail.com
 * Organization: NineSol
 */
class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding? = null

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        val callback: OnBackPressedCallback =
//            object : OnBackPressedCallback(true /* enabled by default */) {
//                override fun handleOnBackPressed() {
//                    // Handle the back button event
//                    Toast.makeText(
//                        requireContext(),
//                        "show your Exit dialog here",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//            }
//        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.textClick?.setOnClickListener {
            findNavController().navigate(R.id.idInnerFragment)
        }
    }

}