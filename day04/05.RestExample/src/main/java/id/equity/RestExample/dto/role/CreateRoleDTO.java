package id.equity.RestExample.dto.role;

import lombok.Builder;
import lombok.NoArgsConstructor;
@NoArgsConstructor
public class CreateRoleDTO extends RoleDTO {
	@Builder
	public CreateRoleDTO(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
}
