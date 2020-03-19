package Controller;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class EdgeDetection {
    
    //diferite filtre ce vor fi utilizate pentru procesarea imaginilor
    //se poate realiza atat o conversie pe orizontala, cat si pe verticala - vezi documentatia
    public static final String HORIZONTAL_FILTER = "Horizontal Filter";
    public static final String VERTICAL_FILTER = "Vertical Filter";

    public static final String SOBEL_FILTER_VERTICAL = "Sobel Vertical Filter";
    public static final String SOBEL_FILTER_HORIZONTAL = "Sobel Horizontal Filter";

    public static final String SCHARR_FILTER_VETICAL = "Scharr Vertical Filter";
    public static final String SCHARR_FILTER_HORIZONTAL = "Scharr Horizontal Filter";

    private static final double[][] FILTER_VERTICAL = {{1, 0, -1}, {1, 0, -1}, {1, 0, -1}};
    private static final double[][] FILTER_HORIZONTAL = {{1, 1, 1}, {0, 0, 0}, {-1, -1, -1}};

    private static final double[][] FILTER_SOBEL_V = {{1, 0, -1}, {2, 0, -2}, {1, 0, -1}};
    private static final double[][] FILTER_SOBEL_H = {{1, 2, 1}, {0, 0, 0}, {-1, -2, -1}};

    private static final double[][] FILTER_SCHARR_V = {{3, 0, -3}, {10, 0, -10}, {3, 0, -3}};
    private static final double[][] FILTER_SCHARR_H = {{3, 10, 3}, {0, 0, 0}, {-3, -10, -3}};

    private final HashMap<String, double[][]> filterMap; //util pentru a alegerea filtrului selectat in form

    public EdgeDetection() {
        filterMap = buildFilterMap(1, 4, 6);
    }

    public File detectEdges(BufferedImage bufferedImage, String selectedFilter) throws IOException {
        double[][][] image = transformImageToArray(bufferedImage); //transformam imaginea intr-o matrice tridimensionala de forma [canal][linie][coloana]
        double[][] filter = filterMap.get(selectedFilter); //extragem matricea filtrului respectiv
        double[][] convolvedPixels = applyConvolution(bufferedImage.getWidth(),
                bufferedImage.getHeight(), image, filter); //aplicam convolutia si vom obtine o noua matrice tridimensionala de pixeli, dar transformata fata de cea initiala
        return createImageFromConvolutionMatrix(bufferedImage, convolvedPixels);//din matricea curenta realizam imaginea finala ce va fi trimisa spre output
    }

   private double[][][] transformImageToArray(BufferedImage bufferedImage) {
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        //bmp RGB => 3 canale: 0 - rosu, 1 - verde, 2 - albastru
        double[][][] image = new double[3][height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Color color = new Color(bufferedImage.getRGB(j, i));
                image[0][i][j] = color.getRed();
                image[1][i][j] = color.getGreen();
                image[2][i][j] = color.getBlue();
            }
        }
        return image;
    }

    private double[][] applyConvolution(int width, int height, double[][][] image, double[][] filter) {
        Convolution convolution = new Convolution(); //instanta de convolution pe care o vom folosi pentru transformare
        double[][] redConv = convolution.convolutionType2(image[0], height, width, filter, 3, 3, 1); //matrice de pixeli pentru canalul rosu
        double[][] greenConv = convolution.convolutionType2(image[1], height, width, filter, 3, 3, 1); // matrice pixeli canal verde
        double[][] blueConv = convolution.convolutionType2(image[2], height, width, filter, 3, 3, 1); //matrice pixeli canal albastru
        double[][] finalConv = new double[redConv.length][redConv[0].length]; //matricea finala in care vom regrupa cele 3 canale
        for (int i = 0; i < redConv.length; i++) {
            for (int j = 0; j < redConv[i].length; j++) {
                finalConv[i][j] = redConv[i][j] + greenConv[i][j] + blueConv[i][j];
            }
        }
        return finalConv;
    }

    private File createImageFromConvolutionMatrix(BufferedImage originalImage, double[][] imageRGB) throws IOException {
        //instanta de buffereimage in care vom pune imaginea finala procesata
        BufferedImage writeBackImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < imageRGB.length; i++) {
            for (int j = 0; j < imageRGB[i].length; j++) {
                Color color = new Color(fixOutOfRangeRGBValues(imageRGB[i][j]), //in cazul pixelilor ce ies din interval, se rectifica valoarea acetora
                        fixOutOfRangeRGBValues(imageRGB[i][j]),
                        fixOutOfRangeRGBValues(imageRGB[i][j]));
                writeBackImage.setRGB(j, i, color.getRGB()); //cu ajutorul matricei de pixeli primite dupa convolutie, vom obtine prin
                                                             //intermediul clasei Color imaginea procesata
            }
        }
       //salvam imaginea finala in functie de path-ul introdus de utilizator
       String str = getOutputName();
       File outputFile = new File(str);
       ImageIO.write(writeBackImage, "bmp", outputFile);
       return outputFile;
    }
    
    //pixelii nu pot avea alte valori decat din intervalul 0-255, astfel ca in cazul in care apar depasiri, se rectifica
    private int fixOutOfRangeRGBValues(double value) {
        
        if (value < 0.0) {
            value = 0;
        }
        if (value > 255) {
            return 255;
        } else {
            return (int) value;
        }
    }

    private HashMap<String, double[][]> buildFilterMap(int ... args) {
        HashMap<String, double[][]> filterMap;
        filterMap = new HashMap<>();
        filterMap.put(VERTICAL_FILTER, FILTER_VERTICAL);
        filterMap.put(HORIZONTAL_FILTER, FILTER_HORIZONTAL);

        filterMap.put(SOBEL_FILTER_VERTICAL, FILTER_SOBEL_V);
        filterMap.put(SOBEL_FILTER_HORIZONTAL, FILTER_SOBEL_H);

        filterMap.put(SCHARR_FILTER_VETICAL, FILTER_SCHARR_V);
        filterMap.put(SCHARR_FILTER_HORIZONTAL, FILTER_SCHARR_H);
        
        //varargs pentru a afisa numarul de filtre ce aplica conversie orizantala
        System.out.println("Varargs - argument length: " + args.length);
        System.out.println("Keys - Horizontal Filters: " + args[0] + " " + args[1] + " " + args[2]);
        
        return filterMap;
    }
    
    //metoda specifica pentru extragerea path-ului introdus de catre utilizator in consola
    //in caz de nume incorect, se incearca o noua introducere
    private String getOutputName() {
        String outputFilePath = null;
        try{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.println("Introdu numele.extenia si adresa fisierului in care se va salva noua imagine:");
        for(outputFilePath = br.readLine().toString(); !outputFilePath.endsWith(".bmp"); outputFilePath = br.readLine().toString()) {
                System.out.println("Fisierul nu are extensia potrivita. Introduceti un nume de fisier cu extensia .bmp");
        }
        }catch(IOException e) {
            System.out.println("Nu s-a realizat citirea corecta");
        }
        return outputFilePath;
    }


}
