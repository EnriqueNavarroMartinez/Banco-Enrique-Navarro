
package com.example.banco_ennama.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.airbnb.lottie.LottieAnimationView
import com.example.banco_ennama.R
import com.example.banco_ennama.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        //inicializar el binding
        binding =ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonInicio.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var imagen = findViewById<LottieAnimationView>(R.id.imagenAnimada)

        var click = false;

        imagen.setOnClickListener{
            click = animacion(imagen,R.raw.animation, click)
        }
    }

        fun animacion(imageView: LottieAnimationView, animacion:Int, click:Boolean):Boolean{
            if(!click){
                imageView.setAnimation(animacion)
                imageView.playAnimation()
            }else{
                imageView.setImageResource(R.drawable.img)
            }
            return !click
        }



    }
