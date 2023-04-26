package com.example.agendak

import android.graphics.Insets.add
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var recView: RecyclerView
    private lateinit var btnInsertar: Button
    private lateinit var btnEliminar: Button
    private lateinit var btnMover: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnInsertar = findViewById(R.id.btnInsertar)
        btnEliminar = findViewById(R.id.btnEliminar)
        btnMover = findViewById(R.id.btnMover)
        recView = findViewById(R.id.recyclerView)

        //val datos = MutableList(50) { i -> Agenda("Titulo $i", "Subtítulo Item $i", "Descripción $i") }

        val lista =  ArrayList<Agenda>()
        lista.add(Agenda("Jose","Martinez ","951233411", "jose@gmail.com"))
        lista.add(Agenda("Maria","Martinez ","951233411", "jose@gmail.com"))
        lista.add(Agenda("Perla","Martinez ","951233411", "jose@gmail.com"))

        val adaptador = AdapterAgenda(lista) {
            Log.i("Prueba contacto", "Pulsado el elemento: ${it.nombre}")
        }
        recView.setHasFixedSize(true)

        recView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        recView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        recView.itemAnimator = DefaultItemAnimator()

        recView.adapter = adaptador

        btnInsertar.setOnClickListener {
            lista.add(1, Agenda("Nuevo contacto", "Apellido", "0000000000","test@gmail.com"))
            adaptador.notifyItemInserted(1)
        }

        btnEliminar.setOnClickListener {
            lista.removeAt(1)
            adaptador.notifyItemRemoved(1)
        }

        btnMover.setOnClickListener {
            val titularAux = lista[1]
            lista[1] = lista[2].also { lista[2] = lista[1] }
            adaptador.notifyItemMoved(1, 2)
        }
    }
}