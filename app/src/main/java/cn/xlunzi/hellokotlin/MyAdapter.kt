package cn.xlunzi.hellokotlin

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.item_num.view.*

/**
 * MyAdapter
 * Created by SunLW on 2018/1/30.
 */

class MyAdapter constructor(mContext: Context, list: List<String>) : BaseAdapter() {

    private var mContext = mContext
    private var list = list
    private lateinit var tvNum: TextView

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View
        if (convertView == null) {
            view = View.inflate(mContext, R.layout.item_num, null)
            tvNum = view.tv_num_item
        } else {
            view = convertView
        }

        var num = list[position]
        when (num) {
            "B" -> {
                tvNum.text = ""
                tvNum.background = ColorDrawable(Color.parseColor("#FFFFFFFF"))
            }
            else -> {
                tvNum.text = num
                tvNum.background = ColorDrawable(Color.parseColor("#FF26A69A"))
            }
        }

        return view
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }

}