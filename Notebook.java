import java.util.Random;

public class Notebook implements Comparable<Notebook> {
    public static int[] RAMs = new int[]{8, 16, 32, 64, 128};
    public static int[] HDDs = new int[]{1, 2, 3, 4, 5}; // in Tb
    public static String[] firstNames = new String[]{"Toshiba", "LG", "Apple", "Lemon"};
    public static String[] secondNames = new String[]{"S", "S+", "Poor Edition", "Golden Rain", "T1000", "T1000 asta-la-vista", "S++", "S#", "RGB Saber Razer Spiderman Limited Overprice Edition"};
    public static String[] OSs = new String[]{"Spywindows", "leen-UX", "Bubuntu", "youOS"};
    public static String[] colors = new String[]{"Black", "Gray", "Pink"};
    public int RAM = -1;
    public int HDD = -1;
    public String firstName = null;
    private String fullName = null;
    public String marketName = null;
    private StringBuilder marketNameBuilder = new StringBuilder();
    public String OS = null;
    public String color = null;
    
    public Notebook(){
        randomize();
    }
    public Notebook(boolean randomize){
        if (randomize) randomize();
    }
    private void randomize(){
        Random rnd = new Random();
        RAM = RAMs[rnd.nextInt(0, RAMs.length)];
        HDD = HDDs[rnd.nextInt(0, HDDs.length)];
        firstName = firstNames[rnd.nextInt(0, firstNames.length)];
        fullName = firstName + " " + secondNames[rnd.nextInt(0, secondNames.length)];
        OS = OSs[rnd.nextInt(0, OSs.length)];
        color = colors[rnd.nextInt(0, colors.length)];
        updateMarketName();
        System.out.println(marketName);
    }
    public void updateMarketName(){
        marketNameBuilder.setLength(0);
        int params = 0;
        if (firstName != null) {
            params++;
            marketNameBuilder.append(fullName);
        }
        if (RAM > -1){
            if (params > 0) marketNameBuilder.append(", ");
            params++;
            marketNameBuilder.append("RAM:" + RAM + "Gb");
        }
        if (HDD > -1){
            if (params > 0) marketNameBuilder.append(", ");
            params++;
            marketNameBuilder.append("HDD:" + HDD + "Tb");
        }
        if (OS != null) {
            if (params > 0) marketNameBuilder.append(", ");
            params++;
            marketNameBuilder.append(OS);
        }
        if (color != null) {
            if (params > 0) marketNameBuilder.append(", ");
            params++;
            marketNameBuilder.append(color);
        }
        if (params == 0) marketName = "Not specified";
        else marketName = marketNameBuilder.toString();
    }
    @Override 
    public int compareTo(Notebook notebookOther){
        if (notebookOther.RAM > -1 && notebookOther.RAM > RAM) return -1;
        if (notebookOther.HDD > -1 && notebookOther.HDD > HDD) return -1;
        if (notebookOther.firstName != null && !notebookOther.firstName.equals(firstName)) return -1;
        if (notebookOther.OS != null && !notebookOther.OS.equals(OS)) return -1;
        if (notebookOther.color != null && !notebookOther.color.equals(color)) return -1;
        return 1;
    }
}