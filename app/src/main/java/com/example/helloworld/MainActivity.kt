package com.example.helloworld

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainRecyclerView.layoutManager = LinearLayoutManager(this)
        mainRecyclerView.adapter = MainListAdapter(DocumentModel.getListOfDocuments())

        clickMeButton.setOnClickListener { navigateToSecondActivity() }
    }

    private fun navigateToSecondActivity() {
        val intent = Intent(this,SecondActivity::class.java)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)

    }
}
