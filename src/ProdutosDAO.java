import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep = null;
    ResultSet rs = null;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public boolean conectar(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/uc11", "ggdDev", "GuiProgramador21@!");
            return true;
        } catch(ClassNotFoundException | SQLException e){
            System.out.println("Falha na conexão com o banco de dados. " + e.getMessage());
            return false;
        }
    }
    
    public int cadastrarProduto (ProdutosDTO produto){
        int status;
        try{
            prep = conn.prepareStatement("INSERT INTO produtos(nome, valor, status) VALUES (?,?,?)");
            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getValor());
            prep.setString(3, produto.getStatus());
            status = prep.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sucesso ao inserir produto.");
            return status;
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Falha ao inserir produto.");
            System.out.println("Falha: " + e.getMessage());
            return e.getErrorCode();
        }
    }
    
    public ProdutosDTO listarProdutos(int id){
        try{
            ProdutosDTO pDTO = new ProdutosDTO();
            prep = conn.prepareStatement("SELECT * FROM produtos WHERE id = ?");
            prep.setInt(1, id);
            rs = prep.executeQuery();
            
            rs.next();
            
            pDTO.setId(id);
            pDTO.setNome(rs.getString("nome"));
            pDTO.setValor(rs.getInt("valor"));
            pDTO.setStatus(rs.getString("status"));
            
            return pDTO;
        } catch(SQLException e){
            System.out.println("Falha ao realizar busca de dados. " + e.getMessage());
            return null;
        }
    }
        
}

