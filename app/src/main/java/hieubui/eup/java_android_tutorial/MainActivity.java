package hieubui.eup.java_android_tutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TodoAdapter todoAdapter;
    private Button buttonAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Todo> todos = new ArrayList();
        for(int i =0;i<10;i++){
            todos.add(new Todo("title "+i+"","description "+i+""));
        }
        todoAdapter = new TodoAdapter(todos);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager( this));
        recyclerView.setAdapter(todoAdapter);
        buttonAdd = findViewById(R.id.add_item);
        buttonAdd.setOnClickListener(v -> {
            ArrayList<Todo> newTodos = new ArrayList<>(todos);
            newTodos.add(new Todo("add ne", "moi duoc them"));
            todoAdapter.setData(newTodos);
        });
    }
}

class Todo{
    private String title;
    private String description;
    Todo(String title,String description){
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}