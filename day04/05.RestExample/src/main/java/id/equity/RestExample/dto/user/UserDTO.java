package id.equity.RestExample.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
public abstract class UserDTO {
	private String firstName;
	private String lastName;
	private String userName;
	private String email;
}
