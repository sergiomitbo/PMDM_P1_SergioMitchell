package es.medac.sergiomitchell.app;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Prueba instrumentada de ejemplo, se ejecuta en un dispositivo o emulador.
 *
 * @see <a href="http://d.android.com/tools/testing">Documentación de pruebas</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("es.medac.sergiomitchell.app", appContext.getPackageName());
    }
}
