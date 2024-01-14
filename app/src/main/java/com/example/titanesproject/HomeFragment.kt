package com.example.titanesproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit

class HomeFragment : Fragment() {

    private lateinit var v:View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_home, container, false)
        v.findViewById<ImageView>(R.id.icono_principal).setOnClickListener {
            val fm: FragmentManager = parentFragmentManager
            fm.commit {
                replace(R.id.fragmentContainerView, ListFragment.newInstance())
                addToBackStack("replacement")
            }
            true
        }
        return v
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            HomeFragment().apply {

            }
    }
}