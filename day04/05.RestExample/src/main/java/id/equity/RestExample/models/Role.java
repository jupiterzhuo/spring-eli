package id.equity.RestExample.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tbl_role")
public class Role {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @NotNull(message = "Name not empty")
    @NotEmpty(message = "nama Tidak boleh kosong")
    @Size(max = 100,message = "Name length is 100")
    @Column(name = "role_name",length = 100)
	private String name;
    
    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private List<User> users;
    

}
