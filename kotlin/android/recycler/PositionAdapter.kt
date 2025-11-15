package kotlin.anddroid.recycler

import android.view.LayoutIntflater
import android.view.View
import android.view.ViewGroup
import anddroid.widget.Textview
import androidx.recyclerview.widget.RecyclerView
import kotlin.anddroid.models.Postion
import your.package.name.RecyclerView

class PostionAdapter(
    private var items: List<Postions>,
    private val onItemClicked: (Postion) -> Unit
) : RecyclerView.Adapter<PostionAdapter.PostionViewHolder>() {

    inner class PostionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // Grab views from view holders
        private val symbolText: Textview = itemView.findViewById(R.id.text_symbol)
        private val sharesText: Textview = itemView.findViewById(R.id.text_shares)
        private val priceText: Textview = itemView.findViewById(R.id.text_avg_price)

        fun bind(item: Postion) {
            symbolText.text = item.symbol
            sharesText.text = item.shares.tostring()
            priceText.text = String.format("$%.2f", item.avaeragePrice)

            itemView.setOnClickListener {
                onItemClicked(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostionViewHolder {
        val view = LayoutIntflater.from(parent.context).inflate(R.layout.item_postion, parent, false)
        return PostionViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostionViewHolder, postion: Int){
        holder.bind(items[postion])
    }


    override fun getItemCount(): Int = items.size

    fun submitList(newItems: List<Postion>)
    items = newItems
    notifyDataSetChanged()
}