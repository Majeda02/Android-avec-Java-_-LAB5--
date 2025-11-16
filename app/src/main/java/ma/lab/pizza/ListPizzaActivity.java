package ma.lab.pizza;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import ma.lab.pizza.adapter.PizzaAdapter;
import ma.lab.pizza.classes.Produit;
import ma.lab.pizza.service.ProduitService;

import androidx.appcompat.widget.Toolbar;


public class ListPizzaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_list_pizza);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

// 👉 Ici : définir le titre que tu veux afficher dans la Toolbar
        getSupportActionBar().setTitle("Pizza Recipes");
        ListView lv = findViewById(R.id.lvPizzas);


        List<Produit> pizzas = ProduitService.getInstance().findAll();


        lv.setAdapter(new PizzaAdapter(this, pizzas));

        lv.setOnItemClickListener((parent, view, pos, id) -> {
            Intent it = new Intent(this, PizzaDetailActivity.class);
            it.putExtra("pizza_id", id);
            startActivity(it);
        });
    }
}
