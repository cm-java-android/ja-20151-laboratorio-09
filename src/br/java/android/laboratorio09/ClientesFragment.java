package br.java.android.laboratorio09;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ClientesFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View visao = 
				inflater.inflate(R.layout.clientes_fragment, container, false);
		return visao;
	}
}
