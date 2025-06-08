import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import dto.ClienteDTO;

/**
 *
 * @author Daniel
 */
public class ClienteService {
    private static String URLWEBSERVICE = "http://localhost:8080/clientes";
    private static int SUCESSO = 200;

    public static List<ClienteDTO> buscaClientes() throws Exception {
        try {
            URL url = new URL(URLWEBSERVICE);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("GET");

            if (conexao.getResponseCode() != SUCESSO) {
                throw new RuntimeException("Erro ao conectar: " + conexao.getResponseMessage());
            }

            BufferedReader resposta = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            String json = converteJsonString(resposta);

            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<ClienteDTO>>() {}.getType();
            List<ClienteDTO> clientes = gson.fromJson(json, listType);

            return clientes;

        } catch (Exception ex) {
            throw new Exception("Erro ao buscar clientes: " + ex.getMessage(), ex);
        }
    }

    public static String converteJsonString(BufferedReader bufferReader) throws IOException {
        StringBuilder jsonString = new StringBuilder();
        String linha;
        while ((linha = bufferReader.readLine()) != null) {
            jsonString.append(linha);
        }
        return jsonString.toString();
    }
}
