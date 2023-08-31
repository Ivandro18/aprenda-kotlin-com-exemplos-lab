enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario (val matricula: Int, var nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String) {
	
    var conteudos = mutableListOf<ConteudoEducacional>()
    
    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
    fun listarUsuarios (){
        println("Curso de $nome")
        println("Lista de alunos")
        for (x in inscritos) println("Matricula: ${x.matricula},  Nome: ${x.nome}")
    }
    
    fun addConteudo (conteudo: ConteudoEducacional){
        conteudos.add(conteudo)
    }
    
    fun listarConteudos(){
        println("Curso de $nome")
        println("Conteudo do curso")
    	for (x in conteudos) println("Nome: ${x.nome},  Duração: ${x.duracao},  Nivel: ${x.nivel}")
    }
}

fun main() {
    val formacao1 = Formacao("Front")
    
    val novoConteudo = ConteudoEducacional("Matematica financeira", 30, Nivel.BASICO)
    formacao1.addConteudo(novoConteudo)    
    
    val novoConteudo2 = ConteudoEducacional("Programação 3", 20, Nivel.INTERMEDIARIO)
    formacao1.addConteudo(novoConteudo2)   
    
    formacao1.listarConteudos()
    println()
    
    val aluno1 = Usuario(1, "ivandro")
    formacao1.matricular(aluno1)
    
    val aluno2 = Usuario(2, "Breno")
    formacao1.matricular(aluno2)
    
    formacao1.listarUsuarios()
}