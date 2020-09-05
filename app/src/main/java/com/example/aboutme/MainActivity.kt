package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import com.example.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    //Create data to binding
    private lateinit var myName: MyName

    private lateinit var editText: EditText
    private lateinit var nickNameTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Binding data
        myName = MyName(getString(R.string.main_name))
        binding.myName = myName

        nickNameTextView = binding.nicknameText
        editText = binding.nicknameEdit

        binding.doneButon.setOnClickListener {
            addNickName(it)
        }
    }

    private fun addNickName(view: View){

        binding.apply {
            //nickNameTextView.text = editText.text
            myName?.nickname = editText.text.toString()
            invalidateAll()
            editText.visibility = View.GONE
            view.visibility = View.GONE
            nickNameTextView.visibility = View.VISIBLE
        }


        //Hide Keyboard
        val inputMethod = (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
        inputMethod.hideSoftInputFromWindow(view.windowToken, 0)
    }
}