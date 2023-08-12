package hieubui.eup.java_android_tutorial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TodoAdapter extends RecyclerView.Adapter<ToDoHolder> {
    private ArrayList<Todo> todos;
    public TodoAdapter(ArrayList<Todo> todos){
        this.todos = todos;
    }
    @NonNull
    @Override
    public ToDoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_view, null);
        ToDoHolder toDoHolder = new ToDoHolder(itemView);
        return toDoHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoHolder holder, int position) {
        Todo todo = todos.get(position);
        holder.bindView(position, todo);
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }
}

class ToDoHolder extends RecyclerView.ViewHolder{
    private TextView tvIndex;
    private TextView tvTitle;
    private TextView tvDescription;
    public ToDoHolder(@NonNull View itemView) {
        super(itemView);
        tvIndex = itemView.findViewById(R.id.tv_index);
        tvTitle = itemView.findViewById(R.id.tv_title);
        tvDescription = itemView.findViewById(R.id.tv_description);
    }

    public void bindView(int index,Todo todo){
         tvIndex.setText(index+"");
         tvTitle.setText(todo.getTitle());
         tvDescription.setText(todo.getDescription());
    }
}