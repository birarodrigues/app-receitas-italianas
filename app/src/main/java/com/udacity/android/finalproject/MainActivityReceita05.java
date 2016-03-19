package com.udacity.android.finalproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivityReceita05 extends AppCompatActivity {

    public static final String TITULO = "Macarrão com sardinha";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_receita05);

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

        itens.append("1.Coloque meio litro de água e sal a gosto numa panela e coloque no fogo").append(System.getProperty("line.separator"));
        itens.append(System.getProperty("line.separator"));

        itens.append("2.Quando a água estiver fervendo coloque o macarrão, sempre mexer para não grudar").append(System.getProperty("line.separator"));
        itens.append(System.getProperty("line.separator"));

        itens.append("3.Quando o macarrão estiver mole retire do fogo e escorra a água").append(System.getProperty("line.separator"));
        itens.append(System.getProperty("line.separator"));

        itens.append("4.Em seguida refogue os dentes de alho no óleo por alguns minutos").append(System.getProperty("line.separator"));
        itens.append(System.getProperty("line.separator"));

        itens.append("5.Misture o macarrão, o alho e as sardinhas, depois é só servir").append(System.getProperty("line.separator"));
        itens.append(System.getProperty("line.separator"));

        return itens;
    }

    public  StringBuilder getIngredientes(){

        StringBuilder itens = new StringBuilder();

        itens.append("✓ 1 pacote de macarrão");
        itens.append(System.getProperty("line.separator"));

        itens.append("✓ 1/2 litro de agua");
        itens.append(System.getProperty("line.separator"));

        itens.append("✓ 5 dentes de alho picados");
        itens.append(System.getProperty("line.separator"));

        itens.append("✓ 2 colheres de sopa de óleo");
        itens.append(System.getProperty("line.separator"));

        itens.append("✓ 1 lata de sardinha");
        itens.append(System.getProperty("line.separator"));

        itens.append("✓ sal a gosto");
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
