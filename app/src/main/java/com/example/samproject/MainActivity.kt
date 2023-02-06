package com.example.samproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources


class MainActivity : AppCompatActivity() {

    lateinit var questionBonbon : EditText
    lateinit var boutonValider : Button
    lateinit var textPrevention : TextView
    var questionBonbonInt = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set élements XML
        questionBonbon = findViewById(R.id.et_question_bonbon)
        boutonValider = findViewById(R.id.btn_valider)
        textPrevention = findViewById(R.id.tv_prevention)



        // Etape 1 :
        boutonValider.setOnClickListener {
            questionBonbonInt = Integer.parseInt(questionBonbon.text.toString())
            modifierTexte(questionBonbonInt)
            // Etape 2 :
            setPrevention()

            // Etape 4 :
            // Lorsque la quantite de bonbon est inférieur à 10, la phrase soit :
            // C'est bien, mais ça sera pas bien dans X bonbons.
            // Sachant que si j'ai 4 bonbons, x vaudra 6.
            // Mais je veux que tu utilises une fonction qui fasse le calcul avec le return.
        }

        val reponse = faireCalcul(3) // 6
        textPrevention.text = reponse.toString() // n'en prend pas compte

    }

    // Etape 3 :
    fun editionPrevention(texte : Int, couleur : Int){
        textPrevention.text = resources.getString(texte)
        textPrevention.setTextColor(AppCompatResources.getColorStateList(this, couleur))
    }

    fun setPrevention(){
        if (questionBonbonInt >= 10){
            editionPrevention(R.string.pas_bien, R.color.rouge)
        } else {
               editionPrevention(R.string.bien, R.color.vert)
        }
    }


    fun modifierTexte(chiffre: Int) {
        val affichageBonbon = findViewById<TextView>(R.id.tv_affichage_bonbon_main)
        val texteBonbon = "j'ai $chiffre bonbons"
        affichageBonbon.text = texteBonbon
    }

    fun faireCalcul(chiffre: Int): Int {
        return chiffre * 2
    }
    fun calculBonbon (chiffre: Int): Int {
        return questionBonbonInt - 10
    }
}