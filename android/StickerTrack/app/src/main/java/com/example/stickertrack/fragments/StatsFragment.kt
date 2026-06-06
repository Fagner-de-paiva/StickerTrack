package com.example.stickertrack.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.stickertrack.R
import com.example.stickertrack.model.Sticker
import com.example.stickertrack.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StatsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(
            R.layout.fragment_stats,
            container,
            false
        )

        val textTotal =
            view.findViewById<TextView>(R.id.textTotal)

        val textColadas =
            view.findViewById<TextView>(R.id.textColadas)

        val textRepetidas =
            view.findViewById<TextView>(R.id.textRepetidas)

        RetrofitClient.api.getStickers()
            .enqueue(object : Callback<List<Sticker>> {

                override fun onResponse(
                    call: Call<List<Sticker>>,
                    response: Response<List<Sticker>>
                ) {

                    if (response.isSuccessful) {

                        val stickers =
                            response.body() ?: emptyList()

                        val total =
                            stickers.size

                        val coladas =
                            stickers.count {
                                it.colada
                            }

                        val repetidas =
                            stickers.count {
                                it.repetida
                            }

                        textTotal.text =
                            "Total de Figurinhas: $total"

                        textColadas.text =
                            "Coladas: $coladas"

                        textRepetidas.text =
                            "Repetidas: $repetidas"

                    }

                }

                override fun onFailure(
                    call: Call<List<Sticker>>,
                    t: Throwable
                ) {

                    textTotal.text =
                        "Erro ao carregar"

                }

            })

        return view

    }


}
