package buu.informatics.s59160081.projectterm_4.screens.screens.score

import android.graphics.Color
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import buu.informatics.s59160081.projectterm_4.R

class ScoreAdapter: RecyclerView.Adapter<TextItemViewHolder>() {

//    var data =  listOf<SleepNight>()
//        set(value) {
//            field = value
//            notifyDataSetChanged()
//        }

    var dataName = listOf("name","name2","name32","name433","name5444","name6","name7","name8","name9","name0","name1")
    var dataScore = listOf("7","9","10","10","9","10","10","10","10","10","10")

    override fun getItemCount() = dataName.size

    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {


        holder.textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24F)
        if (dataName[position].length == 4){
            holder.textView.text =  "\t${dataName[position]} \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t ${dataScore[position]}\n"
        }else if (dataName[position].length == 5){
            holder.textView.text = "\t${dataName[position]} \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t ${dataScore[position]}\n"
        }else if (dataName[position].length == 6){
            holder.textView.text = "\t${dataName[position]} \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t ${dataScore[position]}\n"
        }else if (dataName[position].length == 7){
            holder.textView.text = "\t${dataName[position]} \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t ${dataScore[position]}\n"
        }else{
            holder.textView.text = "\t${dataName[position]} \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t ${dataScore[position]}\n"
        }
        holder.textView.setTextColor(Color.BLACK)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val view = layoutInflater
            .inflate(R.layout.text_item_view, parent, false) as TextView

        return TextItemViewHolder(view)
    }
}

class TextItemViewHolder(val textView: TextView): RecyclerView.ViewHolder(textView)