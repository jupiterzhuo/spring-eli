package id.equity.RestExample.dto.user;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateUserDTO extends UserDTO {

	private String passsword;
	private List<RoleUserDTO> roleId;
}
