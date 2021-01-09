package me.sanchez.shared.presentation

import dev.icerock.moko.network.generated.models.Recipe
import io.ktor.util.*
import me.sanchez.shared.ioDispatcher
import me.sanchez.shared.services.RecipeService
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import me.sanchez.shared.uiDispatcher

class RecipesPresenterImpl(): RecipesPresenter {
    private var items: ArrayList<Recipe> = arrayListOf()
    private val service: RecipeService = RecipeService()
    private val coroutineContext: CoroutineContext = ioDispatcher
    private lateinit var scope: PresenterCoroutineScope

    override fun attachView(view: RecipesListView) {
        scope = PresenterCoroutineScope(coroutineContext)
        this.view = view
    }

    override fun detachView() {
        scope.viewDetached()
        this.view = null
    }

    @KtorExperimentalAPI
    override fun searchRecipes(query: String, withPics: Boolean) {
        scope.launch {
            val list = service.searchRecipes(query, withPics)
            list.results?.let { elements ->
                items.addAll(elements)
                withContext(uiDispatcher) {
                    view?.setItemsFrom(items)
                }
            }
        }
    }

    override var view: RecipesListView? = null
}

class PresenterCoroutineScope(private val context: CoroutineContext) : CoroutineScope {
    private var onViewDetachJob = Job()
    override val coroutineContext: CoroutineContext
        get() = context + onViewDetachJob

    fun viewDetached() {
        onViewDetachJob.cancel()
    }
}