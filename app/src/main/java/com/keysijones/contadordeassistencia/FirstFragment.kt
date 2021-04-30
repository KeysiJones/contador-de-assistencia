package com.keysijones.contadordeassistencia

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.keysijones.contadordeassistencia.databinding.FragmentFirstBinding
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var assistencia = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFirstBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnIncrementa.setOnClickListener {
            assistencia++
            btnContador.text = "$assistencia"
        }

        btnDecrementa.setOnClickListener {

            if(assistencia > 0) {
                assistencia--
                btnContador.text = "$assistencia"
            } else {
                Toast.makeText(context, "A assistência não pode ser menor do que 0 !!", Toast.LENGTH_SHORT).show()
            }

        }

        btnZerar.setOnClickListener {
            assistencia = 0
            btnContador.text = "$assistencia"
        }

        btnCompartilharWpp.setOnClickListener {
            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND;
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Olá, a assistencia à reunião foi de $assistencia pessoas. Tenha um ótimo dia !!");
            sendIntent.type = "text/plain";
            //Define o aplicativo a ser aberto, sem isso o sistema vai abrir a lista de aplicativos
            sendIntent.setPackage("com.whatsapp");
            startActivity(sendIntent);
        }
    }
}