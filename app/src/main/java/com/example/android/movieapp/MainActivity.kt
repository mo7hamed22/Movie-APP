package com.example.android.movieapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() ,MovieAdapter.OnitemClicllistner{
    val frgmaneger = supportFragmentManager
    val exampleList = generateDummyList(500)

    override fun onitemclicked(position: Int) {//for Virtical Recy
        val model =exampleList.get(position)
        var getImge =model.imagResoure
        var gettitle =model.Name_mov
        var getDes =model.Des_mov
        val intent = Intent(this,MovieDetails::class.java)
        intent.putExtra("Title",gettitle)
        intent.putExtra("Descrption",getDes)
        intent.putExtra("iImageView",getImge)
        this.startActivity(intent)


        //Toast.makeText(this ,"Clicked $position item ",Toast.LENGTH_SHORT).show()
    }

    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        val exampleList_h = generateDummyList2(500)
        recyclerView_h.adapter =horizontalAdapter(exampleList_h)
        recyclerView_h.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView_h.setHasFixedSize(true)





        recyclerView_v.adapter =MovieAdapter(exampleList,this)
        recyclerView_v.layoutManager = LinearLayoutManager(this)
        recyclerView_v.setHasFixedSize(true)
        fragmentfavior()

        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.home -> {
                    R.id.frgholder
                    // Respond to navigation item 1 click
                    return@OnNavigationItemSelectedListener  true
                }
                R.id.favorite -> {
                    fragmentfavior()
                    // Respond to navigation item 2 click
                    return@OnNavigationItemSelectedListener true
                }
                R.id.setting -> {
                    fragmensetting()                    // Respond to navigation item 2 click
                    return@OnNavigationItemSelectedListener    true
                }

            }
            false
        }

    }
    private fun generateDummyList2(size: Int): List<horizontal_exitem> {
        val list = ArrayList<horizontal_exitem>()



        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.superman
                1 -> R.drawable.comp
                else -> R.drawable.jun

            }


            val item = horizontal_exitem(drawable)

            list += item
        }
        return list
    }


    private fun generateDummyList(size: Int): List<Exitem> {
        val list = ArrayList<Exitem>()
        val Movename = arrayOf("Jungle Beat","Superman","Combat Wombat")
        val MoveDes= arrayOf("A homesick alien crash-lands",
            "What if baby Kal-El's rocket landed",
            "تدور أحداث الفيلم حول ماجي ديجنز التي تتحول إلى امرأة أعجوبة، ")


        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable. img11
                1 -> R.drawable. img22
                else -> R.drawable.img33

            }
            val movname = when (i % 3) {
                0 -> Movename[0]
                1 -> Movename[1]
                else -> Movename[2]
            }
            val movDes = when (i % 3) {
                0 -> MoveDes[0]
                1 -> MoveDes[1]
                else -> MoveDes[2]
            }

                val item = Exitem(drawable ,movname ,movDes)

            list += item
        }
        return list
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)

        return true
    }
    fun fragmentfavior()
    {
        val trans_frg = frgmaneger.beginTransaction()
        val frgment = favirotsFrag()
        trans_frg.replace(R.id.host,frgment)
        trans_frg.addToBackStack(null)
        trans_frg.commit()

    }
    fun fragmensetting()
    {
        val trans_frg = frgmaneger.beginTransaction()
        val frgment = settingFrg()
        trans_frg.replace(R.id.host,frgment)
        trans_frg.addToBackStack(null)
        trans_frg.commit()

    }

}
