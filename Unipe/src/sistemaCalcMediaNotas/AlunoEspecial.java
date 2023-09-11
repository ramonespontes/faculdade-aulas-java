package sistemaCalcMediaNotas;

public class AlunoEspecial extends Aluno{
	
	public float calcularMedia(float n1, float n2, float n3, float n4) {

		float media = 0.0f;

		media = ((n1 + n2 + n3 + n4) / 4)*1.75f;

		return media;

	}

}
