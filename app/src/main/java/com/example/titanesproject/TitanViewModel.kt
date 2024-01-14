package com.example.titanesproject

import androidx.lifecycle.ViewModel
import com.example.titanesproject.models.Titan

class TitanViewModel: ViewModel() {
    private var _titanes: MutableList<Titan>
    private var _selected:Titan?=null
    val titanes:List<Titan>
        get() = _titanes.toList()
    var selected:Titan?
        get()=_selected
        set(item){ _selected=item}
    init {
        this._titanes = mutableListOf()
        this._titanes.add(
            Titan(
                "Titan de Ataque",
                15,
                "Congelación",
                "Eren Yaeger"
            )
        )
        this._titanes.add(
            Titan(
                "Titan Fundador",
                13,
                "Controlar titanes",
                "Uri Reiss"
            )
        )
        this._titanes.add(
            Titan(
                "Titán Bestia",
                17,
                "Controlar titanes",
                "Zeke Jaeger"
            )
        )

    }
}