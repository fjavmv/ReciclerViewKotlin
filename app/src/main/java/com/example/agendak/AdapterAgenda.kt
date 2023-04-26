package com.example.agendak

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterAgenda(
    private val datos: MutableList<Agenda>,
    private val clickListener: (Agenda) -> Unit
) :
    RecyclerView.Adapter<AdapterAgenda.ActividadesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActividadesViewHolder {
        val item = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_custom, parent, false)
        return ActividadesViewHolder(item)
    }

    override fun onBindViewHolder(holder: ActividadesViewHolder, position: Int) {
        val actividades = datos[position]
        holder.bindActividad(actividades)
        holder.item.setOnClickListener{ clickListener(actividades) }
    }

    override fun getItemCount() = datos.size

    class ActividadesViewHolder(val item: View) : RecyclerView.ViewHolder(item) {
        val lblNombre = item.findViewById(R.id.lblNombre) as TextView
        val lblApellido = item.findViewById(R.id.lblApellido) as TextView
        val lblTelefono = item.findViewById(R.id.lblTelefono) as TextView
        val lblEmail = item.findViewById(R.id.lblEmail) as TextView


        fun bindActividad(agenda: Agenda) {
            lblNombre.text = agenda.nombre
            lblApellido.text = agenda.apellido
            lblTelefono.text = agenda.numero
            lblEmail.text = agenda.email

        }
    }
}

