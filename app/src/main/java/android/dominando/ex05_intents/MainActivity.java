package android.dominando.ex05_intents;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    private static final String[] OPECOES = {
            "Browser",
            "Realizando um Chamada",
            "Mapa",
            "Tocar Musica",
            "SMS",
            "Compartilhar",
            "Minha açao 1",
            "Minha açao 2",
            "Sair"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, OPECOES);

        setListAdapter(adapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);

        Uri uri = null;

        Intent intent = null;

        switch (position) {
            case 0:
                uri = Uri.parse("http://www.google.com.br");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case 1:
                uri = Uri.parse("tel:99999999");
                intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
                break;
            case 2:
                uri = Uri.parse("geo:0,0?q:Rua+6,Goiania");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case 3:
                uri = Uri.parse("file:///mnt/sdcard/musica.mp3");
                intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setDataAndType(uri,"audio/mp3");
                startActivity(intent);
                break;
            case 4:
                uri = Uri.parse("sms:65432");
                intent = new Intent(Intent.ACTION_VIEW,uri);
                intent.putExtra("sms_body", "Corpo do SMS");
                startActivity(intent);
                break;
            case 5:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Compartilhado via Intent");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                break;
            case 6:
                intent = new Intent("dominando.android.ACAO_CUSTOMIZADA");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                break;
            case 7:
                uri = Uri.parse("produto://Notebook/Slim");
                intent = new Intent(Intent.ACTION_VIEW,uri);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                break;
            default:
                finish();

        }

    }
}
