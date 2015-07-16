package br.java.android.laboratorio09;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class PrincipalActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		Tab tab = actionBar.newTab().setText("Aluguel").setTabListener(
				new MenuTabListener<AluguelFragment>(this, "aluguel", 
						AluguelFragment.class));
		actionBar.addTab(tab);
		
		tab = actionBar.newTab().setText("Venda").setTabListener(
				new MenuTabListener<VendaFragment>(this, "venda",
						VendaFragment.class));
		actionBar.addTab(tab);
		
		tab = actionBar.newTab().setText("Clientes").setTabListener(
				new MenuTabListener<ClientesFragment>(this, "clientes",
								ClientesFragment.class));
		actionBar.addTab(tab);
		
		if (savedInstanceState != null) {
            actionBar.
            setSelectedNavigationItem(savedInstanceState.getInt("selected"));
        }
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Exibe o menu; aqui os itens do menu são adicionados ao "action bar".
		getMenuInflater().inflate(R.menu.principal, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Aqui são tratados os itens clicados no Action Bar
		// O Action Bar ira tratar automaticamente os cliques no topo da tela
		// desde que seja especificado o Activity no AndroidManifest.xml
		int id = item.getItemId();
		if (id == R.id.menu_buscar) {
			return true; // Por enquanto nada sera feito
		}
		return super.onOptionsItemSelected(item);
	}

}
