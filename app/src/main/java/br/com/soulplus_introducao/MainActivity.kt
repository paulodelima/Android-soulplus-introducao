package br.com.soulplus_introducao

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvResultadoTop = findViewById<TextView>(R.id.tvResultadoTop)
        val etNome = findViewById<EditText>(R.id.etNome)
        val btEnviar = findViewById<Button>(R.id.btEnviar)
        val btEnviar2 = findViewById<Button>(R.id.btEnviar2)

        btEnviar.setOnClickListener {
            if (etNome.text.isNotBlank()) {
                tvResultadoTop.text = getString(R.string.hello_name, etNome.text.toString())
            } else {
                etNome.error = getString(R.string.type_your_name)
                tvResultadoTop.text = ""
            }
        }

        btEnviar2.setOnClickListener {
            if (etNome.text.isNotBlank()) {
                val nomeDigitado = etNome.text.toString()

                val intent = Intent(this, ResultActivity::class.java)

                intent.putExtra("NOME_DIGITADO", nomeDigitado)

                startActivity(intent)
            } else {
                etNome.error = getString(R.string.type_your_name)
            }
        }


    }
}