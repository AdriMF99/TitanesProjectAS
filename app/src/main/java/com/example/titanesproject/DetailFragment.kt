package com.example.titanesproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {
    private lateinit var v: View
    private val titanviewmodel: TitanViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    public fun update(){
        this.titanviewmodel.selected?.let {
            v.findViewById<TextView>(R.id.nombre).setText(it.nombre)
            v.findViewById<TextView>(R.id.altura).setText(it.altura.toString())
            v.findViewById<TextView>(R.id.habilidad).setText(it.habilidad.toString())
            v.findViewById<TextView>(R.id.poseedor).setText(it.poseedor.toString())
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_detail, container, false)
        this.update()

        // Inflate the layout for this fragment
        return v //inflater.inflate(R.layout.fragment_detail, container, false)
    }

    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            DetailFragment().apply {

            }
    }
}