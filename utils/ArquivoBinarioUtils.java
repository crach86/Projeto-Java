package utils;

import modelo.Financiamento;

import java.io.*;
import java.util.ArrayList;

public class ArquivoBinarioUtils {

    public static void salvarFinanciamentosSerializados(ArrayList<Financiamento> financiamentos, String caminho) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(caminho))) {
            out.writeObject(financiamentos);
            System.out.println("ArrayList serializado com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao serializar: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Financiamento> lerFinanciamentosSerializados(String caminho) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(caminho))) {
            ArrayList<Financiamento> lista = (ArrayList<Financiamento>) in.readObject();
            System.out.println("ArrayList lido da serialização com sucesso.");
            return lista;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao desserializar: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
