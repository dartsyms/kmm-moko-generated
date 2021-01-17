package me.sanchez.androidApp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.sanchez.androidApp.databinding.RecipeItemBinding
import me.sanchez.shared.models.Recipe

typealias Recipes = MutableList<Recipe>

class RecipesAdapter(private var recipesList: Recipes): RecyclerView.Adapter<RecipesAdapter.RecipeHolder>() {

    private lateinit var binding: RecipeItemBinding

//    var onItemClick: ((recipe: Recipe) -> Unit)? = null
//    private var allItemsLoaded: Boolean = false
//    var pageOffset = 0


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeHolder {
        binding = RecipeItemBinding.inflate(LayoutInflater.from(parent.context))
        return RecipeHolder(binding.root)
    }

    override fun onBindViewHolder(holder: RecipeHolder, position: Int) = holder.let {
        it.clear()
        it.onBind(position)
    }

    override fun getItemCount(): Int = this.recipesList.size

    fun reloadItems(items: Recipes) {
        recipesList.clear()
        recipesList.addAll(items)
        notifyDataSetChanged()
    }

    fun clearList() {
        recipesList.clear()
        notifyDataSetChanged()
    }


    inner class RecipeHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun clear() {
            binding.tvTitle.text = ""
            binding.tvIngredients.text = ""
            binding.ivPic.setImageDrawable(null)
        }

        fun onBind(position: Int) {
            val recipe = recipesList[position]
            inflateRecipeData(recipe)
            setItemClickListener(recipe)
        }

        private fun setItemClickListener(recipe: Recipe) {}

        @SuppressLint("SetTextI18n")
        private fun inflateRecipeData(recipe: Recipe) {
            val placeholderUrl = "https://via.placeholder.com/150"
            recipe.title?.let {
                binding.tvTitle.text = it
            } ?: run {
                binding.tvTitle.text = "No Title"
            }
            recipe.ingredients?.let {
                binding.tvIngredients.text = it
            } ?: run {
                binding.tvIngredients.text = "No Ingredients"
            }
            recipe.thumbnail?.let {
                binding.ivPic.loadImage(it)
            } ?: run {
                binding.ivPic.loadImage(placeholderUrl)
            }
        }
    }
}