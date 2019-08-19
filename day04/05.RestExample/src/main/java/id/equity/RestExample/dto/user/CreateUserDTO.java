package id.equity.RestExample.dto.user;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDTO extends UserDTO {


	private String passsword;
	private List<RoleUserDTO> roleId;

	@Builder
	public CreateUserDTO(String firstName, String lastName, String userName, String email, String passsword,
			List<RoleUserDTO> roleId) {
		super(firstName, lastName, userName, email);
		this.passsword = passsword;
		this.roleId = roleId;
	}
	
	
}
