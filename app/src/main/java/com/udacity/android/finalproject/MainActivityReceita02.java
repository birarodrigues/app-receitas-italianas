package com.udacity.android.finalproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivityReceita02 extends AppCompatActivity {

    public static final String TITULO = "Palha Italiana";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_receita02);

        showIngredientes(this.getCurrentFocus());
    }

    public StringBuilder getModoPreparo(){

        StringBuilder itens = new StringBuilder();

        itens.append("1.Pique o biscoito em pedacinhos pequenos e reserve").append(System.getProperty("line.separator"));
        itens.append(System.getProperty("line.separator"));

        itens.append("2.Com o leite condensado, a margarina e o chocolate em pó, faça um brigadeiro").append(System.getProperty("line.separator"));
        itens.append(System.getProperty("line.separator"));

        itens.append("3.Assim que o brigadeiro começar a soltar do fundo da panela, misture o biscoito picado até formar uma massa, retire do fogo").append(System.getProperty("line.separator"));
        itens.append(System.getProperty("line.separator"));

        itens.append("4.Unte uma bancada de mármore, ou alguma superfície lisa, com margarina e despeje essa massa").append(System.getProperty("line.separator"));
        itens.append(System.getProperty("line.separator"));

        itens.append("5.Abra a massa, batendo com a palma das mãos").append(System.getProperty("line.separator"));
        itens.append(System.getProperty("line.separator"));

        itens.append("6.Deixe esfriar e corte em quadradinhos").append(System.getProperty("line.separator"));

        return itens;
    }

    public StringBuilder getIngredientes(){

        StringBuilder itens = new StringBuilder();


        itens.append("✓ 1 lata de leite condensado");
        itens.append(System.getProperty("line.separator"));

        itens.append("✓ 8 colheres(sopa) de chocolate em pó");
        itens.append(System.getProperty("line.separator"));


        itens.append("✓ 1/2 colher (sopa) de margarina");
        itens.append(System.getProperty("line.separator"));

        itens.append("✓ 1 pacote de biscoito maisena");
        itens.append(System.getProperty("line.separator"));

        return itens;
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
