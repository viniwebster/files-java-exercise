import entities.Product;

import java.io.*;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Product> list = new ArrayList<>();

        System.out.print("Insira o caminho do arquivo: ");
        String path = sc.next();
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                String[] newString = line.split(",");
                String name = newString[0];
                String price = newString[1];
                String qtd = newString[2];

                list.add(new Product(name, Double.parseDouble(price), Integer.parseInt(qtd)));
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.print("Insira onde deseja salvar o arquivo: ");
        String pathOutput = sc.next();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathOutput))) {
            for (Product product : list) {
                bw.write(product.getName() + ", " + String.format("%.2f", product.total()));
                bw.newLine();
            }
            System.out.println("Arquivo gerado com sucesso em: " + pathOutput);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}