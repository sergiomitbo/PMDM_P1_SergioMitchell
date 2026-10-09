package es.medac.sergiomitchell.app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.MaterialToolbar;

/**
 * Pantalla principal de Bitácora Trader.
 * Toda la interfaz está en res/layout/activity_main.xml (y su variante en layout-land);
 * esta clase solo la "infla", rellena los textos con parámetros y registra el ciclo de vida.
 */
public class MainActivity extends AppCompatActivity {

    /** Etiqueta para filtrar en Logcat los mensajes del ciclo de vida. */
    private static final String TAG = "CicloVida";

    // Datos de ejemplo: la app todavía no guarda operaciones reales.
    private static final int OPERACIONES_SEMANA = 12;
    private static final int PORCENTAJE_ACIERTO = 58;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "MainActivity.onCreate (savedInstanceState " + (savedInstanceState == null ? "vacío" : "con datos") + ")");
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        MaterialToolbar barra = findViewById(R.id.barra_superior);
        setSupportActionBar(barra);
        ajustarMargenesSistema(barra);

        // Textos con parámetros (%1$s, %1$d): el valor se inserta desde Java,
        // pero la frase sigue estando en strings.xml y por tanto se traduce.
        TextView tvSaludo = findViewById(R.id.tv_saludo);
        tvSaludo.setText(getString(R.string.saludo, getString(R.string.nombre_usuario_defecto)));

        TextView tvOperaciones = findViewById(R.id.tv_valor_operaciones);
        tvOperaciones.setText(getString(R.string.formato_entero, OPERACIONES_SEMANA));

        TextView tvAcierto = findViewById(R.id.tv_valor_acierto);
        tvAcierto.setText(getString(R.string.formato_porcentaje, PORCENTAJE_ACIERTO));

        TextView tvResultado = findViewById(R.id.tv_valor_resultado);
        tvResultado.setText(getString(R.string.formato_resultado,
                getString(R.string.signo_positivo), getString(R.string.ejemplo_resultado)));

        TextView tvDetalle = findViewById(R.id.tv_detalle_ultima);
        tvDetalle.setText(getString(R.string.detalle_operacion,
                getString(R.string.ejemplo_instrumento),
                getString(R.string.direccion_largo),
                getString(R.string.ejemplo_puntos)));

        View btnNueva = findViewById(R.id.btn_nueva_operacion);
        btnNueva.setOnClickListener(v ->
                startActivity(new Intent(this, NuevaOperacionActivity.class)));

        View btnDiario = findViewById(R.id.btn_ver_diario);
        btnDiario.setOnClickListener(v ->
                Toast.makeText(this, R.string.aviso_proximamente, Toast.LENGTH_SHORT).show());
    }

    /**
     * Con EdgeToEdge la app dibuja detrás de las barras del sistema: la barra superior
     * recibe el hueco de la barra de estado y el contenido el de la barra de navegación.
     */
    private void ajustarMargenesSistema(MaterialToolbar barra) {
        View raiz = findViewById(R.id.main);
        ViewCompat.setOnApplyWindowInsetsListener(raiz, (v, insets) -> {
            Insets sistema = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(sistema.left, 0, sistema.right, sistema.bottom);
            barra.setPadding(barra.getPaddingLeft(), sistema.top, barra.getPaddingRight(), 0);
            return insets;
        });
    }

    // --- Ciclo de vida: se registra en Logcat (filtro "CicloVida") para la Parte A ---

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "MainActivity.onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "MainActivity.onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "MainActivity.onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "MainActivity.onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "MainActivity.onRestart");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "MainActivity.onSaveInstanceState");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "MainActivity.onDestroy (isFinishing=" + isFinishing() + ")");
    }
}
