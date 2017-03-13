package com.example.paulo.parimparandroid;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

	private TextView tvNome;
	private TextView tvSuaJogada;
	private TextView tvJogadaInimigo;
	private TextView tvNumeroSorteado;
	private TextView tvResultadoJogo;

	public String pegarParImpar(int valor)
	{
		return valor == 1 ? "Par" : "Ímpar";
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);

		tvNome = (TextView) findViewById(R.id.tvNome);
		tvSuaJogada = (TextView) findViewById(R.id.tvSuaJogada);
		tvJogadaInimigo = (TextView) findViewById(R.id.tvJogadaInimigo);
		tvNumeroSorteado = (TextView) findViewById(R.id.tvNumeroSorteado);
		tvResultadoJogo = (TextView) findViewById(R.id.tvResultadoJogo);

		jogar();
	}

	void jogar()
	{
		tvNome.setText("Nome: " + getIntent().getStringExtra("JOGADOR"));

		int parImpar = Integer.parseInt(getIntent().getStringExtra("PAR_IMPAR"));

		String suaJogada = pegarParImpar(parImpar);
		tvSuaJogada.setText(suaJogada);

		String jogadaInimigo = pegarParImpar(parImpar == 1 ? 2 : 1);
		tvJogadaInimigo.setText(jogadaInimigo);

		Random random = new Random();
		int numero = random.nextInt(10) + 1;
		tvNumeroSorteado.setText(Integer.toString(numero));

		String resultadoJogo = numero % 2 == parImpar - 1 ? "venceu" : "perdeu";
		tvResultadoJogo.setText("Você " + resultadoJogo + ".");
		tvResultadoJogo.setTextColor(resultadoJogo.equals("venceu") ? Color.GREEN : Color.RED);
	}

	public void jogarNovamente(View v)
	{
		jogar();
	}

	public void alterarDados(View v)
	{
		finish();
	}
}
