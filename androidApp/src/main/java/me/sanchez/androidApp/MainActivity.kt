package me.sanchez.androidApp

import android.app.SearchManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.core.view.MenuItemCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import me.sanchez.shared.models.Recipe
import me.sanchez.shared.presentation.RecipesListView
import me.sanchez.shared.presentation.RecipesPresenter
import me.sanchez.shared.presentation.RecipesPresenterImpl


class MainActivity : AppCompatActivity(), RecipesListView {
    private val presenter: RecipesPresenter = RecipesPresenterImpl()
    private var adapter: RecipesAdapter? = null
    private var rvList: RecyclerView? = null
    private var searchView: SearchView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvList = findViewById(R.id.recipesList)
        rvList?.layoutManager = LinearLayoutManager(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.attachView(this)
    }

    override fun onPause() {
        presenter.detachView()
        super.onPause()
    }

    override fun setItemsFrom(list: List<Recipe>) {
        if (adapter == null) {
            adapter = RecipesAdapter(list.toMutableList())
        }
        adapter?.reloadItems(list.toMutableList())
        rvList?.adapter = adapter
    }

    override fun onBackPressed() {
        searchView?.let {
            if (!it.isIconified) {
                searchView?.onActionViewCollapsed()
            } else {
                super.onBackPressed()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.search_item, menu)
        val searchItem: MenuItem = menu.findItem(R.id.action_search)
        searchView = MenuItemCompat.getActionView(searchItem) as SearchView
        searchView?.setOnCloseListener { true }

        val searchPlate = searchView?.findViewById(R.id.search_src_text) as EditText
        searchPlate.hint = "Search"
        val searchPlateView: View? =
            searchView?.findViewById(R.id.search_plate)
        searchPlateView?.setBackgroundColor(
            ContextCompat.getColor(
                this,
                android.R.color.transparent
            )
        )

        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Toast.makeText(applicationContext, query, Toast.LENGTH_SHORT).show()
                presenter.searchRecipes(query ?: "", true)
                searchView?.isIconified = true
                searchView?.clearFocus()
                (menu.findItem(R.id.action_search)).collapseActionView()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    if (it.length < 2) {
                        adapter?.clearList()
                    }
                }
                return true
            }
        })

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView?.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        return super.onCreateOptionsMenu(menu)
    }
}
