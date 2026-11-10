package mx.edu.tesoem.isc.tsdmh_7s4_prac4_alex1217;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

public class PrincipalActivity extends AppCompatActivity {
    Button btnImageFragment, btnFormFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_principal);

        // Configuración de Insets para diseño Edge-to-Edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicialización de botones
        btnImageFragment = findViewById(R.id.btnImageFragment);
        btnFormFragment = findViewById(R.id.btnFormFragment);

        // Cargar fragmento inicial por defecto
        if (savedInstanceState == null) {
            loadFragment(new ImagenFragment());
        }

        // Listeners de los botones
        btnFormFragment.setOnClickListener(v -> loadFragment(new FormularioFragment()));
        btnImageFragment.setOnClickListener(v -> loadFragment(new ImagenFragment()));
    }

    /**
     * Método para realizar la transacción de fragmentos.
     * @param fragment El fragmento que se desea mostrar.
     */
    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainerView, fragment)
                .setReorderingAllowed(true)
                .commit(); // Se corrigió el error de dedo de "comit"
    }
}