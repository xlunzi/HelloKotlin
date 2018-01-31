package cn.xlunzi.hellokotlin

import android.app.Activity
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.AdapterView
import cn.xlunzi.hellokotlin.utils.ColorUtil
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : Activity() {

    lateinit var random: Random
    private lateinit var mList: MutableList<String>
    private lateinit var mAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        random = Random()

        tv_hello.text = "你好，世界!"
        tv_hello.setOnClickListener {
            all.background = ColorDrawable(Color.parseColor(ColorUtil.getColor()))
            tv_hello.text = "拼图"
        }

        mList = mutableListOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B")
        mAdapter = MyAdapter(this, mList)
        gv_content.adapter = mAdapter

        gv_content.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            println("xlunzi --> $position")
        }
    }

}
