/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dto.VendaRequestDTO;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;

/**
 *
 * @author mateu
 */
public class VendaService {
  
    private static final String URL_WEBSERVICE = "http://localhost:8080/vendas";
    private static final int SUCESSO = 201;

    public static boolean enviarVenda(VendaRequestDTO venda) throws Exception {
        try {
            URL url = new URL(URL_WEBSERVICE);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("POST");
            conexao.setRequestProperty("Content-Type", "application/json");
            conexao.setDoOutput(true);

            Gson gson = new Gson();
            String json = gson.toJson(venda);

            OutputStream os = conexao.getOutputStream();
            os.write(json.getBytes());
            os.flush();
            os.close();

            return conexao.getResponseCode() == SUCESSO || conexao.getResponseCode() == 200;

        } catch (Exception e) {
            throw new Exception("Erro ao enviar venda: " + e.getMessage());
        }
    }
}
