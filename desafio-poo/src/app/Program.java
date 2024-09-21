package app;

import java.util.InputMismatchException;
import java.util.Scanner;

import pkg.Bootcamp;
import pkg.Curso;
import pkg.Dev;
import pkg.Mentoria;

public class Program {

    private static final Scanner sc = new Scanner(System.in);
    private static Bootcamp bootcamp;
    
    public static void main(String[] args) {
        bootcamp = criarBootcamp();
        Dev dev = obterDev();
        
        while (true) {
            switch (mostrarMenu()) {
                case 1:
                    inscreverDevNoBootcamp(dev);
                    break;
                case 2:
                    progredirDev(dev);
                    break;
                case 3:
                    exibirInformacoesDev(dev);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    // Removido sc.close() para evitar problemas de reuso
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private static Bootcamp criarBootcamp() {
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Descrição Curso Java");

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso JavaScript");
        curso2.setDescricao("Descrição Curso JavaScript");

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria Java");
        mentoria.setDescricao("Descrição Mentoria Java");

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);
        
        return bootcamp;
    }

    private static Dev obterDev() {
        System.out.println("Digite o nome do desenvolvedor:");
        String nome = sc.nextLine();
        Dev dev = new Dev();
        dev.setNome(nome);
        return dev;
    }

    private static int mostrarMenu() {
        System.out.println("\nEscolha uma opção:");
        System.out.println("1 - Inscrever no Bootcamp");
        System.out.println("2 - Progredir no Bootcamp");
        System.out.println("3 - Ver informações do Desenvolvedor");
        System.out.println("4 - Sair");
        return lerInteiro();
    }

    private static void inscreverDevNoBootcamp(Dev dev) {
        dev.inscreverBootcamp(bootcamp);
        System.out.println("Desenvolvedor " + dev.getNome() + " inscrito com sucesso no Bootcamp " + bootcamp.getNome());
    }

    private static void progredirDev(Dev dev) {
        dev.progredir();
        System.out.println(dev.getNome() + " progrediu no conteúdo.");
    }

    private static void exibirInformacoesDev(Dev dev) {
        System.out.println("Conteúdos Inscritos: " + dev.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos: " + dev.getConteudosConcluidos());
        System.out.println("XP Total: " + dev.calcularTotalXp());
    }

    private static int lerInteiro() {
        while (true) {
            try {
                int numero = sc.nextInt();
                sc.nextLine(); // Consumir a quebra de linha após o número
                return numero;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
                sc.next(); // Limpar entrada inválida
            }
        }
    }
}
