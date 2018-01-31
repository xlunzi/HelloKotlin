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

    private var blank: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        random = Random()

        mList = mutableListOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B")
        mAdapter = MyAdapter(this, mList)
        gv_content.adapter = mAdapter

        blank = mList.size - 1

        tv_hello.text = "点我开始游戏!"
        tv_hello.setOnClickListener {
            // all.background = ColorDrawable(Color.parseColor(ColorUtil.getColor()))
            tv_hello.text = "开始拼图"
            doRandom()
            mAdapter.notifyDataSetChanged()
        }

        gv_content.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            move(position)
        }
    }

    private fun doRandom() {
        var one: Int
        var two: Int
        var temp: String
        for (i in 0 until mList.size) {
            one = random.nextInt(mList.size)
            two = random.nextInt(mList.size)

            if (one == two) {
                continue
            }
            if (one == blank) {
                blank = two
            } else if (two == blank) {
                blank = one
            }

            temp = mList[one]
            mList[one] = mList[two]
            mList[two] = temp
        }
    }

    private fun move(position: Int) {
        if (!canMove(position)) {
            return
        }

        val temp = mList[position]
        mList[position] = mList[blank]
        mList[blank] = temp

        mAdapter.notifyDataSetChanged()

        blank = position
    }

    private fun canMove(position: Int) = when (blank) {
        position -> false
        0, 3, 6, 9 -> {
            when (position) {
                blank + 1 -> true
                blank + 3 -> true
                blank - 3 -> true
                else -> false
            }
        }
        2, 5, 8, 11 -> {
            when (position) {
                blank - 1 -> true
                blank + 3 -> true
                blank - 3 -> true
                else -> false
            }
        }
        else -> {
            when (position) {
                blank + 1 -> true
                blank - 1 -> true
                blank + 3 -> true
                blank - 3 -> true
                else -> false
            }
        }
    }
}
