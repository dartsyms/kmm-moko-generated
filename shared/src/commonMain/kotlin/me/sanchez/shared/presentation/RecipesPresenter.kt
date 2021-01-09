package me.sanchez.shared.presentation

interface RecipesPresenter {
    var view: RecipesListView?
    fun searchRecipes(query: String, withPics: Boolean)
    fun attachView(view: RecipesListView)
    fun detachView()
}