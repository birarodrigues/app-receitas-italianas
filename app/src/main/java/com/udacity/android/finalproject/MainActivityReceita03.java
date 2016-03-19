package com.udacity.android.finalproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivityReceita03 extends AppCompatActivity {

    public static final String TITULO = "Massa de Pizza";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_receita03);

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

        itens.append("1.Misture o fermento, o sal e o açúcar em um pouco de água morna, até que o fermento esteja completamente dissolvido").append(System.getProperty("line.separator"));
        itens.append(System.getProperty("line.separator"));

        itens.append("2.Em seguida, adicione metade da medida de farinha de trigo, o óleo e mexa até criar uma consistência pastosa").append(System.getProperty("line.separator"));
        itens.append(System.getProperty("line.separator"));

        itens.append("3.Acrescente o restante da farinha de trigo, a água morna e misture bem").append(System.getProperty("line.separator"));
        itens.append(System.getProperty("line.separator"));

        itens.append("4.Assim que a massa desgrudar das mãos, deixe crescer por 30 minutos").append(System.getProperty("line.separator"));
        itens.append(System.getProperty("line.separator"));

        itens.append("5.Abra os discos, fure a massa com um garfo e pincele o molho").append(System.getProperty("line.separator"));
        itens.append(System.getProperty("line.separator"));

        itens.append("6.Leve ao forno médio (180° C), preaquecido, por 15 minutos").append(System.getProperty("line.separator"));

        return itens;
    }

    public StringBuilder getIngredientes(){

        StringBuilder itens = new StringBuilder();

        itens.append("✓ 1 kg de farinha de trigo");
        itens.append(System.getProperty("line.separator"));

        itens.append("✓ 30 g de fermento biológico");
        itens.append(System.getProperty("line.separator"));

        itens.append("✓ 3 xícaras de água mornas");
        itens.append(System.getProperty("line.separator"));

        itens.append("✓ 3/4 xícaras de óleo");
        itens.append(System.getProperty("line.separator"));

        itens.append("✓ 1 colher (chá) de sal");
        itens.append(System.getProperty("line.separator"));

        itens.append("✓ 1 colher (chá) de açúcar");
        itens.append(System.getProperty("line.separator"));

        itens.append("✓ 1 colher (sopa) de pinga");
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
