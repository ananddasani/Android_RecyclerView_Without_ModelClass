# Android_RecyclerView_Without_ModelClass
Simple Recycler View Demo

This topic is a part of [My Complete Andorid Course](https://github.com/ananddasani/Android_Apps)

# Code

**1. Make my_layout.xml (Custom Layout File)**
### recycler_layout.xml
```
<?xml version="1.0" encoding="utf-8"?>
<androidx.appcompat.widget.LinearLayoutCompat xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/linearLayout"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical"
    android:padding="10dp">

    <androidx.cardview.widget.CardView
        android:id="@+id/cardView"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:backgroundTint="@color/teal_700"
        app:cardCornerRadius="50dp">

        <TextView
            android:id="@+id/textView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:text="January"
            android:textColor="@color/white"
            android:textSize="25sp" />

    </androidx.cardview.widget.CardView>

</androidx.appcompat.widget.LinearLayoutCompat>
```

**2. Make Custom Adapter for RecyclerView**
### CustomAdapter.java
```
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    String[] data;
    Context context;

    public CustomAdapter(String[] data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Inflate the layout we just made
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.recycler_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        //Our main logic goes here
        holder.textView.setText(data[position]);

        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Clicked " + data[position], Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
        }
    }
}
```

**3. Do Backend Work**
#### MainActivity.java
```
String[] data = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

CustomAdapter customAdapter;
RecyclerView recyclerView;
recyclerView = findViewById(R.id.recyclerView);

        //set the layout
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        //give data to adapter
        customAdapter = new CustomAdapter(data, getApplicationContext());

        //set the adapter at the end
        recyclerView.setAdapter(customAdapter);
```

# App Highlight
![RecyclerView Simple App1](https://user-images.githubusercontent.com/74413402/192095398-b48eba06-74a6-4c40-b186-03c140568f4d.png)
![RecyclerView Simple Code App2](https://user-images.githubusercontent.com/74413402/192095400-23ff4004-8716-4abc-a5f1-4c6314631278.png)
![RecyclerView Simple Code](https://user-images.githubusercontent.com/74413402/192095401-0d5b1aa1-2628-4459-b67c-2b9498c368d8.png)

