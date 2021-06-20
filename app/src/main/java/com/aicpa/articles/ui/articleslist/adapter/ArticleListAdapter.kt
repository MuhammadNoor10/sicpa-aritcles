package com.aicpa.articles.ui.articleslist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.aicpa.articles.R
import com.aicpa.articles.databinding.ItemArticleListBinding
import com.aicpa.articles.ui.articleslist.model.Article

/**
 * Created by Noor aka Thor on 6/21/21.
 */
class ArticleListAdapter(private var items: List<Article> = emptyList()): RecyclerView.Adapter<ArticleListAdapter.ArticleListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleListViewHolder {
        return ArticleListViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_article_list, parent, false))
    }

    override fun onBindViewHolder(holder: ArticleListViewHolder, position: Int) {
        holder.bind(items[position], position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateData(newItems: List<Article>) {
        items = newItems
        notifyDataSetChanged()
    }

    class ArticleListViewHolder(private val binding: ItemArticleListBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: Article, position: Int){
            binding.article = item
            binding.position = position
        }
    }
}