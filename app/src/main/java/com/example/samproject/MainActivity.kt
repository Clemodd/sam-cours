package com.example.samproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources


class MainActivity : AppCompatActivity() {

    private lateinit var questionBonbon : EditText
    private lateinit var boutonValider : Button
    private lateinit var textPrevention : TextView
    private var questionBonbonInt = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set élements XML
        questionBonbon = findViewById(R.id.et_question_bonbon)
        boutonValider = findViewById(R.id.btn_valider)
        textPrevention = findViewById(R.id.tv_prevention)

        boutonValider.setOnClickListener {
            questionBonbonInt = Integer.parseInt(questionBonbon.text.toString())
            modifierTexte(questionBonbonInt)
            setPrevention()
        }
    }

    private fun modifierTexte(chiffre: Int) {
        val affichageBonbon = findViewById<TextView>(R.id.tv_affichage_bonbon_main)
        affichageBonbon.text = getString(R.string.mes_bonbons, chiffre)
    }

    private fun setPrevention(){
        if (questionBonbonInt >= 10){
            editionPrevention(getString(R.string.pas_bien), R.color.rouge)
        } else {
            editionPrevention(getString(R.string.bien, 10 - questionBonbonInt), R.color.vert)
        }
    }

    private fun editionPrevention(texte : String, couleur : Int){
        textPrevention.text = texte
        textPrevention.setTextColor(AppCompatResources.getColorStateList(this, couleur))
    }
}