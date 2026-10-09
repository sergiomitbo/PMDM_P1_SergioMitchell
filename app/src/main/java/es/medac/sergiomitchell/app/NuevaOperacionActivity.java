package es.medac.sergiomitchell.app;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.MaterialToolbar;

/**
 * Formulario para anotar una operación. En esta práctica solo se diseña la interfaz:
 * al pulsar "Guardar" se muestra un aviso y se vuelve a la pantalla principal.
 */
public class NuevaOperacionActivity extends AppCompatActivity {

    private static final String TAG = "CicloVida";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "NuevaOperacionActivity.onCreate");
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nueva_operacion);

        MaterialToolbar barra = findViewById(R.id.barra_superior);
        setSupportActionBar(barra);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        View raiz = findViewById(R.id.raiz_formulario);
        ViewCompat.setOnApplyWindowInsetsListener(raiz, (v, insets) -> {
            Insets sistema = insets.getInsets(WindowInsetsCompat.Type.systemBars()
                    | WindowInsetsCompat.Type.ime());
            v.setPadding(sistema.left, 0, sistema.right, sistema.bottom);
            barra.setPadding(barra.getPaddingLeft(), sistema.top, barra.getPaddingRight(), 0);
            return insets;
        });

        findViewById(R.id.btn_guardar).setOnClickListener(v -> {
            Toast.makeText(this, R.string.aviso_guardado, Toast.LENGTH_SHORT).show();
            finish();
        });
        findViewById(R.id.btn_cancelar).setOnClickListener(v -> finish());
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "NuevaOperacionActivity.onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "NuevaOperacionActivity.onDestroy");
    }
}
