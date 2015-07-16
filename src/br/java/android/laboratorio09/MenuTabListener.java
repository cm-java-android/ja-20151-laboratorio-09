package br.java.android.laboratorio09;

import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;

public class MenuTabListener<T> extends Fragment implements TabListener {
	
	private Fragment meuFragment;
	private final Activity minhaActivity;
	private final String meuTag;
	private final Class<T> minhaClasse;

	public MenuTabListener(Activity activityParam, 
							String tagParam,
							Class<T> classeParam) { 
	
		minhaActivity = activityParam; // A activity que ira gerenciar
		meuTag = tagParam;  // O nome do meu Fragment
		minhaClasse = classeParam; // O Fragment que sera exibido
	}
	
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		meuFragment = minhaActivity.getFragmentManager().
				findFragmentByTag(meuTag); 
		// Verificando se Fragment já foi instanciado 
		if (meuFragment == null) { // Sera nulo na 1a vez que executar
			//Não, instanciando e adicionando. 
			meuFragment = Fragment.
					instantiate(minhaActivity, minhaClasse.getName()); 
			ft.add(android.R.id.content, meuFragment, meuTag);
		} else { //Sim, simplesmente exibindo. 
			ft.attach(meuFragment); // Depois da 1a, eu apenas anexo ele
		}
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		if (meuFragment != null) { 
			//Removendo fragment porque outro será anexado 
			ft.detach(meuFragment);
		}
		
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

}
