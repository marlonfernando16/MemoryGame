package com.example.matchinggamepdm

import android.content.ContentValues
import android.content.Context

class DAOTeacher {
    private var banco: BancoHelper

    constructor(context: Context){
        this.banco = BancoHelper(context)
    }

    // create
    fun insert(p: Teacher){
        val cv = ContentValues()
        cv.put("nome", p.nome)
        cv.put("disciplina", p.disciplina)
        cv.put("foto", p.foto)
        this.banco.writableDatabase.insert("teacher",null, cv)
    }

    // all
    fun get(): ArrayList<Teacher>{
        val colunas = arrayOf("id", "nome", "disciplina","foto")
        val lista = ArrayList<Teacher>()

        val c = this.banco.readableDatabase.query("teacher", colunas, null, null, null, null, "nome")

        c.moveToFirst()

        if (c.count > 0){
            do {
                val id = c.getInt(c.getColumnIndex("id"))
                val nome = c.getString(c.getColumnIndex("nome"))
                val disciplina = c.getString(c.getColumnIndex("disciplina"))
                val foto = c.getInt(c.getColumnIndex("foto"))
                lista.add(Teacher(id,nome,disciplina,foto))
            }while(c.moveToNext())
        }

        return lista
    }


    // find
    fun get(index: Int): Teacher?{
        val colunas = arrayOf("id", "nome", "disciplina","foto")
        val where = "id = ?"
        val pwhere = arrayOf(index.toString())

        val c = this.banco.readableDatabase.query("teacher", colunas, where, pwhere, null, null, null)

        c.moveToFirst()

        if (c.count > 0){
            val id = c.getInt(c.getColumnIndex("id"))
            val nome = c.getString(c.getColumnIndex("nome"))
            val disciplina = c.getString(c.getColumnIndex("disciplina"))
            val foto = c.getInt(c.getColumnIndex("foto"))
            return Teacher(id, nome, disciplina,foto)
        }

        return null
    }

    // update
    fun update(p: Teacher){
        val where = "id = ?"
        val pwhere = arrayOf(p.id.toString())
        val cv = ContentValues()
        cv.put("id", p.id)
        cv.put("nome", p.nome)
        cv.put("disciplina", p.disciplina)
        cv.put("foto", p.foto)

        this.banco.writableDatabase.update("teacher", cv, where, pwhere)
    }

    // delete
    fun delete(id: Int){
        val where = "id = ?"
        val pwhere = arrayOf(id.toString())

        this.banco.writableDatabase.delete("teacher", where, pwhere)
    }
}