package id.equity.RestExample.dto.user;

import java.io.Serializable;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateUserDTO extends UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String password;
	private List<RoleUserDTO> roleId;
	
}
