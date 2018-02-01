package cn.xlunzi.hellokotlin

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.item_num.view.*

/**
 * MyAdapter
 * Created by SunLW on 2018/1/30.
 */

class MyAdapter constructor(mContext: Context, list: List<String>) : BaseAdapter() {

    private var bitmaps: HashMap<String, Bitmap> = HashMap()
    private var mContext = mContext
    private var list = list

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View
        var holder: ViewHolder
        if (convertView == null) {
            view = View.inflate(mContext, R.layout.item_num, null)
            holder = ViewHolder()
            holder.tvNum = view.tv_num_item
            holder.ivPic = view.iv_pic_item
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        var num = list[position]
        when (num) {
            "B" -> {
                holder.tvNum.text = ""
                val drawable = ColorDrawable(Color.parseColor("#FFFFFFFF"))
                holder.tvNum.background = drawable
                holder.ivPic.setImageDrawable(drawable)
            }
            else -> {
                holder.tvNum.text = num
                holder.tvNum.background = ColorDrawable(Color.parseColor("#FF26A69A"))

                var bitmap = bitmaps[num]
                if (bitmap == null) {
                    bitmap = BitmapFactory.decodeResource(mContext.resources, when (num) {
                        "0" -> R.drawable.one_0
                        "1" -> R.drawable.one_1
                        "2" -> R.drawable.one_2
                        "3" -> R.drawable.one_3
                        "4" -> R.drawable.one_4
                        "5" -> R.drawable.one_5
                        "6" -> R.drawable.one_6
                        "7" -> R.drawable.one_7
                        "8" -> R.drawable.one_8
                        "9" -> R.drawable.one_9
                        "A" -> R.drawable.one_10
                        "B" -> R.drawable.one_11
                        else -> R.drawable.one_12
                    })
                    bitmaps[num] = bitmap
                }
                holder.ivPic.setImageDrawable(BitmapDrawable(mContext.resources, bitmap))
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

    class ViewHolder {
        lateinit var tvNum: TextView
        lateinit var ivPic: ImageView
    }
}