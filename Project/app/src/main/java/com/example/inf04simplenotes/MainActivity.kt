package com.example.inf04simplenotes

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Arrays

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var notes = mutableListOf(
            "Zakupy: chleb, ser, masło",
            "Do zrobienia: obiad, umyć podłogi",
            "weekend: kino, spacer z psem"
        )
        val NotesView: ListView = findViewById(R.id.notes_listview)
        var notesAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, notes);
        NotesView.adapter = notesAdapter;

        val noteEdit: EditText = findViewById(R.id.notes_editview)
        val addingButton: Button = findViewById(R.id.adding_button)

        addingButton.setOnClickListener {
            notes.add(noteEdit.text.toString())
            notesAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, notes);
            NotesView.adapter = notesAdapter;
        }

    }
}