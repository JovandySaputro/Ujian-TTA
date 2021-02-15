package com.jovandy.ujiantta.ui.signin

interface SignInView {
    fun onSetProgressBarVisibility(visibility: Int)

    fun showError(message: String)
}