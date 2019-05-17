package com.example.matchinggamepdm

import android.widget.ImageView

class Teacher {
    var id: Int
    var nome: String
    var disciplina: String
    var foto:Int


    constructor(id: Int,nome: String,disciplina:String,foto:Int) {
        this.id = id
        this.nome = nome
        this.disciplina= disciplina
        this.foto = foto

    }

    constructor(nome: String,disciplina:String,foto:Int) {
        this.id = -1
        this.nome = nome
        this.disciplina= disciplina
        this.foto = foto

    }

    override fun toString(): String {
        return "${nome} - ${disciplina}"
    }
}