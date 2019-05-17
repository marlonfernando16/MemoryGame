package com.example.matchinggamepdm

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import android.widget.ImageView
import android.widget.Toast
import android.util.Log
import java.util.*
import kotlin.collections.ArrayList

class GameActivity : AppCompatActivity() {
    var curView: ImageView? = null
    var secondView: ImageView? = null
    private var countPair: Int = 0
    private lateinit var gridView: GridView
    var winLast = false
    var cards = arrayListOf<Int>()
    var currentPos: Int = -1

    val teachers = intArrayOf(
        R.drawable.alana, R.drawable.alex
        , R.drawable.candido, R.drawable.crishane,
        R.drawable.damires, R.drawable.denio,
        R.drawable.edemberg, R.drawable.fausto,
        R.drawable.francisco, R.drawable.fred
        , R.drawable.giovanni, R.drawable.gustavo,
        R.drawable.heremita, R.drawable.juliana,
        R.drawable.lafayette, R.drawable.leonidas,
        R.drawable.luiz, R.drawable.nilton
        , R.drawable.paulo, R.drawable.petronio,
        R.drawable.pryscilla, R.drawable.thiago,
        R.drawable.valeria, R.drawable.varandas,
        R.drawable.zefilho

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val professores_aleatorio  = arrayListOf<Int>()
        while(true){
            Log.i("APP","aleatorios"+ professores_aleatorio)
            var rnd = Random().nextInt(teachers.size)
            if(rnd !in professores_aleatorio) {
                professores_aleatorio.add(rnd)
            }
            if(professores_aleatorio.size == 8)
                break
        }
        cards.addAll(professores_aleatorio)
        cards.addAll(professores_aleatorio)
        cards.toList().shuffled() as ArrayList<Int>
        Log.i("APP","cards"+cards)

        this.gridView = findViewById(R.id.gvTable)
        val imageAdapter = ImageAdapter(this)
        gridView.adapter = imageAdapter

        gridView.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {

                if (currentPos < 0) {
                    if(!winLast) {
                        curView?.setImageResource(R.drawable.question)
                        secondView?.setImageResource(R.drawable.question)
                        winLast = false
                    }
                    currentPos = position
                    curView = view as ImageView
                    (view as ImageView?)?.setImageResource(teachers[cards[position]])
                }
                else {
                    if (currentPos == position) {

                    }

                    else if(cards[currentPos] != cards[position])
                    {
                        (view as ImageView).setImageResource(teachers[cards[position]])
                        winLast = false
                        secondView = view
                        currentPos = -1
                    }
                    else{
                        (view as ImageView?)?.setImageResource(teachers[cards[position]])
                        countPair++
                        currentPos = -1
//                        currentPlay = 2
                        winLast = true
                        secondView = view
                        secondView?.isClickable = true
                        curView?.isClickable = true

                        if(countPair==8)
                        {
                            Toast.makeText(applicationContext,"You win", Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }

        }
    }
}

