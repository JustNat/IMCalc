package com.bruce.imcalcullator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: View = findViewById(R.id.my_toolbar)
        setSupportActionBar(toolbar as Toolbar?)

        cardResult.visibility = View.INVISIBLE

        val calculate: View = findViewById(R.id.fab)
        calculate.setOnClickListener {
            calculateIMC(weight.text.toString(), height.text.toString())
        }
    }

    private fun calculateIMC(peso: String, altura: String) {
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()
        when {
            (peso == null && altura == null) -> {
                Toast.makeText(this, "Insira peso e altura", Toast.LENGTH_SHORT).show()
            }
            (peso != null && altura != null) -> {
                val imc = peso / (altura * altura)
                result.text = "IMC: %.2f".format(imc)
                cardResult.visibility = View.VISIBLE
                }
            (peso == null) -> {
                Toast.makeText(this, "Insira um peso", Toast.LENGTH_SHORT).show()
            }
            (altura == null) -> {
                Toast.makeText(this, "Insira uma altura", Toast.LENGTH_SHORT).show()
            }
            }
        }
    }