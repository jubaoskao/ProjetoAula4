package sistema.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.SelectEvent;

import sistema.modelos.Aluno;
import sistema.service.AlunoService;

@ManagedBean
@SessionScoped
public class AlunoManagedBean {
	
	private Aluno aluno = new Aluno();
	private AlunoService service = new AlunoService();
	
	public void salvar()
	{
		service.salvar(aluno);
		aluno = new Aluno();
		
	}
	
	public void remover(Aluno a)
	{
		System.out.println("REMOVEP1");
		service.remover(a);
		a = new Aluno();
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getAlunos() {
		return service.getAlunos();
	}
	
	public void onRowSelect(SelectEvent event) {
	     System.out.println("Evento Select: AlunoSelecionado : " +  (Aluno) event.getObject());
	}
	
	public void onRowUnselect(SelectEvent event) {
		System.out.println("Evento UnSelect " +  (Aluno) event.getObject());
			 
    }

}
