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

        val textNaoColadas =
            view.findViewById<TextView>(R.id.textNaoColadas)

        val textRepetidas =
            view.findViewById<TextView>(R.id.textRepetidas)

        val textUnicas =
            view.findViewById<TextView>(R.id.textUnicas)

        val textProgresso =
            view.findViewById<TextView>(R.id.textProgresso)

        val progressAlbum =
            view.findViewById<android.widget.ProgressBar>(
                R.id.progressAlbum
            )


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

                        val naoColadas =
                            total - coladas

                        val repetidas =
                            stickers.count {
                                it.repetida
                            }

                        val unicas =
                            total - repetidas

                        val progresso =
                            if (total > 0)
                                (coladas * 100) / total
                            else
                                0


                        textTotal.text =
                            "Total de Figurinhas: $total"

                        textColadas.text =
                            "Coladas: $coladas"

                        textNaoColadas.text =
                            "Não Coladas: $naoColadas"

                        textRepetidas.text =
                            "Repetidas: $repetidas"

                        textUnicas.text =
                            "Únicas: $unicas"

                        textProgresso.text =
                            "Progresso: $progresso%"

                        progressAlbum.progress =
                            progresso

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
