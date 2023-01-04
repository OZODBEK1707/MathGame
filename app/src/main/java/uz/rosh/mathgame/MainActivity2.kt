package com.orsh.uz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import uz.rosh.mathgame.R
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    var javob = 0
    var radBtnJavob = 0
    var radBtnChekedJavob = -1
    var togriJavobSoni=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        random()


        val view: ArrayList<View> = arrayListOf<View>(viev_javob, viev_javob2, viev_javob3, viev_javob4, viev_javob5,
            viev_javob6, viev_javob7, viev_javob8, viev_javob9, viev_javob10)
        var viewIndex = 0

        btn_keyingi.setOnClickListener(View.OnClickListener {

            if (rad_a.isChecked) radBtnChekedJavob = 0
            if (rad_b.isChecked) radBtnChekedJavob = 1
            if (rad_c.isChecked) radBtnChekedJavob = 2
            if (rad_d.isChecked) radBtnChekedJavob = 3

            println("$radBtnChekedJavob   $radBtnJavob")

            if (radBtnChekedJavob == radBtnJavob) {
                Toast.makeText(this, "To'g'ri javob", Toast.LENGTH_SHORT).show()

                view[viewIndex].setBackgroundResource(R.drawable.fon1)

                togriJavobSoni++
            } else {
                Toast.makeText(this, "Noto'g'ri javob", Toast.LENGTH_SHORT).show()

                view[viewIndex].setBackgroundResource(R.drawable.ic_launcher_background)

            }
            viewIndex++
            btn_group.clearCheck()
            radBtnChekedJavob = -1
            random()
            if (viewIndex == view.size){

                txt_misol.setText("Siz 10 ta savoldan $togriJavobSoni tasigaa\n to'g'ri javob berdingiz")
                val a= txt_misol.textSize - 70
                txt_misol.textSize = a
                btn_group.clearCheck()
                btn_keyingi.isEnabled = false
            }

        })
    }

    fun random(){

        var number1 = Random().nextInt(100)
        println("random number1: $number1")
        var number2 = Random().nextInt(100)
        println("random number2: $number2")
        var amal = Random().nextInt(4)
        println("random amal: $amal")

        when(amal){
            0 ->{
                javob = number1 + number2
                txt_misol.text = "$number1 +$number2"
            }
            1 ->{
                javob = number1-number2
                txt_misol.text = "$number1 - $number2"
            }
            2 ->{
                javob = number1 * number2
                txt_misol.text = "$number1 * $number2"
            }
            3 ->{
                try {
                    javob = number1 / number2
                    if (number1%number2 == 0) {
                        txt_misol.text = "$number1 / $number2"
                    }else{
                        throw ArithmeticException()
                    }
                }catch (e:ArithmeticException){
                    random()
                }
            }
        }

        radioButtonSet()
    }

    fun radioButtonSet(){
        var a=Random().nextInt(100)
        var b=Random().nextInt(100)
        var c=Random().nextInt(100)

        println("radibutton javo: $javob")

        radBtnJavob= Random().nextInt(4)

        if (javob != a && javob!=b && javob!=c) {
            when (radBtnJavob) {
                0 -> {
                    rad_a.text = javob.toString()
                    rad_b.text = a.toString()
                    rad_c.text = b.toString()
                    rad_d.text = c.toString()
                }
                1 -> {
                    rad_a.text = a.toString()
                    rad_b.text = javob.toString()
                    rad_c.text = b.toString()
                    rad_d.text = c.toString()
                }
                2 -> {
                    rad_b.text = a.toString()
                    rad_a.text = b.toString()
                    rad_c.text = javob.toString()
                    rad_d.text = c.toString()
                }
                3 -> {
                    rad_b.text = a.toString()
                    rad_c.text = b.toString()
                    rad_c.text = c.toString()
                    rad_d.text = javob.toString()
                }
            }
            println("radibutton javo: $javob")
        }else{
            radioButtonSet()
        }
        println("radibutton javo: $javob")

    }
}