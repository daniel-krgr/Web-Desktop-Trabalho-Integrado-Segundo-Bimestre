package service;

import com.google.gson.Gson;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import dto.VendaDTO;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Daniel
 */
public class VendaService {
    private static String URLWEBSERVICE = "http://localhost:8080/vendas";
    private static int SUCESSO = 201; // 201 Created

    public static VendaDTO criarVenda(VendaDTO vendaDTO) throws Exception {
        try {
            URL url = new URL(URLWEBSERVICE);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("POST");
            conexao.setRequestProperty("Content-Type", "application/json");
            conexao.setRequestProperty("Accept", "application/json");
            conexao.setDoOutput(true);

            Gson gson = new Gson();
            String json = gson.toJson(vendaDTO);

            OutputStream outputStream = conexao.getOutputStream();
            outputStream.write(json.getBytes("UTF-8"));
            outputStream.flush();
            outputStream.close();

            int responseCode = conexao.getResponseCode();

            if (responseCode != SUCESSO) {
                throw new RuntimeException("Erro ao criar venda: HTTP " + responseCode + " - " + conexao.getResponseMessage());
            }

            // Ler a resposta JSON e convertê-la para VendaDTO
            BufferedReader reader = new BufferedReader(new InputStreamReader(conexao.getInputStream(), "UTF-8"));
            StringBuilder resposta = new StringBuilder();
            String linha;
            while ((linha = reader.readLine()) != null) {
                resposta.append(linha);
            }

            VendaDTO vendaCriada = gson.fromJson(resposta.toString(), VendaDTO.class);

            System.out.println("Venda criada com sucesso! ID: " + vendaCriada.getId());

            return vendaCriada;

        } catch (Exception ex) {
            throw new Exception("Erro ao enviar venda: " + ex.getMessage(), ex);
        }   
    }
}
