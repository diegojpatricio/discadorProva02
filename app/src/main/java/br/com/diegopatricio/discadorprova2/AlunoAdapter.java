package br.com.diegopatricio.discadorprova2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AlunoAdapter {

    private Context context;
    private List<Aluno> alunos;

    public AlunoAdapter(Context context, List<Aluno> alunos){
        this.context = context;
        this.alunos = alunos;
    }

    @Override
    public int getCount(){return alunos.size();}

    @Override
    public Object getItem(int i){return alunos.get(i);}

    @Override
    public long getItemId(int i){return i;}

    @Override
    public View getView(int i, View view, ViewGroup viewGroup){

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.activity_lista_alunos, null);

        Aluno aluno = alunos.get(i);
        TextView idAluno = layout.findViewById(R.id.idAluno);
        TextView nomeAluno = layout.findViewById(R.id.nomeAluno);
        TextView emailAluno = layout.findViewById(R.id.emailAluno);
        TextView telefoneAluno = layout.findViewById(R.id.telefoneAluno);

        idAluno.setText(String.valueOf(aluno.getId()));
        nomeAluno.setText(aluno.getNome());
        emailAluno.setText(aluno.getEmail());
        telefoneAluno.setText(aluno.getTelefone());

        return layout;
    }
}
