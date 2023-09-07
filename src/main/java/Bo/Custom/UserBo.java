package Bo.Custom;

import Bo.SuperBo;
import dto.UserDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface UserBo extends SuperBo {
    public List<UserDTO> getAllUser() throws SQLException, ClassNotFoundException, IOException;
    public boolean addUser(UserDTO dto) throws SQLException, ClassNotFoundException, IOException;

    public boolean updateUser(UserDTO dto) throws SQLException, ClassNotFoundException, IOException;

    public boolean deleteUser(String id) throws SQLException, ClassNotFoundException, IOException;

    public String generateNewUserId() throws SQLException, ClassNotFoundException, IOException;
}
