package com.example.paulo.parimparandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class PlayerActivity extends AppCompatActivity {

	private EditText etNome;
	private RadioGroup rgParImpar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player);

		etNome = (EditText) findViewById(R.id.etNome);
		rgParImpar = (RadioGroup) findViewById(R.id.rgParImpar);
	}

	public void jogar(View v)
	{
		if (etNome.getText().toString().equals(""))
		{
			Toast.makeText(this, "Insira seu nome.", Toast.LENGTH_SHORT).show();
			return;
		}

		int parImpar = rgParImpar.getCheckedRadioButtonId();
		View rbParImpar = rgParImpar.findViewById(parImpar);
		parImpar = rgParImpar.indexOfChild(rbParImpar) + 1;

		Intent telaGame = new Intent(this, GameActivity.class);

		telaGame.putExtra("JOGADOR", etNome.getText().toString());
		telaGame.putExtra("PAR_IMPAR", Integer.toString(parImpar));

		startActivityForResult(telaGame, 1);
	}
}
