package com.udacity.android.finalproject;

import android.content.Intent;
import android.widget.MediaController;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;



public class MainActivityReceita01 extends AppCompatActivity {

    public static final String TITULO = "Macarrão a Bolanhesa";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_receita01);

        showIngredientes(this.getCurrentFocus());

    }

    public  void showPreparo(View view){
        TextView preparoItens = (TextView) findViewById(R.id.text_itens_ingredientes);
        TextView preparoTitulo = (TextView) findViewById(R.id.text_titulo);

        preparoTitulo.setText("Preparo");

        preparoItens.setText(getModoPreparo().toString());
    }

    public StringBuilder getModoPreparo(){
        StringBuilder itens = new StringBuilder();

        itens.append("1.Pique a cebola, refogue por alguns minutos em uma panela com óleo quente até dourar a cebola, mexendo para não queimar").append(System.getProperty("line.separator"));
        itens.append(System.getProperty("line.separator"));

        itens.append("2.Misture a carne moída, deixe cozinhar por alguns minutos").append(System.getProperty("line.separator"));
        itens.append(System.getProperty("line.separator"));

        itens.append("3.Adicione o caldo, o molho, os tomates picados, a cenoura cortada ao meio e mexa bem, deixe cozinhar por aproximadamente 40minutos em fogo baixo com a panela semi tampada").append(System.getProperty("line.separator"));
        itens.append(System.getProperty("line.separator"));

        itens.append("4.Descarte a cenoura depois que o molho estiver pronto").append(System.getProperty("line.separator"));
        itens.append(System.getProperty("line.separator"));

        itens.append("5.Prepare o macarrão, misture o molho ao macarrão e sirva").append(System.getProperty("line.separator"));
        itens.append(System.getProperty("line.separator"));

        itens.append("6.Acompanhamento Sugerido: Queijo Ralado").append(System.getProperty("line.separator"));

        return itens;
    }

    public StringBuilder getIngredientes(){

        StringBuilder itens = new StringBuilder();

        itens.append("✓ 1 Cebola");
        itens.append(System.getProperty("line.separator"));

        itens.append("✓ 1 colher de sopa de azeite de oliva");
        itens.append(System.getProperty("line.separator"));


        itens.append("✓ 5 azeitonas verdes picadas");
        itens.append(System.getProperty("line.separator"));

        itens.append("✓ 2 latas de molho de tomate pronto");
        itens.append(System.getProperty("line.separator"));

        itens.append("✓ 2 Cubos de Caldo de carne ou legumes dissolvidos em 100ml de água");
        itens.append(System.getProperty("line.separator"));

        itens.append("✓ 1 cenoura");
        itens.append(System.getProperty("line.separator"));

        itens.append("✓ 2 tomates picados");
        itens.append(System.getProperty("line.separator"));

        itens.append("✓ 500g de Macarrão");
        itens.append(System.getProperty("line.separator"));

        itens.append("✓ 500g de Carne Moída");
        itens.append(System.getProperty("line.separator"));

        return itens;
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
