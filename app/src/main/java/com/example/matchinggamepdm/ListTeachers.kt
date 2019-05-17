package com.example.matchinggamepdm

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class ListTeachers : AppCompatActivity() {
    lateinit var lvTeachers: ListView
    private lateinit var dao: DAOTeacher


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_teachers)

        lvTeachers = findViewById(R.id.lvTeachers)
        dao = DAOTeacher(this@ListTeachers)

        popularBanco()

        lvTeachers.adapter = TeacherAdapter(this@ListTeachers)

      }

    private fun popularBanco() {
        if (dao.get().size <= 0 ){
            dao.insert(Teacher("Alex Sandro da Cunha Rego", "Algoritmo e Prog. Estrut., Banco de Dados II", R.drawable.alex ))
            dao.insert(Teacher("Alana Marques de Morais", "BD 2, Análise e Proj. de Sist., Padrões de Projeto de Software",  R.drawable.alana))
            dao.insert(Teacher("Candido Jose Ramos do Egypto", "Algoritmo e Prog. Estrut., Banco de Dados I",  R.drawable.candido))
            dao.insert(Teacher("Crishane Azevedo Freire", "Algoritmo e Prog. Estrut.",  R.drawable.crishane))
            dao.insert(Teacher("Damires Yluska de Souza Fernandes", "Banco de Dados II",  R.drawable.damires))
            dao.insert(Teacher("Denio Mariz Timoteo de Sousa", "Segurança de Dados",  R.drawable.denio))
            dao.insert(Teacher("Edemberg Rocha da Silva", "Algoritmo e Prog. Estrut.",  R.drawable.edemberg))
            dao.insert(Teacher("Fausto Veras Maranhao Ayres", "Prog. Orientada a Objetos, Persistência de Objetos",  R.drawable.fausto))
            dao.insert(Teacher("Francisco Petronio Alencar de Medeiros", "Interação Humano-Computador",  R.drawable.petronio))
            dao.insert(Teacher("Frederico Costa Guedes Pereira", "Fund. Computação, Programação para Web II", R.drawable.fred))
            dao.insert(Teacher("Giovanni Loureiro Franca de Mendonca", "Fund. Computação, ",  R.drawable.giovanni))
            dao.insert(Teacher("Heremita Brasileiro Lira", "Comércio Eletrônico, Gerência de Projetos de Software",  R.drawable.heremita))
            dao.insert(Teacher("Jose Gomes Quaresma Filho", "Fundamentos de Redes",  R.drawable.zefilho))
            dao.insert(Teacher("Pryscilla Marcili Dora", "Fundamentos de Redes",  R.drawable.pryscilla))
            dao.insert(Teacher("Francisco Dantas Nobre Neto", "Linguagem de Marcação",  R.drawable.francisco))
            dao.insert(Teacher("Thiago Jose Marques Moura", "Linguagem de Marcação, Estrutura de Dados",  R.drawable.thiago))
            dao.insert(Teacher("Marcus Vinicius Delgado Varandas", "Legislação Social, Empreendedorismo SI",  R.drawable.varandas))
            dao.insert(Teacher("Nilton Freire Santos", "Banco de Dados I",  R.drawable.nilton))
            dao.insert(Teacher("Lafayette Batista Melo", "Fund. Metodologia, Métod. e Téc. de Pesquisa",  R.drawable.lafayette))
            dao.insert(Teacher("Luiz Carlos Rodrigues Chaves", "Linguagem de Script, Programação para Web I",  R.drawable.luiz))
            dao.insert(Teacher("Leonidas Francisco de Lima Junior", "Protoc. de Redes",  R.drawable.leonidas))
            dao.insert(Teacher("Gustavo Wagner Diniz Mendes", "Sist. Operacionais",  R.drawable.gustavo))
            dao.insert(Teacher("Valeria Maria Bezerra Cavalcanti Maciel", "Padrões de Proj. de Software, Prog. para Disp. Móveis",  R.drawable.valeria))
        }
    }

    inner class TeacherAdapter(private val context: Context) : BaseAdapter() {

        private var lista = dao.get()
        private val mInflator: LayoutInflater

        init {
            this.mInflator = LayoutInflater.from(context)
        }

        override fun getCount(): Int {
            return lista.size
        }
        override fun getItem(position: Int): Any {
            return lista[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val inflater = mInflator.inflate(R.layout.activity_teacher_detail, parent, false)

            val tvNome = inflater.findViewById(R.id.tvNome) as TextView
            val tvDisciplina = inflater.findViewById(R.id.tvDescricao) as TextView
            val ivFoto = inflater.findViewById(R.id.lvTeachersList) as ImageView
            val professor = lista[position]

            ivFoto.setImageResource(professor.foto)
            tvNome.text = professor.nome
            tvDisciplina.text = professor.disciplina


            return inflater
        }

      }

    }

