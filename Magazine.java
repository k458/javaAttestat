import java.util.*;

public class Magazine {
    private static Notebook notebookFilter = new Notebook(false);
    private static Set<Notebook> notebooks = new TreeSet<>();
    private static int amount = 10;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        for (int i = 0; i < amount; i++) {
            notebooks.add(new Notebook());
        }
        work();
    }
    private static void work(){
        while (true){
            System.out.print("Filter parameters: ");
            printNotebookFilter();
            System.out.println("Select: ");
            System.out.println("0: RAM");
            System.out.println("1: HDD");
            System.out.println("2: OS");
            System.out.println("3: Color");
            System.out.println("4: Start filter");
            System.out.println("5: Reset filter");
            Scanner scanner = new Scanner(System.in);
            int select = -1;
            try {
                select = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                continue;
            }
            switch (select) {
                case 0:
                    selectRAMOptions();
                    notebookFilter.updateMarketName();
                    break;
                case 1:
                    selectHDDOptions();
                    notebookFilter.updateMarketName();
                    break;
                case 2:
                    selectOSOptions();
                    notebookFilter.updateMarketName();
                    break;
                case 3:
                    selectColorOptions();
                    notebookFilter.updateMarketName();
                    break;
                case 4:
                    printNotebookFiltered();
                    break;
                case 5:
                    notebookFilter = new Notebook(false);
                    break;
                default:
                    break;
            }
            System.out.println();
        }
    }
    private static void printNotebookFilter(){
        notebookFilter.updateMarketName();
        System.out.println(notebookFilter.marketName);
    }
    private static void selectRAMOptions(){
        for (int i = 0; i < Notebook.RAMs.length; i++) {
            sb.setLength(0);
            sb.append(i + ". ");
            sb.append(Notebook.RAMs[i] + "Gb");
            System.out.println(sb.toString());
        }
        while (true){
            Scanner scanner = new Scanner(System.in);
            int select = -1;
            try {
                select = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                continue;
            }
            System.out.println(notebookFilter.RAM + " >>> " + Notebook.RAMs[select]);
            notebookFilter.RAM = Notebook.RAMs[select];
            break;
        }
    }
    private static void selectHDDOptions(){
        for (int i = 0; i < Notebook.HDDs.length; i++) {
            sb.setLength(0);
            sb.append(i + ". ");
            sb.append(Notebook.RAMs[i] + "Tb");
            System.out.println(sb.toString());
        }
        while (true){
            Scanner scanner = new Scanner(System.in);
            int select = -1;
            try {
                select = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                continue;
            }
            notebookFilter.HDD = Notebook.HDDs[select];
            break;
        }
    }
    private static void selectOSOptions(){
        for (int i = 0; i < Notebook.OSs.length; i++) {
            sb.setLength(0);
            sb.append(i + ". ");
            sb.append(Notebook.OSs[i]);
            System.out.println(sb.toString());
        }
        while (true){
            Scanner scanner = new Scanner(System.in);
            int select = -1;
            try {
                select = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                continue;
            }
            notebookFilter.OS = Notebook.OSs[select];
            break;
        }
    }
    private static void selectColorOptions(){
        for (int i = 0; i < Notebook.colors.length; i++) {
            sb.setLength(0);
            sb.append(i + ". ");
            sb.append(Notebook.colors[i]);
            System.out.println(sb.toString());
        }
        while (true){
            Scanner scanner = new Scanner(System.in);
            int select = -1;
            try {
                select = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                continue;
            }
            notebookFilter.color = Notebook.colors[select];
            break;
        }
    }
    private static void printNotebookFiltered(){
        for (Notebook notebook : notebooks) {
            if (notebook.compareTo(notebookFilter) == 1) System.out.println(notebook.marketName);
        }
    }
}
