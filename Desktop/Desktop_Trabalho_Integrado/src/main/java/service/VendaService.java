import com.google.gson.Gson;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import dto.VendaDTO;

/**
 *
 * @author Daniel
 */
public class VendaService {
    private static String URLWEBSERVICE = "http://localhost:8080/vendas";
    private static int SUCESSO = 201; // 201 Created

    public static void criarVenda(VendaCreateDTO VendaDTO) throws Exception {
        try {
            URL url = new URL(URLWEBSERVICE);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("POST");
            conexao.setRequestProperty("Content-Type", "application/json");
            conexao.setDoOutput(true); // permite enviar o corpo da requisição

            Gson gson = new Gson();
            String json = gson.toJson(VendaDTO);

            // Escrevendo o corpo da requisição
            OutputStream outputStream = conexao.getOutputStream();
            outputStream.write(json.getBytes("UTF-8"));
            outputStream.flush();
            outputStream.close();

            int responseCode = conexao.getResponseCode();

            if (responseCode != SUCESSO) {
                throw new RuntimeException("Erro ao criar venda: HTTP " + responseCode + " - " + conexao.getResponseMessage());
            }

            System.out.println("Venda criada com sucesso!");

        } catch (Exception ex) {
            throw new Exception("Erro ao enviar venda: " + ex.getMessage(), ex);
        }
    }    
}
