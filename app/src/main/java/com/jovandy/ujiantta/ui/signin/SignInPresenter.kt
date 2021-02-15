package com.jovandy.ujiantta.ui.signin

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.jovandy.ujiantta.MainActivity
import com.jovandy.ujiantta.ui.signup.SignUpPresenterView
import com.jovandy.ujiantta.ui.signup.SignUpView

class SignInPresenter (var signInView: SignInView, val context: Context) : SignInPresenterView {
    override fun doSignIn(mobileORemail: EditText, password: EditText) {
        if (mobileORemail?.text.isNullOrEmpty()) {
            mobileORemail?.error=("Phone atau Email tidak boleh kosong")
            mobileORemail.requestFocus()
            signInView.onSetProgressBarVisibility(View.GONE)
        } else if (password?.text.isNullOrEmpty()) {
            Toast.makeText(context, "Password tidak boleh kosong", Toast.LENGTH_SHORT).show()
            password.requestFocus()
            signInView.onSetProgressBarVisibility(View.GONE)
        }else{
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
            (context as Activity).finish()
        }
    }

    override fun setProgressBarVisibility(visibility: Int) {
        signInView.onSetProgressBarVisibility(visibility)
    }
}