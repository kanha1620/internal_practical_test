package com.exam.internal_practical_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAdd.setOnClickListener {
            var name=edtFrName.text.toString()
            var des=edtFrDes.text.toString()
            var price=edtFrPrice.text.toString().toInt()
            var fruit=fruit(name,des,price)
            var db=DBHelper(this)
            edtFrName.setText("")
            edtFrDes.setText("")
            edtFrPrice.setText("")
            var flag =db.Insert(fruit)
            if (flag)
            {
                Toast.makeText(this," thank-you your Record Inserted!!",Toast.LENGTH_SHORT).show()
            }


        }
        btnView.setOnClickListener {
            refreshRecycler()
        }

    }
    fun refreshRecycler()
    {
        var db=DBHelper(this)
        var arr:ArrayList<fruit> = db.retriveAll()
        var adapter=adapter(this,arr)
        myrecycle.adapter=adapter
    }
}