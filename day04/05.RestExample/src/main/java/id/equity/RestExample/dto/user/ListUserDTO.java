package id.equity.RestExample.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ListUserDTO extends UserDTO {
	private Long id;

	@Builder
	public ListUserDTO(String firstName, String lastName, String userName, String email, Long id) {
		super(firstName, lastName, userName, email);
		this.id = id;
	}
	
	
}
