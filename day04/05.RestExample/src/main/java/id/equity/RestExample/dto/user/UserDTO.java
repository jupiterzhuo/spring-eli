package id.equity.RestExample.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public abstract class UserDTO {
	private String firstName;
	private String lastName;
	private String userName;
	private String email;
}
