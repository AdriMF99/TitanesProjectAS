package com.example.titanesproject

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * A fragment representing a list of Items.
 */
class ListFragment : Fragment() {

    private lateinit var v: View
    private val titanviewmodel: TitanViewModel by activityViewModels()

    class MainActivity : AppCompatActivity() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_list, container, false)
        val recyclerView: RecyclerView = v.findViewById<RecyclerView>(R.id.recyclerview)
        var adaptador = TitanRecyclerViewAdapter(this.titanviewmodel.titanes)
        adaptador.click = { position, titan ->
            run {
                //se selecciona el dragón
                this.titanviewmodel.selected = titan
                val fm: FragmentManager = parentFragmentManager
                //caso de pantalla vertical se ha de abrir un nuevo fragmento
                if (!resources.getBoolean(R.bool.land)) {

                    fm.commit {
                        replace(R.id.fragmentContainerView, DetailFragment.newInstance())
                        addToBackStack("replacement")
                    }

                } else {
                    //se encuentra en el caso de horizonta, es necesario actualizar de alguna forma el fragmento
                    val contenedor =
                        v.findViewById<FragmentContainerView>(R.id.detailfragmentContainerView)
                    val fragmentManager = childFragmentManager
                    var fragment = fragmentManager.findFragmentById(contenedor?.id ?: -1)
                    if (fragment != null && fragment is DetailFragment) {
                        (fragment as DetailFragment).update()
                    }
                }
            }
        }
        val layoutManager = GridLayoutManager(this.context, 2)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adaptador
        return v
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            ListFragment().apply {

            }
    }
}