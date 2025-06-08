import com.google.gson.Gson;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import dto.ItemVendaDTO;


/**
 *
 * @author Daniel
 */
public class ItemVendaService {
    private static String URLWEBSERVICE = "http://localhost:8080/itens-venda";
    private static int SUCESSO = 201; // HTTP 201 Created

    public static void criarItemVenda(ItemVendaDTO itemDTO) throws Exception {
        try {
            URL url = new URL(URLWEBSERVICE);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("POST");
            conexao.setRequestProperty("Content-Type", "application/json");
            conexao.setDoOutput(true);

            Gson gson = new Gson();
            String json = gson.toJson(itemDTO);

            OutputStream outputStream = conexao.getOutputStream();
            outputStream.write(json.getBytes("UTF-8"));
            outputStream.flush();
            outputStream.close();

            int responseCode = conexao.getResponseCode();

            if (responseCode != SUCESSO) {
                throw new RuntimeException("Erro ao criar item de venda: HTTP " + responseCode + " - " + conexao.getResponseMessage());
            }

            System.out.println("Item de venda criado com sucesso!");

        } catch (Exception ex) {
            throw new Exception("Erro ao enviar item de venda: " + ex.getMessage(), ex);
        }
    }    
}
