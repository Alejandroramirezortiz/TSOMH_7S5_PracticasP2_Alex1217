package mx.edu.tesoem.isc.tsdmh_7s4_prac4_alex1217;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText; // Añadido para capturar datos
import android.widget.Toast;

public class FormularioFragment extends Fragment {

    public FormularioFragment() {
        // Constructor vacío requerido
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_formulario, container, false);

        Button btnGuardar = vista.findViewById(R.id.btnGuardar);


        EditText etNombre = vista.findViewById(R.id.etNombre);
        EditText etTelefono = vista.findViewById(R.id.etTelefono);


        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = etNombre.getText().toString();

                Toast.makeText(getContext(), "Datos de " + nombre + " guardados correctamente", Toast.LENGTH_SHORT).show();
            }
        });

        return vista;
    }
}