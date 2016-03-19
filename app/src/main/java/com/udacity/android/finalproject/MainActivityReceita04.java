package com.udacity.android.finalproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivityReceita04 extends AppCompatActivity {

    public static final String TITULO = "Molho Pesto";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_receita04);

        showIngredientes(this.getCurrentFocus());
    }

    public  void showPreparo(View view){
        TextView preparoItens = (TextView) findViewById(R.id.text_itens_ingredientes);
        TextView preparoTitulo = (TextView) findViewById(R.id.text_titulo);

        preparoTitulo.setText("Preparo");

        preparoItens.setText(getModoPreparo().toString());
    }

    public  void showIngredientes(View view){
        TextView ingredientesItens = (TextView) findViewById(R.id.text_itens_ingredientes);
        TextView ingredientesTitulo = (TextView) findViewById(R.id.text_titulo);

        ingredientesTitulo.setText("Ingredientes");

        ingredientesItens.setText(getIngredientes().toString());
    }

    public StringBuilder getModoPreparo(){

        StringBuilder itens = new StringBuilder();

        itens.append("1.Bata os ingredientes no liquidificador até obter uma pasta grossa").append(System.getProperty("line.separator"));
        itens.append(System.getProperty("line.separator"));

        itens.append("2.Sirva com massas ou filé de frango grelhado").append(System.getProperty("line.separator"));
        itens.append(System.getProperty("line.separator"));

        return itens;
    }


    public StringBuilder getIngredientes(){

        StringBuilder itens = new StringBuilder();

        itens.append("✓ 50 g de castanha de caju torradas");
        itens.append(System.getProperty("line.separator"));

        itens.append("✓ 25g de folhas de manjericão frescas (1/2 maço)");
        itens.append(System.getProperty("line.separator"));

        itens.append("✓ 15 colheres (sopa) de azeite de oliva");
        itens.append(System.getProperty("line.separator"));

        itens.append("✓ 200 g de tomate seco");
        itens.append(System.getProperty("line.separator"));

        itens.append("✓ Sal a gosto");
        itens.append(System.getProperty("line.separator"));

        return itens;
    }

    public String getBodyMessage(){

        StringBuilder bodyMail  = new StringBuilder();

        bodyMail.append("Ingredientes").append(System.getProperty("line.separator"))
                .append(System.getProperty("line.separator"));

        bodyMail.append(getIngredientes()).append(System.getProperty("line.separator"))
                .append(System.getProperty("line.separator"));

        bodyMail.append("Modo de preparo").append(System.getProperty("line.separator"))
                .append(System.getProperty("line.separator"));

        bodyMail.append(getModoPreparo());

        return bodyMail.toString();
    }

    public void sendRecipe(View view){
        Intent intentMail = new Intent(Intent.ACTION_SENDTO);

        intentMail.setData(Uri.parse("mailto:"));

        intentMail.putExtra(Intent.EXTRA_SUBJECT, TITULO);
        intentMail.putExtra(Intent.EXTRA_TEXT, getBodyMessage());

        if(intentMail.resolveActivity(getPackageManager()) != null){
            startActivity(intentMail);
        }
    }
}
