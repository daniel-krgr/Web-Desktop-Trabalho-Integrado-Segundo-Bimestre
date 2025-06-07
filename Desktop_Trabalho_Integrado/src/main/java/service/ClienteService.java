/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import model.Cliente;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


/**
 *
 * @author mateu
 */
public class ClienteService {
 
     private static final String URL_WEBSERVICE = "http://localhost:8080/clientes";
    private static final int SUCESSO = 200;

    public static List<Cliente> buscarTodos() throws Exception {
        try {
            URL url = new URL(URL_WEBSERVICE);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            if (conexao.getResponseCode() != SUCESSO) {
                throw new RuntimeException("Erro ao conectar: " + conexao.getResponseMessage());
            }

            BufferedReader resposta = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            String json = converteJsonString(resposta);

            Gson gson = new Gson();
            return gson.fromJson(json, new TypeToken<List<Cliente>>(){}.getType());

        } catch (Exception e) {
            throw new Exception("Erro ao buscar clientes: " + e.getMessage());
        }
    }

    private static String converteJsonString(BufferedReader bufferReader) throws Exception {
        String linha;
        StringBuilder json = new StringBuilder();
        while ((linha = bufferReader.readLine()) != null) {
            json.append(linha);
        }
        return json.toString();
    }

}
